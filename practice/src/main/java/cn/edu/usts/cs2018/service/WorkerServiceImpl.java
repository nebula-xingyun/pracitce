package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.WorkerDAO;
import cn.edu.usts.cs2018.entity.Producer;
import cn.edu.usts.cs2018.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "workerService")
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    @Qualifier("WorkerDao")
    private WorkerDAO dao;

    /**
     * 新增User实体对象
     *
     * @param user
     * @param: User 实体对象
     * @return: 成功true，失败false
     */
    @Override
    public int insert(Worker user) {
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
    public int update(Worker user) {
        return dao.update(user);
    }

    @Override
    public int update_producer(Producer producer) {
        return dao.update_producer(producer);
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
    public Worker findByID(Integer id) {
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
    public boolean saveOrUpdate(Worker entity) {
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
    public List<Worker> findAll() {
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
    public Worker login(String name, String password) {
        return null;
    }

    @Override
    public Worker findWorker(String username, String password) {
        Worker user = this.dao.findUser(username,password);
        return user;
    }

    @Override
    public int register(Worker user) {
        return 0;
    }



    //    public void setDao(UserDAO dao) {
//        this.dao = dao;
//    }
//
    public Worker login(Worker user) {
        return dao.login(user);
    }



}

