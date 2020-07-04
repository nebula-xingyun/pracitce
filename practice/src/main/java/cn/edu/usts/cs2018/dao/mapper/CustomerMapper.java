package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.Customer;

import java.util.List;

/**
 * @program: springmvcdemo
 * @description:
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-05-17 17:09
 **/
public interface CustomerMapper {
    /**
     * Mybatis中与Customerxml文件绑定的接口.
     */
    //　按照ID查客户的方法
    public Customer getCustomerById(int id);

    public Customer selectByNamePwd(String name, String password);
    //　查所有表中客户的方法
    public List<Customer> selectAll();

    //　按指定条件，查所有表中客户的方法，参数strWhere是条件
    public List<Customer> select(String strWhere);
    //　添加客户
    public void add(Customer cust);

    //　更新客户
    public void update(Customer cust);

    //　通过ID删除客户
    public void deleteById(int id);

    public List<Customer> searchCustomer(Customer cust);
}
