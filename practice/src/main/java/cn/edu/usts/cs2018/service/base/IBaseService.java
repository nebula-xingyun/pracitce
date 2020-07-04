package cn.edu.usts.cs2018.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @program: JavaWebApp
 * @description: Service基础接口
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-03-07 15:53
 **/
public interface IBaseService <T, ID extends Serializable> {
    /**
     * 新增实体对象
     * @param entity 实体对象
     * @return 成功true，失败false
     */
    public boolean insert(T entity);

    /**
     * 更新实体对象
     * @param entity
     * @return 成功true，失败false
     */
    public boolean update(T entity);

    /**
     * 删除实体对象
     * @param entity 实体对象
     * @return 成功true，失败false
     */
    public boolean delete(T entity);

    /**
     * 通过id查询，返回唯一查询对象
     * @param id 对象的id
     * @return 对象T
     */
    public T findByID(ID id);

    /**
     * 保存或更新实体对象
     * @param entity 实体对象
     * @return 成功true，失败false
     */
    public boolean saveOrUpdate(T entity);

    /**
     * 根据条件查询，返回结果集(List)
     * @param condition 查询条件(Map)
     * @return 对象集合的List
     */
    public long count(Map condition);

    /**
     * 根据条件查询，返回结果集(List)
     * @param condition 查询条件(Map)
     * @return 对象集合的List
     */
    public List<T> find(Map condition);

}
