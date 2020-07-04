package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.UserActivity;

import java.util.List;

public interface PayMapper {

    public UserActivity getUserById(int id);
    public UserActivity findUser(String name, String password);
    //　查所有表中客户的方法
    public List<UserActivity> selectAll();

    public List<UserActivity> findSelf(int userid);
    public List<UserActivity> findActivity(int activityid);
    //　按指定条件，查所有表中客户的方法，参数strWhere是条件
    public List<UserActivity> select(String strWhere);
    //　添加客户
    public void add(UserActivity cust);

    //　更新客户
    public void update(UserActivity cust);

    //　通过ID删除客户
    public void deleteById(int id);
}
