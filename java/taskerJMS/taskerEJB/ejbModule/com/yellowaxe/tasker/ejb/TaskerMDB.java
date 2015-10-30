package com.yellowaxe.tasker.ejb;

import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBContext;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.ejb.SessionSynchronization;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: TaskerMDB
 *
 */
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Topic"
		) }, 
		mappedName = "jms/taskerMQTopic")
public class TaskerMDB implements MessageListener, SessionSynchronization {
	
	@Resource
	EJBContext ejbContext;

    /**
     * Default constructor. 
     */
    public TaskerMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                
                System.out.println("got msg: " + msg.getText());
            }
        } catch (TaskerException taskere) {
        	taskere.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
            ejbContext.setRollbackOnly();
        }
    }

    
    @Override
    public void afterBegin() throws EJBException, RemoteException {
    	// TODO Auto-generated method stub
    	System.out.println("taskerMDB transaction began");
    }
    
    @Override
    public void beforeCompletion() throws EJBException, RemoteException {
    	// TODO Auto-generated method stub
    	System.out.println("taskerMDB transaction almost done");
    }
    
    @Override
    public void afterCompletion(boolean arg0) throws EJBException,
    		RemoteException {
    	// TODO Auto-generated method stub
    	System.out.println("taskerMDB transaction done");
    }
}
