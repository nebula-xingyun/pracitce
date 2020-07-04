package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.Producer;
import cn.edu.usts.cs2018.entity.Worker;

import java.util.List;

public interface WorkerMapper {
    /**
     * Mybatis中与Customerxml文件绑定的接口.
     */
    //　按照ID查客户的方法
    public Worker getWorkerById(int id);

    public Worker selectByNamePwd(String name, String password);
    //　查所有表中客户的方法
    public List<Worker> selectAll();

    //　按指定条件，查所有表中客户的方法，参数strWhere是条件
    public List<Worker> select(String strWhere);
    //　添加客户
    public void add(Worker worker);

    //　更新客户
    public void update(Worker worker);

    //　通过ID删除客户
    public void deleteById(int id);

    public Worker findWorker(String username, String password);

}
