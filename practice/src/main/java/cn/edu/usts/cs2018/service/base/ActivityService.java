package cn.edu.usts.cs2018.service.base;

import cn.edu.usts.cs2018.entity.Activity;
import cn.edu.usts.cs2018.exception.RegisterException;

import java.util.List;

public interface ActivityService {
    public int update(Activity activity);
    public int delete(Integer id);
    public int saveOrUpdate(Activity activity);
    public List<Activity> viewAll();
    public int insert(Activity activity);
    public Activity selectByActivityname(String activityname);
    public Activity selectByActivityid(Integer activityid);
    public int register(Activity activity)throws RegisterException;
}
