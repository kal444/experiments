<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    	<title>list</title>
  </head>

  <body>
	<f:view>
    <h:form>
	<h:commandLink action="edit" value="add a new task"></h:commandLink>

	<h:dataTable value="#{taskerHandler.master}" var="task">
		<h:column> <h:outputText value="#{task.taskNumber}"></h:outputText> </h:column>
		<h:column> <h:outputText value="#{task.taskDescription}"></h:outputText> </h:column>
		<h:column> <h:commandLink action="#{taskerHandler.detail}"> click <f:param name="id" value="#{task.taskNumber}"></f:param> </h:commandLink> </h:column>
	</h:dataTable>


    </h:form>
    
   	</f:view> 
  </body>

</html> 
