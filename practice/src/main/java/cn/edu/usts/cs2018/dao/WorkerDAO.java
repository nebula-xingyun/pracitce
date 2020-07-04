package cn.edu.usts.cs2018.dao;


import cn.edu.usts.cs2018.dao.base.ORDERBY;
import cn.edu.usts.cs2018.entity.Producer;
import cn.edu.usts.cs2018.entity.Worker;
import cn.edu.usts.cs2018.utils.Pagination;

import java.util.List;

public interface WorkerDAO {
	public int insert(List<Worker> list) ;
	public int insert(Worker worker);
	public Worker login(Worker worker);
	public int delete(Integer id);
	public int update(Worker worker);
	public int update_producer(Producer producer);
	public Worker findById(Integer id);
	public int saveOrUpdate(Worker worker);
	public List<Worker> findAll();
	public List<Worker> find(String strWhere, Object[] params);
	public Worker selectByName(String userName);
	public Worker selectByNamePwd(String name, String password) ;
	public List<Worker> find(String strWhere, Object[] params, ORDERBY orderBy) ;
	public Worker findUser(String username,String password);
	Worker findByID(Integer id);
	public String findAllProducer();
	List<Worker> find(String strSQL);

	/**
	 * @description: 分页功能
	 * @param: [currentpage, rows, viewperpage] 当前页数、每页显示的记录数、可以显示多少页
	 * @return: cn.edu.usts.cs2018.utils.Pagination
	 */
//	public Pagination getPagination(int currentpage , int  rows , int viewperpage) ;
}
