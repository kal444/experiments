package com.yellowaxe.tasker.standalone;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TaskerMessageReceiver {

	public final static Object lockObject = new Object();

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
			MessageConsumer mc = s.createConsumer(d);
			mc.setMessageListener(new TaskerMessageListener());

			c.start();

			synchronized (lockObject) {
				lockObject.wait();
			}

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

	public static void shutdown() {
		synchronized (lockObject) {
			lockObject.notifyAll();
		}
	}

}
