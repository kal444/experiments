package com.yellowaxe.tasker.standalone;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TaskerMessageSender {

	public static void main(String[] args) {
		InitialContext ic;
		ConnectionFactory cf = null;
		Connection c = null;
		try {
			ic = new InitialContext();
			cf = (ConnectionFactory) ic.lookup("jms/taskerMQQueueFactory");
			c = cf.createConnection();
			Session s = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination d = (Destination) ic.lookup("jms/taskerMQQueue");
			MessageProducer mp = s.createProducer(d);

			c.start();

			for (int i = 0; i < 5; i++) {
				TextMessage tm = s.createTextMessage(Integer.toString(i));
				mp.send(tm);
			}

			mp.send(s.createTextMessage(TaskerMessageListener.SHUTDOWN_MESSAGE));

			c.stop();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

		System.exit(0);
	}

}
