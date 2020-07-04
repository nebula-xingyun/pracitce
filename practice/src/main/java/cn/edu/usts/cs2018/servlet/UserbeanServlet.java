package cn.edu.usts.cs2018.servlet;

import cn.edu.usts.cs2018.dao.UserDAO;
import cn.edu.usts.cs2018.dao.UserDaoImpl;
import cn.edu.usts.cs2018.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/UserbeanServlet")
public class UserbeanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserbeanServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        int activityid = Integer.parseInt(request.getParameter("activityid"));
//        UserDAO ud = new UserDaoImpl();
//        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService)act.getBean("userServiceMapper");
//
//        List<User> userAll = null;
//        try {
//            userAll = userService.findAll();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        request.setAttribute("userAll", userAll);
        UserDAO ud = new UserDaoImpl();
        List<User> userAll = ud.find("select * from user");
        request.setAttribute("userAll", userAll);
        request.getRequestDispatcher("/producer/showall.jsp").forward(request, response);
    }
}
