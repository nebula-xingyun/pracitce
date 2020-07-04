package cn.edu.usts.cs2018.servlet;

import cn.edu.usts.cs2018.dao.UserDAO;
import cn.edu.usts.cs2018.dao.UserDaoImpl;
import cn.edu.usts.cs2018.entity.UserActivity;
import cn.edu.usts.cs2018.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/JavabeanServlet")
public class JavabeanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public JavabeanServlet() {
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
        int activityid = Integer.parseInt(request.getParameter("activityid"));
        UserDAO ud = new UserDaoImpl();
        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)act.getBean("userServiceMapper");

        List<UserActivity> userAll = null;
        try {
            userAll = userService.findActivity(activityid);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("userAll", userAll);
        request.getRequestDispatcher("/activity/showall.jsp").forward(request, response);
    }
}
