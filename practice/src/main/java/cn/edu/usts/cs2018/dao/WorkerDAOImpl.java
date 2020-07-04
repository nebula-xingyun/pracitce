package cn.edu.usts.cs2018.dao;

import cn.edu.usts.cs2018.dao.base.ORDERBY;
import cn.edu.usts.cs2018.entity.Producer;
import cn.edu.usts.cs2018.entity.Worker;
import cn.edu.usts.cs2018.utils.Pagination;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "WorkerDao")
public class WorkerDAOImpl implements WorkerDAO {
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;// 声明JdbcTemplate属性及其setter方法

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(List<Worker> list) {
		int result=0;
		for(Worker user:list){
			if(insert(user) == 1) {
				result ++;
			}
		}
		return result;
	}


	@Override
	public int insert(Worker user) {
		int result=0;

		String strSQL = "INSERT INTO worker(number,name,password, telephone,work_count) VALUES (?,?,?,?,?)" ;
		result = MySQLDBHelper.executeNonQuery(strSQL,
				new Object[] {
						user.getNumber(),
						user.getName(),
						user.getPassword(),
						user.getTelephone(),
						user.getWork_count()}
		);

		return result;
	}


	@Override
	public Worker login(Worker user) {

		String strSQL = "SELECT * FROM worker WHERE name=?  AND  password=? ;";

		Object[] params = {user.getName(), user.getPassword()};

		System.out.println(user);
		return findOneUser(strSQL, params);
	}




	@Override
	public int delete(Integer id) {
		int result = 0;
		String sql = "Delete From worker Where number=?";
		try {
			result = this.jdbcTemplate.update(sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Worker user) {
		return saveOrUpdate(user);

	}

	@Override
	public int update_producer(Producer producer) {
		return saveOrUpdate2(producer);
	}

	@Override
	public Worker findById(Integer id) {
		String strSQL = "SELECT * FROM member WHERE activityid=?  ";
		return findOneUser(strSQL, new Object[]{id});
	}

	@Override
	public List<Worker> find(String strSQL) {
		ResultSet rs = null;
		List<Worker>  list = null;
		try
		{
			rs = MySQLDBHelper.executeQuery(strSQL);
			//取各个记录
			if(rs != null) {
				list = resultSetToList2(rs);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



	private List<Worker> resultSetToList2(ResultSet rs ) throws SQLException {
		List<Worker> list = new ArrayList<Worker>();
		Worker  user;
		while(rs.next()){
			// 构造Book对象，存储到list,方法用:list.add(Book对象)
			user = new Worker(
					rs.getString("number"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getString("telephone"),
					rs.getString("work_count")
			);
			list.add(user);
		}
		return list;
	}


	private List<Worker> resultSetToList(ResultSet rs ) throws SQLException {
		List<Worker> list = new ArrayList<Worker>();
		Worker user;
		while(rs.next()){
			// 构造Book对象，存储到list,方法用:list.add(Book对象)
			user = new Worker(
					rs.getString("number"),
					rs.getString("name"),
					rs.getString("password"),
					rs.getString("telephone"),
					rs.getString("work_count")
			);
			list.add(user);
		}
		return list;
	}
	@Override
	public int saveOrUpdate(Worker user) {
		int result = 0;
		String sql = "Update worker Set name=?,password=?,telephone=?,work_count=? Where number=?";
		// 定义数组来存放SQL语句中的参数
		Object[] params = new Object[]{
				user.getNumber(),
				user.getName(),
				user.getPassword(),
				user.getTelephone(),
				user.getWork_count()
		};
		try {
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			result = this.jdbcTemplate.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public int saveOrUpdate2(Producer producer) {
		int result = 0;
		String sql = "Update producer Set workshopNo=?,producerNo=?,status=? Where id=?";
		// 定义数组来存放SQL语句中的参数
		Object[] params = new Object[]{
				producer.getId(),
				producer.getWorkshopNo(),
				producer.getProducerNo(),
				producer.getStatus()
		};
		try {
			// 执行添加操作，返回的是受SQL语句影响的记录条数
			result = this.jdbcTemplate.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Worker> findAll() {

		return find( "",null, ORDERBY.ASC);
	}

	public List<Worker> find(String strWhere, Object[] params) {
		return find(strWhere, params, ORDERBY.ASC);
	}


	@Override
	public Worker selectByName(String userName) {
		String strSQL = "SELECT * FROM worker WHERE name=?  ";
		return findOneUser(strSQL, new Object[]{userName});
	}

	@Override
	public Worker selectByNamePwd(String name, String password) {
		String strSQL = "SELECT * FROM worker WHERE name=?  AND password=?";
		Object[] params = {
				name,
				password
		};
		return findOneUser(strSQL, params);

	}
	@Override
	public List<Worker> find(String strWhere, Object[] params, ORDERBY orderBy) {

		List<Worker> list = null;
		String strOrderBy = (orderBy == ORDERBY.ASC) ? "ASC" : "DESC";
		String strSQL = "SELECT * FROM worker ";
		if (strWhere != null)
			strSQL += strWhere + " ORDER BY id " + strOrderBy;
		else
			strSQL += " ORDER BY id " + strOrderBy;

		try {

			//创建一个新的BeanPropertyRowMapper对象

			RowMapper<Worker> rowMapper =
					new BeanPropertyRowMapper<Worker>(Worker.class);

			//执行静态的SQL查询，并通过RowMapper返回结果

			if (params != null) {

				list = this.jdbcTemplate.query(strSQL, rowMapper, params);

			} else

				list = this.jdbcTemplate.query(strSQL, rowMapper);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	public Worker findOneUser(String strSQL, Object[] params) {

		Worker user = null;

		try {

			//创建一个新的BeanPropertyRowMapper对象类Class

			RowMapper<Worker> rowMapper =
					new BeanPropertyRowMapper<Worker>(Worker.class);

			//将params绑定到SQL语句中，并通过RowMapper返回- 1Customer类型的单行记录

			user = this.jdbcTemplate.queryForObject(strSQL, rowMapper, params);

		} catch (Exception e) {
			//e. printStackTrace();
			System.out.println("查询员工:" + params[0] + ",操作失败。");
		}

		return user;

	}

	@Override
	public String findAllProducer() {

		ResultSet rs = null;
		List<Producer>  list = null;
		try
		{
			rs =  MySQLDBHelper.executeQuery("SELECT DISTINCT  * FROM producer");
			//取各个记录
			if(rs != null) {
				list = resultSetToList_Producer(rs);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		String jsonList = JSON.toJSONString(list);
		return jsonList;
	}

	private List<Producer> resultSetToList_Producer(ResultSet rs ) throws SQLException {
		List<Producer> list = new ArrayList<Producer>();
		Producer user;
		while(rs.next()){
			// 构造Book对象，存储到list,方法用:list.add(Book对象)
			user = new Producer(
					rs.getInt("id"),
					rs.getString("workshopNo"),
					rs.getString("producerNo"),
					rs.getString("status")
			);
			list.add(user);
		}
		return list;
	}
	@Override
	public Worker findUser(String username, String password) {
		return null;
	}

	@Override
	public Worker findByID(Integer id) {
		return null;
	}


}
