package cn.edu.usts.cs2018.dao;
import cn.edu.usts.cs2018.dao.base.ORDERBY;
import cn.edu.usts.cs2018.entity.Bill;
import cn.edu.usts.cs2018.entity.User;
import com.alibaba.fastjson.JSON;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
        * @program: JavaWebApp
        * @description: User类的Dao实现
        * @author: Mr.Lu, DCE, USTS.
        * @create: 2020-03-07 15:45
        **/
@Repository(value = "UserDao")
public class UserDaoImpl implements UserDAO {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;// 声明JdbcTemplate属性及其setter方法

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(List<User> list) {
        int result=0;
        for(User user:list){
            if(insert(user) == 1) {
                result ++;
            }
        }
        return result;
    }


    @Override
    public int insert(User user) {
//        int result = 0;
//        String sql = "INSERT INTO user(userid,username,password, telephone,address) VALUES (?,?,?,?,?)";
//        // 定义数组来存放SQL语句中的参数
//        Object[] params = new Object[]{
//                user.getUserid(),
//                user.getUsername(),
//                user.getPassword(),
//                user.getTelephone(),
//                user.getAddress()
//        };
//        try {
//            // 执行添加操作，返回的是受SQL语句影响的记录条数
//            result = this.jdbcTemplate.update(sql, params);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
        int result=0;

        String strSQL = "INSERT INTO user(userid,username,password, telephone,address) VALUES (?,?,?,?,?)" ;
        result = MySQLDBHelper.executeNonQuery(strSQL,
                new Object[] {
                        new Integer(user.getUserid()),
                user.getUsername(),
                user.getPassword(),
                user.getTelephone(),
                user.getAddress()}
        );

        return result;
     }


    @Override
    public User login(User user) {

        String strSQL = "SELECT * FROM user WHERE username=?  AND  password=? ;";

        Object[] params = {user.getUsername(), user.getPassword()};

        System.out.println(user);
        return findOneUser(strSQL, params);
    }




