package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.ProducerMapper;
import cn.edu.usts.cs2018.dao.mapper.WorkerMapper;
import cn.edu.usts.cs2018.entity.Producer;
import cn.edu.usts.cs2018.entity.Worker;
import cn.edu.usts.cs2018.exception.RegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "workerServiceMapper")
public class WorkerServiceImplforMapper implements WorkerService {

    @Autowired
    private WorkerMapper dao;
    public void setDao(WorkerMapper dao) {
        this.dao = dao;
    }
    @Autowired
    private ProducerMapper dao2;
    public void setDao2(ProducerMapper dao2) {
        this.dao2 = dao2;
    }

    @Override
    public Worker login(Worker worker) {
        return null;
    }

    @Override
    public int insert(Worker worker) {
        return 0;
    }

    @Override
    public int update(Worker worker) {
        int result =1;
        try {
            dao.update(worker);
        }
        catch (Exception ex) {
            result =0;
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return result;
    }

    @Override
    public int update_producer(Producer producer) {
        int result =1;
        try {
            dao2.update_producer(producer);
        }
        catch (Exception ex) {
            result =0;
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return result;
    }

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

    @Override
    public Worker findByID(Integer id) {
        return null;
    }

    @Override
    public boolean saveOrUpdate(Worker worker) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Worker> findAll() {
        return null;
    }

    @Override
    public Worker login(String name, String password) {
        Worker user=null;
        try {

            if( dao.findWorker(name,password)!=null) {
                user = new Worker(name, password);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return user;
    }

    public Worker findWorker(String username, String password) {
        return null;
    }

    @Override
    public int register(Worker worker) throws RegisterException {
        int result =1;
        try {
            dao.add(worker);
        }
        catch (Exception ex) {
            result =0;
        }

//        int i=1/0; //模拟添加操作后系统突然出现的异常问题,如果开启事务，则放弃当前操作。
        return result;
    }
}
