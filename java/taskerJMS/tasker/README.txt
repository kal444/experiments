The following setup needs to be done in the application server:

- JMS
A JMS ConnectionFactory named: jms/taskerMQTopicFactory
A JMS Topic named: jms/taskerMQTopic
A Java Message Service physical destination: tasker.mq.topic 

A JMS ConnectionFactory named: jms/taskerMQQueueFactory
A JMS Queue named: jms/taskerMQQueue
A Java Message Service physical destination: tasker.mq.queue 

- JDBC
A JDBC Connection Pool using Derby: jdbc/taskerPool
Goto the directory where taskerdb is (like C:\_dev\db\derby) and run:
c:\_dev\glassfish\javadb\bin\startNetworkServer.bat

Then, in pool configuration:
DatabaseName:taskerdb
User:APP
Password:APP

A JDBC datasource: jdbc/taskerDS

- Security
Create JDBC realm: taskerRealm
JAAS context: jdbcRealm  
JNDI: jdbc/taskerDS
User Table: securities
User Name Column: username
Password Column: password
Group Table: securities
Group Name Column: rolename
Digest Algorithm: none
