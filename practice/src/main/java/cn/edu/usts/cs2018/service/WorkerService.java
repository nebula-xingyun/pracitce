package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.entity.Producer;
import cn.edu.usts.cs2018.entity.Worker;
import cn.edu.usts.cs2018.exception.RegisterException;

import java.util.List;

public interface WorkerService {
    public Worker login(Worker worker);

    public int insert(Worker worker);

    public int update(Worker worker);
    public int update_producer(Producer producer);
    public int delete(Integer id);

    public Worker findByID(Integer id);

    public boolean saveOrUpdate(Worker worker);

    public long count();

    public List<Worker> findAll();

    public Worker login(String name, String password);

    public Worker findWorker(String username, String password);
    int register(Worker worker) throws RegisterException;

}
