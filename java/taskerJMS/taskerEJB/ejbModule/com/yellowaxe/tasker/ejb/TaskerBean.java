package com.yellowaxe.tasker.ejb;

import java.rmi.RemoteException;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionSynchronization;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * Session Bean implementation class TaskerBean
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateful
public class TaskerBean implements TaskerBeanRemote, SessionSynchronization {
	
	@Resource(mappedName="jms/taskerMQTopicFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="jms/taskerMQTopic")
	private Topic topic;

    /**
     * Default constructor. 
     */
    public TaskerBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void testMethod() {
    	try {
	    	Connection conn = connectionFactory.createConnection();
	    	Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
	    	MessageProducer producer = sess.createProducer(topic);
	    	
	    	TextMessage mess = sess.createTextMessage();
	    	mess.setText("this is a jms message! " + new Date());
	    	
	    	producer.send(mess);
	    	
	    	producer.close();
	    	sess.close();
	    	conn.close();
	    	
    	} catch (JMSException je) {
    		System.out.println("jms error");
    	}

    	System.out.println("tasker EJB!");
    	//throw new TaskerException();
    }

    
    @Override
    public void afterBegin() throws EJBException, RemoteException {
    	// TODO Auto-generated method stub
    	System.out.println("taskerBean transaction began");
    }
    
    @Override
    public void beforeCompletion() throws EJBException, RemoteException {
    	// TODO Auto-generated method stub
    	System.out.println("taskerBean transaction almost done");
    }
    
    @Override
    public void afterCompletion(boolean arg0) throws EJBException,
    		RemoteException {
    	// TODO Auto-generated method stub
    	System.out.println("taskerBean transaction done");
    }
}
