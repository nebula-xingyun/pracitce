package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.base.ActivityDao;
import cn.edu.usts.cs2018.entity.Activity;
import cn.edu.usts.cs2018.exception.RegisterException;
import cn.edu.usts.cs2018.service.base.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value ="activityService")
public class ActivityServiceImpl implements ActivityService {

   // @Autowired
   // @Qualifier("bookDao")
    private ActivityDao dao;

    public void setDao(ActivityDao dao) {
            this.dao = dao;
        }

    @Override
    public int update(Activity activity) {
        return dao.update(activity);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }


    @Override
    public int saveOrUpdate(Activity activity) {
        return dao.saveOrUpdate(activity);
    }


    @Override
    public int insert(Activity activity) {
        return dao.insert(activity);
    }

    public Activity selectByActivityname(String activityname){

        return dao.selectByActivityname(activityname);
    }

    @Override
    public Activity selectByActivityid(Integer activityid) {
        return dao.selectByActivityid(activityid);
    }

    public List<Activity> viewAll(){
        System.out.println("invoke viewAll...");
        return dao.findAll();
    }

    public int register(Activity activity)throws RegisterException    // 增加(增)
    {
        int result =1;
        try {
            dao.insert(activity);
        }
        catch (Exception ex) {
            result =0;
        }

        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return result;
    }



}

