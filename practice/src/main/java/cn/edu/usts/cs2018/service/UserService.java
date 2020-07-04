package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.entity.User;
import cn.edu.usts.cs2018.entity.UserActivity;
import cn.edu.usts.cs2018.exception.RegisterException;

import java.util.List;

public interface UserService {
    public User login(User user);

    public int insert(User user);

    public int update(User user);

    public int delete(Integer id);

    public User findByID(Integer id);

    public boolean saveOrUpdate(User entity);

    public long count();

    public List<User> findAll();

    public User login(String name, String password);

    public User findUser(String username, String password);
    int register(User user) throws RegisterException;

    int regist(UserActivity user) throws RegisterException;
    public List<UserActivity> findSelf(int userid);
    public List<UserActivity> findActivity(int activityid);
    public UserActivity getUserById(int id);
}
