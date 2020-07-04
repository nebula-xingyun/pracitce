package cn.edu.usts.cs2018.dao.base;

/**
 * @program: JavaWebApp
 * @description: DAO基础类
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-03-05 14:28
 **/

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 统一数据访问接口
 */
public interface IBaseDao<T, ID extends Serializable> {
    /**
     * 新增实体对象
     * @param: entity 实体对象
     * @return: 成功true，失败false
     */
    public boolean insert(T entity);

    /**
     * 更新实体对象
     * @param: entity
     * @return: 成功true，失败false
     */
    public boolean update(T entity);

    /**
     * 删除实体对象
     * @param: entity 实体对象
     * @return: 成功true，失败false
     */
    public boolean delete(T entity);

    /**
     * 通过id查询，返回唯一查询对象
     * @param: id 对象的id
     * @return: 对象T
     */
    public T findByID(ID id);

    /**
     * 保存或更新实体对象
     * @param: entity 实体对象
     * @return: 成功true，失败false
     */
    public boolean saveOrUpdate(T entity);

    /**
     * 根据条件查询，返回结果集(List)
     * @param: strSQL 查询语句
     * @return: 对象集合的List
     */
    public long count(String strSQL);

    /**
     * 根据条件查询，返回结果集(List)
     * @param: strSQL 查询语句
     * @return: 对象集合的List
     */
    public List<T> find(String strSQL);

    /**
     * 根据条件查询，返回结果集(List)
     * @param: strSQL 查询语句
     * @return: 对象集合的List
     */
    public List<T> query(String strSQL);

    /**
     * 根据条件查询，返回结果集(List)
     * @param: strSQL 查询语句
     * @param: params 条件参数
     * @return: 对象集合的List
     */
    public List<T> find(String strSQL, Object... params);

    /**
     * 调用存储过程，返回单结果集
     * @param: proceName 存储过程名称
     * @param: params 输入参数集合
     * @return: map对象结果集
     */
    public List<Map<String, Object>> callProcedure(String proceName, final List<Object> params);

    /**
     * @Description: 根据条件查询，返回结果集(List)
     * @param: strWhere 查询条件子句
     * @param: params 条件子句的参数
     * @param: orderBy 排序方式参数(ASC/DESC)
     * @return: 对象集合的List
     */
    public List<T> find(String strWhere, Object[] params, ORDERBY orderBy);


}
