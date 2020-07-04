package cn.edu.usts.cs2018.dao;

import cn.edu.usts.cs2018.dao.base.ORDERBY;
import cn.edu.usts.cs2018.entity.User;

import java.util.List;

public interface UserDAO {
    public int insert(List<User> list) ;
    public int insert(User user);
    public User login(User user);
    public int delete(Integer id);
    public int update(User user);
    public User findById(Integer id);
    public int saveOrUpdate(User user);
    public List<User> findAll();
    public List<User> find(String strWhere, Object[] params);
    public User selectByName(String userName);
    public User selectByNamePwd(String name, String password) ;
    public List<User> find(String strWhere, Object[] params, ORDERBY orderBy) ;
    public long count(String strWhere) ;
    public User findUser(String username, String password);
    User findByID(Integer id);
    public String findAllBill();

    List<User> find(String strSQL);
    public int insertBill(Integer userid, Integer activityid);
    public List selectUserid(Integer activityid);
}
