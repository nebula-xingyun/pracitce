package cn.edu.usts.cs2018.test;

import cn.edu.usts.cs2018.dao.WorkerDAOImpl;
import cn.edu.usts.cs2018.entity.User;
import cn.edu.usts.cs2018.entity.Worker;
import cn.edu.usts.cs2018.service.UserService;
import cn.edu.usts.cs2018.service.WorkerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static cn.edu.usts.cs2018.dao.UseJson.formatJson;

public class Test {
    public static void main(String[]args){
//        ApplicationContext act =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        // 方法1　根据容器中Bean的id来获取指定的Bean
//        WorkerService userService = (WorkerService)
//                act.getBean("workerServiceMapper");
//    String username = "王芳";
//    String password = "wang123";
//
//        Worker user = userService.login(username,password);
//        System.out.println(user);
        WorkerDAOImpl dao=new WorkerDAOImpl();
        String s = dao.findAllProducer();
        String jsonString = formatJson(s.toString());
        System.out.println(s);
    }
}
