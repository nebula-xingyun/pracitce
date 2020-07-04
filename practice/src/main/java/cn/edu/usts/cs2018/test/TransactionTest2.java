package cn.edu.usts.cs2018.test;

import cn.edu.usts.cs2018.entity.UserActivity;
import cn.edu.usts.cs2018.entity.Worker;
import cn.edu.usts.cs2018.service.UserService;
import cn.edu.usts.cs2018.service.WorkerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest2 {
    public static void main(String[] args) {
        ApplicationContext act =  new ClassPathXmlApplicationContext("applicationContext.xml");
        WorkerService userService = (WorkerService)act.getBean("workerServiceMapper");
        Worker user = new Worker("1202","小明","ming123","122","1");

        try {

            System.out.println("查找成功！！！");
            userService.update(user);
        }
        catch(Exception ex) {
            System.out.println(ex.toString());
            System.out.println("查找失败！！！");
        }



    }
}