package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.PayMapper;
import cn.edu.usts.cs2018.dao.mapper.UserMapper;
import cn.edu.usts.cs2018.entity.User;
import cn.edu.usts.cs2018.entity.UserActivity;
import cn.edu.usts.cs2018.exception.RegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: JavaWebApp
 * @description: User的IService的实现类
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-03-07 15:52
 **/
@Service(value = "userServiceMapper")
public class UserServiceImplforMapper implements UserService {
    @Autowired
    private UserMapper dao;

    @Autowired
    private PayMapper dao2;

    public void setDao(UserMapper dao) {
        this.dao = dao;
    }

    public void setDao(PayMapper dao) {
        this.dao2 = dao2;
    }

    @Override
    public User login(User user) {
        return null;
    }

    /**
     * 新增User实体对象
     *
     * @param user
     * @param: User 实体对象
     * @return: 成功true，失败false
     */
    @Override
    public int insert(User user) {
        return 0;
    }

    /**
     * 更新User实体对象
     *
     * @param user
     * @param: User 实体对象
     * @return: 成功true，失败false
     */
    @Override
    public int update(User user) {
        int result =1;
        try {
            dao.update(user);
        }
        catch (Exception ex) {
            result =0;
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return result;
    }

    /**
     * 删除User实体对象
     *
     * @param id
     * @param: id 实体对象id
     * @return: 成功true，失败false
     */
    @Override
    public int delete(Integer id) {

        int result =1;
        try {
            dao.deleteById(id);
        }
        catch (Exception ex) {
            result =0;
        }
        return result;
    }

    /**
     * 通过id查询，返回唯一查询User对象
     *
     * @param id
     * @param: id 对象的id
     * @return: 对象User
     */
    @Override
    public User findByID(Integer id) {
        return null;
    }

    /**
     * 保存或更新User实体对象
     *
     * @param entity
     * @param: entity 实体对象
     * @return: 成功true，失败false
     */
    @Override
    public boolean saveOrUpdate(User entity) {
        return false;
    }

    /**
     * 返回结果集记录数
     *
     * @return: 记录数
     */
    @Override
    public long count() {
        return 0;
    }

    /**
     * 根据条件查询，返回结果集(List)
     *
     * @param: strSQL 查询语句
     * @return: User对象集合的List
     */
    @Override
    public List<User> findAll() {
        return null;
    }

    /**
     * 根据name和password实现登录，返回登录成功的User对象
     *
     * @param name
     * @param password
     * @param: name, password
     * @return: 成功User对象, 失败为null
     */
    @Override
    public User login(String username, String password) {
        User user=null;
        try {

            if( dao.findUser(username,password)!=null) {
                user = new User(username, password);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return user;
    }

    @Override
    public User findUser(String username, String password) {
        return null;
    }

    public int register(User cust)throws RegisterException    // 增加(增)
    {
        int result =1;
        try {
            dao.add(cust);
        }
        catch (Exception ex) {
            result =0;
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return result;
    }

    @Override
    public int regist(UserActivity user) throws RegisterException {
        int result =1;
        try {
            dao2.add(user);
        }
        catch (Exception ex) {
            result =0;
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return result;
    }

    @Override
    public List<UserActivity> findSelf(int userid) {
        List<UserActivity> list = null;
        UserActivity book = new UserActivity();
        try {
            list = dao2.findSelf(userid);
//           输出数组
            for(int j = 0;j<list.size();j++){
                if (list.get(j) != null) {
                    book = list.get(j);
                    System.out.println(book);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return list;
    }

    @Override
    public List<UserActivity> findActivity(int activityid) {
        List<UserActivity> list = null;
        UserActivity book = new UserActivity();
        try {
            list = dao2.findActivity(activityid);
//           输出数组
            for(int j = 0;j<list.size();j++){
                if (list.get(j) != null) {
                    book = list.get(j);
                    System.out.println(book);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return list;
    }

    @Override
    public UserActivity getUserById(int id) {

        UserActivity book = new UserActivity();
        try {
            book = dao2.getUserById(id);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return book;
    }


}
