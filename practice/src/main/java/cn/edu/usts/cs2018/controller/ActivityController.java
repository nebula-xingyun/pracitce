package cn.edu.usts.cs2018.controller;

import cn.edu.usts.cs2018.entity.Activity;
import cn.edu.usts.cs2018.service.base.ActivityService;
import org.apache.log4j.Logger;
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


@Controller(value = "activityController")
//@RequestMapping("/userController")
    public class ActivityController {
        // Service对象，属性注入。
        @Autowired
        @Qualifier("activityService")
        private ActivityService activityService;

        public void setActivityService(ActivityService activityService) {
            this.activityService = activityService;
        }

        //在需要使用日志的地方加上这句代码即可,如果使用AOP，怎么实现？
        private static Logger logger = Logger.getLogger(ActivityController.class);

        @RequestMapping(value="/addactivity",method = RequestMethod.POST)
    public String addactivity(@RequestParam(value = "activityid") Integer activityid, @RequestParam(value = "userid") Integer userid, @RequestParam(value = "username") String username , @RequestParam(value = "activityname") String activityname ,
                              @RequestParam(value = "activityplace") String activityplace,
                              @RequestParam(value = "start_time") String start_time,
                              @RequestParam(value = "end_time") String end_time,
                              @RequestParam(value = "general_budget") Float general_budget,
                              @RequestParam(value = "description") String description,
                              @RequestParam(value = "min_member") Integer min_member,
                              @RequestParam(value = "max_member") Integer max_member,
                              @RequestParam(value = "create_time") String create_time,
                              @RequestParam(value = "status") String status, HttpServletRequest resquest, HttpServletResponse response) {
//        username = resquest.getParameter("username"); @RequestParam(value = "activityplace") String activityplace,
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        ActivityService activityService = (ActivityService) act.getBean("activityServiceMapper");
        Activity activity = new Activity(activityid,userid,username,activityname,activityplace,start_time,end_time,general_budget,description,min_member,max_member,create_time,status);

        int i = activityService.insert(activity);

        if( i >=1) {
            try {
//                response.getWriter().write("<script>alert('加入记录成功！');</script>");
                response.getWriter().write("<script>alert('SUCCESS');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("here");
            HttpSession session = resquest.getSession();
//            session.removeAttribute("User");
            session.setAttribute("Activity", activity);      // 用户登录成功的信息写入Session中。新加入User属性,值为u
//            session.setAttribute("user", user); // 用户登录成功的信息写入Session中。新加入user属性,值为u
            return "mainpage";
        }

        else{
            try {
//                response.getWriter().write("<script>alert('加入记录成功！');</script>");
                response.getWriter().write("<script>alert('FAIL，Please Check');</script>");
                response.getWriter().flush();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return  "addActivity";
        }
    }
//    // 返回JSON数据
//    @RequestMapping(value="/update", produces={"text/html;charset=UTF-8;","application/json;"})
//    @ResponseBody
//    public String insert(Activity activity ) {
//        int i = activityService.insert(activity);
//        String result = "{\"success\":false,\"msg\":\"修改失败。\"}";
//        if( i >= 1) {
//            System.out.println(activity);
//            result = "{\"success\":true,\"msg\":\"修改成功。\"}";
//        }
//
//        logger.info(result);
//        return  result;
//    }

    @RequestMapping(value="/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest resquest) {
//        String resultView = "mainpage";

        HttpSession session = resquest.getSession();
        session.removeAttribute("Activity");
        session.invalidate();		// 销毁Session中。
        logger.info("logout");
//        return  resultVieww;
        return  "mainpage";
    }

    }
