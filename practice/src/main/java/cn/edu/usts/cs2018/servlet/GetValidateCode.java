package cn.edu.usts.cs2018.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @program: JavaWebApp
 * @description: 获得验证码图像
 * @author: Mr.Lu, DCE, USTS.
 * @create: 2020-03-12 15:29
 **/
@WebServlet(urlPatterns = "/getValidateCode")
public class GetValidateCode extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public GetValidateCode() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("image/jpeg");

        //设置页面不缓存
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);
        char[] code = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ,
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
                'p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
                'P','Q','R','S','T','U','V','W','X','Y','Z'};
        String []Fonts={"Times New Roman","Verdana",
                "Arial Narrow",
                "Candara",
                "Californian FB",
                "Brush Script MT"};
        int width=60, height=30;
        // 在内存中创建图象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 生成随机类对象
        Random random = new Random();
        // 画边框
        g.fillRect(0, 0, width, height);
        // 选择颜色, 设定背景色
        g.setColor(getRandColor(160,200));
        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        for (int i=0;i<155;i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x,y,x+xl,y+yl);		//画随机线条
        }
        String sRand="";
        int t;
        // 取随机产生的验证码(4位字符)
        for (int i=0;i<4;i++){
            t = random.nextInt(code.length);
            String rand =  "" + code[t];	//随机选择一个字符
            sRand += rand;
            //随机选择颜色
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            //随机选择字体，字体大小为（15+random.nextInt(5)）
            g.setFont(new Font(Fonts[random.nextInt(5)],Font.BOLD,20+random.nextInt(5)));
            //在(13*i,15+random.nextInt(10))位置写一个字符，将验证码显示到图象中
            g.drawString(rand,13*i+6,15+random.nextInt(10));
        }
        // 将验证码存入SESSION 名为"ValidateCode"，可以在客户端读取
        request.getSession().setAttribute("ValidateCode",sRand);
        // 释放图形上下文
        g.dispose();
        //通过response对象输出，输出为JPEG格式的图像（片）。
        try{
            ImageIO.write(image, "JPEG", response.getOutputStream());
        }catch(IOException e ){}
        response.flushBuffer();
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }
    Color getRandColor(int fc,int bc)
    {
        Random random = new Random();
        if(fc>255)
            fc=255;
        if(bc>255)
            bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}
