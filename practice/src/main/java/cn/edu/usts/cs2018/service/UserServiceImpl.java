package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.UserDAO;
import cn.edu.usts.cs2018.entity.User;
import cn.edu.usts.cs2018.entity.UserActivity;
import cn.edu.usts.cs2018.exception.RegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: JavaWebApp
 * @description: User的IService的实现类
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-03-07 15:52
 **/
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("UserDao")
    private UserDAO dao;

    /**
     * 新增User实体对象
     *
     * @param user
     * @param: User 实体对象
     * @return: 成功true，失败false
     */
    @Override
    public int insert(User user) {
        return dao.insert(user);
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
        return dao.update(user);
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
        return dao.delete(id);
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
    public User login(String name, String password) {
        return null;
    }

    @Override
    public User findUser(String username, String password) {
        User user = this.dao.findUser(username,password);
        return user;
    }

    @Override
    public int register(User user) {
return 0;
    }

    @Override
    public int regist(UserActivity user) throws RegisterException {
        return 0;
    }

    @Override
    public List<UserActivity> findSelf(int userid) {
        return null;
    }

    @Override
    public List<UserActivity> findActivity(int activityid) {
        return null;
    }

    @Override
    public UserActivity getUserById(int id) {
        return null;
    }


    //    public void setDao(UserDAO dao) {
//        this.dao = dao;
//    }
//
    public User login(User user) {
        return dao.login(user);
    }



}
