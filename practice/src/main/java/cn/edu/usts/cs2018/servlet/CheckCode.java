package cn.edu.usts.cs2018.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: JavaWebApp
 * @description: 从Seeion中验证验证码是否正确
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-03-12 22:37
 **/
@WebServlet(urlPatterns = "/checkCode")
public class CheckCode extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String result = "{\"Success\":false}";

        try {
            String code = req.getParameter("logyzm").toString();
            System.out.println(code);

            if (code != null) {
                String mCode = ((HttpSession) req.getSession()).getAttribute("ValidateCode").toString();

                if (code.length() > 0 && code.toUpperCase().equals(mCode.toUpperCase())) {
                    result = "{\"Success\":true}";
                }
            }

        }
        catch (Exception ex ) {
            System.out.println("Erorr.");
        }
        out.println(result);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
