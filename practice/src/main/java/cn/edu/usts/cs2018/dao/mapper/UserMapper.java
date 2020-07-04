package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.User;

import java.util.List;

public interface UserMapper {
    public User getUserById(int id);
    public User findUser(String name, String password);
    //　查所有表中客户的方法
    public List<User> selectAll();

    //　按指定条件，查所有表中客户的方法，参数strWhere是条件
    public List<User> select(String strWhere);
    //　添加客户
    public void add(User cust);

    //　更新客户
    public void update(User cust);

    //　通过ID删除客户
    public void deleteById(int id);
}
