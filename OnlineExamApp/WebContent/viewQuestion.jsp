<%@page import="com.lti.model.Option"%>
<%@page import="java.util.List"%>
<%@page import="com.lti.model.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CheckAnswerServlet">
<%
	Question qs = (Question) session.getAttribute("nextQs");
%>
<h2>Q. <%=qs.getQuestion() %></h2>

<%
	List<Option> ops = qs.getOptions();
	int opNo=0;
	for(Option op: ops){
%>
	<input type="radio" name="op" value="<%=opNo++%>"/> <%=op.getOption() %><br/>
<%
	}
%>
	<button type="submit">Next Question</button>
<!--  	
	<a href="QuestionLoaderServlet">Next Question</a>
	<a href="QuestionLoaderServlet?q=next">Next Question</a>
	<a href="QuestionLoaderServlet?q=prev">Previous Question</a>
-->
</form>
</body>
</html>