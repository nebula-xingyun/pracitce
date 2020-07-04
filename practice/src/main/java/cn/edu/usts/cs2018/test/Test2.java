package cn.edu.usts.cs2018.test;

import cn.edu.usts.cs2018.dao.MySQLDBHelper;
import cn.edu.usts.cs2018.dao.UserDaoImpl;
import cn.edu.usts.cs2018.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class Test2 {
    public static void main(String[]args){
        MySQLDBHelper BaseDao = new MySQLDBHelper();
        UserDaoImpl dao = new UserDaoImpl();
        UserDaoImpl dao2 = new UserDaoImpl();
        String upass = null;
            Connection conn = null;
            PreparedStatement ps = null;
        User u = null;
        List list=null;
//            User u = new User(12,"s","w","w","ww");
            try{
//                dao.insertBill(1200101);
//                list=dao.selectUserid(1001);
//                dao.insert(u);
                dao.delete(12);
            }
            catch (Exception e){
                e.printStackTrace();
            }
//        dao.findOneUser("select userid from member where activityid=?", new Object[]{1001});
//        String jsonList = JSON.toJSONString(u);
//        System.out.println(u.getUsername());

//        for(int i = 0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
        }
    }
