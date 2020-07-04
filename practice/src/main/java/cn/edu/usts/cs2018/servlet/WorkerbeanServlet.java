package cn.edu.usts.cs2018.servlet;

import cn.edu.usts.cs2018.dao.UserDAO;
import cn.edu.usts.cs2018.dao.UserDaoImpl;
import cn.edu.usts.cs2018.dao.WorkerDAO;
import cn.edu.usts.cs2018.dao.WorkerDAOImpl;
import cn.edu.usts.cs2018.entity.User;
import cn.edu.usts.cs2018.entity.Worker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/servlet/WorkerbeanServlet")
public class WorkerbeanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public WorkerbeanServlet() {
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
        WorkerDAO ud = new WorkerDAOImpl();
        List<Worker> userAll = ud.find("select * from worker");
        request.setAttribute("userAll", userAll);
        request.getRequestDispatcher("/admin/admincon.jsp").forward(request, response);
    }
}
