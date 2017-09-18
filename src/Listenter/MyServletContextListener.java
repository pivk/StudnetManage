package Listenter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		  System.out.println("ServletContext创建");
	       ServletContext servletContext = sce.getServletContext();
	       String currentTime = "2017-07-11 13:51:00";
	       java.util.Date date = null;
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	       try {
	           date = simpleDateFormat.parse(currentTime);
	       } catch (ParseException e) {
	           e.printStackTrace();
	       }
	       //Timer定时器
	       //task 任务
	       //firstTime 第一次执行时间
	       //period 间隔执行时间
	        //Timer.scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
	       Timer timer = new Timer();
	       timer.scheduleAtFixedRate(new TimerTask() {
	           
	           @Override
	           public void run() {
	               System.out.println("银行计息..");
	           }
	       }, date, 5000);
	       //24小时 1000*60*60*24
	       //真是业务：可以模拟银行的计息业务
	       //起始时间：定义成晚上12点
	       //间隔时间：24小时
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	       System.out.println("ServletContext销毁");
		
	}

}
