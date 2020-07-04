package cn.edu.usts.cs2018.dao.base;

import cn.edu.usts.cs2018.entity.Activity;

import java.util.List;

public interface ActivityDao {

    public int insert(Activity activity);

    public int insert(List<Activity> list);


    public int update(Activity activity);

    public int delete(Integer id);


    public int saveOrUpdate(Activity activity);


    public List<Activity> findAll();


    public Activity selectByActivityid(Integer activityid);

    public Activity selectByActivityname(String activityname);

    public List<Activity> find(String strWhere, Object[] params, ORDERBY orderBy);

    public long count(String strWhere);
}
