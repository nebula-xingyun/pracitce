package cn.edu.usts.cs2018.test;


import cn.edu.usts.cs2018.dao.MySQLDBHelper;
import cn.edu.usts.cs2018.dao.UserDAO;
import cn.edu.usts.cs2018.dao.UserDaoImpl;
import cn.edu.usts.cs2018.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * program: JavaWebApp
 * description: 测试类
 * @author: Mr.Lu, DCE, USTS.
 * create: 2020-03-04 17:18
 **/
public class TestApp {

    public static void main(String[] args) {
//        testUserService();

        testSql();
    }


    public static void testUserService() {
        // 合法用户："admin", "admin321"
//        User user = new User("tom" , "tom987");
//
//        System.out.println("当前用户：" + user);

        UserDAO dao = new UserDaoImpl();
try {
    System.out.println(((UserDaoImpl) dao).findAll());
}catch(Exception e){
    e.printStackTrace();
}
        User user = new User("Uqewq","qqq123");
User u;
        if((u = dao.login(user)) != null) {
            //用户存在
            System.out.println("用户:" + user.getUsername() + " 存在!");
        }
        else {
            // 不存在
            System.out.println("用户:" + user.getUsername() + " 不存在!");
        };
//
//        User user2 = new User(1024, "Sam" , "sam111", "112123411",
//                "江苏", "盐城","长江路222号","数据中心");
//
//        if(!dao.insert(user2)) {
//            System.out.println("Insert fail.");
//        };
//
//        if((u = dao.login(user2)) != null) {
//            //用户存在
//            System.out.println("用户:" + user2.getName() + " 存在!");
//        }
//        else {
//            // 不存在
//            System.out.println("用户:" + user2.getName() + " 不存在!");
//        };
//
//        dao.print();
//
//        IUserService service = new UserServiceImpl(dao);
//
//        u = service.login(user);
//        if(u != null) {
//            System.out.println("登录成功!");
//            System.out.print("用户信息：\n\t");
//            System.out.println(u);
//        }
//        else {
//            System.out.println("用户名或口令错，请重新登录!");
//        }

        // 分页功能测试
//        Pagination<User> pageView = service.getPagination(2, 10);
//        System.out.println(pageView.toJSON());
    }

    public static void testSql(){
        MySQLDBHelper BaseDao = new MySQLDBHelper();
        UserDaoImpl dao = new UserDaoImpl();
        Connection conn = null;
        PreparedStatement ps = null;
        String upass = null;
//out.print(num);
//out.print(superPass);
        String sql = "select password from user where username ='Uqewq' and telephone ='12221434'";
//        String sql = "select password from user where name='"+num+"' and telephone = '"+superPass+"';";

        System.out.print(sql);
        try{
//            conn = BaseDao.getConnection();

            Class.forName("com.mysql.jdbc.Driver");

            if (null == conn) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/experiment?characterEncoding=utf8&useSSL=false&serverTimezone=UTC", "root", "123456");
            }
            ps = conn.prepareStatement(sql);
//            ps.setString(1,num);
//            ps.setString(2,superPass);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                upass = rs.getString("password");
            }
            else
            {
                upass = null;
            }
        }catch(Exception ex){
            ex.getMessage();
        }finally{
            BaseDao.free(conn);

        }
        System.out.println(upass);
        if(upass!=null){
            System.out.print("<script type='text/javascript'>alert('密码已找回，请记录！');history.back();</script>");
        }else{
//        out.print("<script type='text/javascript'>alert('员工编号或超级密码不正确，请重新输入');history.back();</script>");
            System.out.print("<script type='text/javascript'>alert('姓名与电话不匹配，请重新输入');history.back();</script>");
        }
    }
}