    @Override
    public int delete(Integer id) {
        int result = 0;
        String sql = "Delete From user Where userid=?";
        try {
            result = this.jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(User user) {
        return saveOrUpdate(user);

    }

    @Override
    public User findById(Integer id) {
        String strSQL = "SELECT * FROM member WHERE activityid=?  ";
        return findOneUser(strSQL, new Object[]{id});
    }

    @Override
    public String findAllBill() {

        ResultSet rs = null;
        List<Bill>  list = null;
        try
        {
//            rs = MySQLDBHelper.executeQuery("select * from bill");
//去除重复行
//            rs = MySQLDBHelper.executeQuery("SELECT DISTINCT * FROM bill");
//            rs = MySQLDBHelper.executeQuery("select * from bill  m where (select count(*) from bill n where m.userid = n.userid and m.total < n.total) <= 1 and price is not null;");

            rs =  MySQLDBHelper.executeQuery("SELECT DISTINCT  * FROM bill");
            //取各个记录
            if(rs != null) {
                list = resultSetToList(rs);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        String jsonList = JSON.toJSONString(list);
        return jsonList;
    }

    @Override
    public List<User> find(String strSQL) {
        ResultSet rs = null;
        List<User>  list = null;
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

    @Override
    public int insertBill(Integer userid, Integer activityid) {

        int result=0;

//        String strSQL = "insert into bill(activityid, userid, username,total,self_budget)\n" +
//                "select expenditure.activityid,expenditure.userid ,expenditure.username,expenditure.pay,member.self_budget\n" +
//                "from  expenditure,member where expenditure.userid=member.userid" ;
        String strSQL ="insert into bill(activityid, userid, username,total,self_budget,price)\n" +
                "                select expenditure.activityid,expenditure.userid ,expenditure.username,sum(expenditure.pay),member.self_budget,self_budget-sum(expenditure.pay)\n" +
                "                from  expenditure,member where expenditure.userid=? and member.userid=? and expenditure.activityid=? and member.activityid=?;";
        Object[] params = new Object[]{userid,userid,activityid,activityid
        };
        result = MySQLDBHelper.executeNonQuery(strSQL,params);


        return result;
    }

    @Override
    public List selectUserid(Integer activityid) {
        String strSQL = "select * from member where activityid=?";
        Object[] params = new Object[]{activityid};
        ResultSet rs = MySQLDBHelper.executeQuery(strSQL, params);

        List<String> list = new ArrayList<String>();//创建取结果的列表，之所以使用列表，不用数组，因为现在还不知道结果有多少，不能确定数组长度，所有先用list接收，然后转为数组
        try {
            while (rs.next()) {//如果有数据，取第一列添加如list
                    list.add(rs.getString(2));
                }
                if (list != null && list.size() > 0) {//如果list中存入了数据，转化为数组
                    String[] arr = new String[list.size()];//创建一个和list长度一样的数组
                    for (int i = 0; i < list.size(); i++) {
                        arr[i] = list.get(i);//数组赋值了。
                    }
                    //输出数组
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        return list;
        }
    private List<User> resultSetToList2(ResultSet rs ) throws SQLException {
        List<User> list = new ArrayList<User>();
        User user;
        while(rs.next()){
            // 构造Book对象，存储到list,方法用:list.add(Book对象)
            user = new User(
                    rs.getInt("userid"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("telephone"),
                    rs.getString("address")
            );
            list.add(user);
        }
        return list;
    }


    private List<Bill> resultSetToList(ResultSet rs ) throws SQLException {
        List<Bill> list = new ArrayList<Bill>();
        Bill user;
        while(rs.next()){
            // 构造Book对象，存储到list,方法用:list.add(Book对象)
            user = new Bill(
                    rs.getInt("activityid"),
                    rs.getInt("userid"),
                    rs.getString("username"),
                    rs.getFloat("total"),
                    rs.getFloat("self_budget"),
                    rs.getFloat("price")
            );
            list.add(user);
        }
        return list;
    }
    @Override
    public int saveOrUpdate(User user) {
        int result = 0;
        String sql = "Update user Set  username=?,password=?,telephone=?,address=? Where userid=?";
        // 定义数组来存放SQL语句中的参数
        Object[] params = new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getTelephone(),
                user.getAddress(),
                user.getUserid()
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
    public List<User> findAll() {

        return find( "",null, ORDERBY.ASC);
    }

    public List<User> find(String strWhere, Object[] params) {
        return find(strWhere, params, ORDERBY.ASC);
    }


    @Override
    public User selectByName(String userName) {
        String strSQL = "SELECT * FROM user WHERE usrename=?  ";
        return findOneUser(strSQL, new Object[]{userName});
    }

    @Override
    public User selectByNamePwd(String name, String password) {
        String strSQL = "SELECT * FROM user WHERE username=?  AND password=?";
        Object[] params = {
                name,
                password
        };
        return findOneUser(strSQL, params);

    }
    @Override
    public List<User> find(String strWhere, Object[] params, ORDERBY orderBy) {

        List<User> list = null;
        String strOrderBy = (orderBy == ORDERBY.ASC) ? "ASC" : "DESC";
        String strSQL = "SELECT * FROM user ";
        if (strWhere != null)
            strSQL += strWhere + " ORDER BY userid " + strOrderBy;
        else
            strSQL += " ORDER BY userid " + strOrderBy;

        try {

            //创建一个新的BeanPropertyRowMapper对象

            RowMapper<User> rowMapper =
                    new BeanPropertyRowMapper<User>(User.class);

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


    public User findOneUser(String strSQL, Object[] params) {

        User user = null;

        try {

            //创建一个新的BeanPropertyRowMapper对象类Class

            RowMapper<User> rowMapper =
                    new BeanPropertyRowMapper<User>(User.class);

            //将params绑定到SQL语句中，并通过RowMapper返回- 1Customer类型的单行记录

            user = this.jdbcTemplate.queryForObject(strSQL, rowMapper, params);

        } catch (Exception e) {
            //e. printStackTrace();
            System.out.println("查询客户:" + params[0] + ",操作失败。");
        }

        return user;

    }


    @Override
    public long count(String strWhere) {
        int total = 0;
        String strSQL = "SELECT COUNT(*) AS count FROM user ";
        if (strWhere != null)
            strSQL += strWhere;
        try {
            total = this.jdbcTemplate.queryForObject(strSQL, Integer.class);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return total;
    }

    @Override
    public User findUser(String username, String password) {
        return null;
    }

    @Override
    public User findByID(Integer id) {
        return null;
    }
}




