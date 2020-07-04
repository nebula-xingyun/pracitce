package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.dao.UseJson;
import cn.edu.usts.cs2018.dao.UserDaoImpl;
import cn.edu.usts.cs2018.entity.Producer;
import cn.edu.usts.cs2018.entity.User;
import cn.edu.usts.cs2018.entity.UserActivity;
import cn.edu.usts.cs2018.entity.Worker;
import cn.edu.usts.cs2018.service.UserService;
import cn.edu.usts.cs2018.service.WorkerService;
import org.apache.log4j.Logger;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//webapp/ssm/Controller/login
//http://192.168.0.124:8080/ssm
//http://192.168.0.124:8080/ssm/common/login.jsp

//<form action="../userController/login" method="post">
//</form>

@Controller(value = "userController")
//@RequestMapping("/userController")
public class UserController {
    // Service对象，属性注入。
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //在需要使用日志的地方加上这句代码即可,如果使用AOP，怎么实现？
    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password ,
                        HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)act.getBean("userServiceMapper");
        User user = userService.login(username,password);
        if( user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("User", user);      // 用户登录成功的信息写入Session中。新加入User属性,值为u
            try {
//                response.getWriter().write("<script>alert('登录成功！');</script>");
                response.getWriter().write("<script>alert('SUCCESS');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return "mainpage";
        }
        else{
            try {
//                response.getWriter().write("<script>alert('登录失败！');</script>");
                response.getWriter().write("<script>alert('FAIL，Please Check');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return  "demo";
        }

    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@RequestParam(value = "userid") int userid,@RequestParam(value = "username") String username, @RequestParam(value = "password") String password ,
                        @RequestParam(value = "telephone") String telephone,@RequestParam(value = "address") String address,
                        HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)act.getBean("userServiceMapper");
        User user = new User(userid,username,password,telephone,address);
        int i = 0;
        try {
            i = userService.register(user);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if( i != 0) {
            try {
//                response.getWriter().write("<script>alert('注册成功，请登录！');</script>");
                response.getWriter().write("<script>alert('SUCCESS');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return  "demo";
        }
        else{
            try {
//                response.getWriter().write("<script>alert('注册失败，请尝试重新注册或登录！');</script>");

                response.getWriter().write("<script>alert('FAIL，Please Check');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return "demo";
        }
    }


    @RequestMapping(value="/deleteuser",method = RequestMethod.POST)
    public String deleteuser(@RequestParam(value = "userid") int userid,
                           HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)act.getBean("userServiceMapper");
        int i = 0;
        try {
            i = userService.delete(userid);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if( i != 0) {
            try {
//                response.getWriter().write("<script>alert('注册成功，请登录！');</script>");
                response.getWriter().write("<script>alert('SUCCESS');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return  "admin/savepage";
        }
        else{
            try {
//                response.getWriter().write("<script>alert('注册失败，请尝试重新注册或登录！');</script>");

                response.getWriter().write("<script>alert('FAIL！，Please Check');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return "demo";
        }
    }

    @RequestMapping(value="/update_user",method = RequestMethod.POST)
    public String update_user(@RequestParam(value = "number") String number,@RequestParam(value = "name") String name, @RequestParam(value = "password") String password ,
                           @RequestParam(value = "telephone") String telephone,@RequestParam(value = "work_count") String work_count,
                           HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationContext.xml");
        WorkerService userService = (WorkerService)act.getBean("workerServiceMapper");
        Worker user = new Worker(number,name,password,telephone,work_count);
        int i = 0;
        try {
            i = userService.update(user);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if( i != 0) {
            try {
//                response.getWriter().write("<script>alert('注册成功，请登录！');</script>");
                response.getWriter().write("<script>alert('SUCCESS');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return  "admin/savepage";
        }
        else{
            try {
//                response.getWriter().write("<script>alert('注册失败，请尝试重新注册或登录！');</script>");

                response.getWriter().write("<script>alert('FAIL，Please Check');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return "demo";
        }
    }

    @RequestMapping(value="/update_producer",method = RequestMethod.POST)
    public String update_producer(@RequestParam(value = "id") int id,@RequestParam(value = "workshopNo") String workshopNo,
                              @RequestParam(value = "producerNo") String producerNo ,
                              @RequestParam(value = "status") String status,
                              HttpServletRequest request, HttpServletResponse response) {
        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationContext.xml");
        WorkerService userService = (WorkerService)act.getBean("workerServiceMapper");
        Producer user = new Producer(id,workshopNo,producerNo,status);
        int i = 0;
        try {
            i = userService.update_producer(user);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if( i != 0) {
            try {
//                response.getWriter().write("<script>alert('注册成功，请登录！');</script>");
                response.getWriter().write("<script>alert('SUCCESS');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return  "producer/show_producer";
        }
        else{
            try {
//                response.getWriter().write("<script>alert('注册失败，请尝试重新注册或登录！');</script>");

                response.getWriter().write("<script>alert('FAIL，Please Check');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return "demo";
        }
    }
}
