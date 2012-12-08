package com.yellowaxe.tasker.standalone;

import java.text.MessageFormat;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TaskerMessageListener implements MessageListener {

	public final static String SHUTDOWN_MESSAGE = "SHUTDOWN_SYSTEM";

	@Override
	public void onMessage(Message msg) {
		try {
			if (msg instanceof TextMessage) {
				TextMessage tm = (TextMessage) msg;

				System.out.println(MessageFormat.format("{0,number,#} : {1}",
														System.currentTimeMillis(),
														tm.getText()));

				if (SHUTDOWN_MESSAGE.equals(tm.getText())) {
					TaskerMessageReceiver.shutdown();
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
