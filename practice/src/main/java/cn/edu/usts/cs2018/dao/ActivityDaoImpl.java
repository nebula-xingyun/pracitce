package cn.edu.usts.cs2018.dao;

import cn.edu.usts.cs2018.dao.base.ActivityDao;
import cn.edu.usts.cs2018.dao.base.ORDERBY;
import cn.edu.usts.cs2018.entity.Activity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

//@Repository(value = "bookDao")
public class ActivityDaoImpl implements ActivityDao {
    //@Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;// 声明JdbcTemplate属性及其setter方法

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insert(List<Activity> list) {
        int result=0;
        for(Activity activity:list){
            if(insert(activity) == 1) {
                result ++;
            }
        }
        return result;
    }


    @Override
    public int insert(Activity activity) {
        int result = 0;
        String sql = "INSERT INTO activity(activityid,userid,username,activityname, activityplace,start_time,end_time,general_budget,description,min_member,max_member,create_time,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        // 定义数组来存放SQL语句中的参数
        Object[] params = new Object[]{
               activity.getActivityid(),
                activity.getUserid(),
                activity.getUsername(),
                activity.getActivityname(),
                activity.getActivityplace(),
                activity.getStart_time(),
                activity.getEnd_time(),
                activity.getGeneral_budget(),
                activity.getDescription(),
                activity.getMin_member(),
                activity.getMax_member(),
                activity.getCreate_time(),
                activity.getStatus()
        };
        try {
            // 执行添加操作，返回的是受SQL语句影响的记录条数
            result = this.jdbcTemplate.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*@Override
    public User login(User user) {

        String strSQL = "SELECT * FROM users WHERE userName=?  AND  password=? ;";

        Object[] params = {user.getUserName(), user.getPassword()};

        System.out.println(user);
        return findOneUser(strSQL, params);
    }
*/



    @Override
    public int delete(Integer id) {
        int result = 0;
        String sql = "Delete From activity Where activityid=?";
        try {
            result = this.jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Activity activity) {
        return saveOrUpdate(activity);

    }





    @Override
    public int saveOrUpdate(Activity activity) {
        int result = 0;
        String sql = "Update activity Set  userid=?,username=?,activityname=?, activityplace=?,start_time=?,end_time=?,general_budget=?,description=?,min_member=?,max_member=?,create_time=?,status=?  Where activityid=?";
        // 定义数组来存放SQL语句中的参数
        Object[] params = new Object[]{

                activity.getUserid(),
                activity.getUsername(),
                activity.getActivityname(),
                activity.getActivityplace(),
                activity.getStart_time(),
                activity.getEnd_time(),
                activity.getGeneral_budget(),
                activity.getDescription(),
                activity.getMin_member(),
                activity.getMax_member(),
                activity.getCreate_time(),
                activity.getStatus(),
                activity.getActivityid()
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
    public List<Activity> findAll() {

        return find( "",null, ORDERBY.ASC);
    }

    public List<Activity> find(String strWhere, Object[] params) {
        return find(strWhere, params, ORDERBY.ASC);
    }

    @Override
    public Activity selectByActivityname(String activityname) {
        String strSQL = "SELECT * FROM activity WHERE activityname=?  ";
        return findOneUser(strSQL, new Object[]{activityname});
    }

    @Override
    public Activity selectByActivityid(Integer activityid) {
        String strSQL = "SELECT * FROM activity WHERE activityid=?  ";
        return findOneUser(strSQL, new Object[]{activityid});
    }
    @Override
    public List<Activity> find(String strWhere, Object[] params, ORDERBY orderBy) {

        List<Activity> list = null;
        String strOrderBy = (orderBy == ORDERBY.ASC) ? "ASC" : "DESC";
        String strSQL = "SELECT * FROM activity ";
        if (strWhere != null)
            strSQL += strWhere + " ORDER BY id " + strOrderBy;
        else
            strSQL += " ORDER BY id " + strOrderBy;

        try {

            //创建一个新的BeanPropertyRowMapper对象

            RowMapper<Activity> rowMapper =
                    new BeanPropertyRowMapper<Activity>(Activity.class);

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


    private Activity findOneUser(String strSQL, Object[] params) {

        Activity activity = null;

        try {

            //创建一个新的BeanPropertyRowMapper对象类Class

            RowMapper<Activity> rowMapper =
                    new BeanPropertyRowMapper<Activity>(Activity.class);

            //将params绑定到SQL语句中，并通过RowMapper返回- 1Customer类型的单行记录

            activity = this.jdbcTemplate.queryForObject(strSQL, rowMapper, params);

        } catch (Exception e) {
            //e. printStackTrace();
            System.out.println("查询书籍:" + params[0] + ",操作失败。");
        }

        return activity;

    }


    @Override
    public long count(String strWhere) {
        int total = 0;
        String strSQL = "SELECT COUNT(*) AS count FROM activity ";
        if (strWhere != null)
            strSQL += strWhere;
        try {
            total = this.jdbcTemplate.queryForObject(strSQL, Integer.class);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return total;
    }
}