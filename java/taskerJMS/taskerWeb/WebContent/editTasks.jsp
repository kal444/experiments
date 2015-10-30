<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    	<title>edit</title>
  </head>

  <body>
	<f:view>
    <h:form>
	<h:commandLink action="done" value="I'm done"></h:commandLink>
	<br/>
	<h:commandButton action="#{taskerHandler.test}" value="TEST"></h:commandButton>
    </h:form>
    
   	</f:view> 
  </body>

</html> 
