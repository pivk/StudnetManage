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
		  System.out.println("ServletContext����");
	       ServletContext servletContext = sce.getServletContext();
	       String currentTime = "2017-07-11 13:51:00";
	       java.util.Date date = null;
	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	       try {
	           date = simpleDateFormat.parse(currentTime);
	       } catch (ParseException e) {
	           e.printStackTrace();
	       }
	       //Timer��ʱ��
	       //task ����
	       //firstTime ��һ��ִ��ʱ��
	       //period ���ִ��ʱ��
	        //Timer.scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
	       Timer timer = new Timer();
	       timer.scheduleAtFixedRate(new TimerTask() {
	           
	           @Override
	           public void run() {
	               System.out.println("���м�Ϣ..");
	           }
	       }, date, 5000);
	       //24Сʱ 1000*60*60*24
	       //����ҵ�񣺿���ģ�����еļ�Ϣҵ��
	       //��ʼʱ�䣺���������12��
	       //���ʱ�䣺24Сʱ
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	       System.out.println("ServletContext����");
		
	}

}
