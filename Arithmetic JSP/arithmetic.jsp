
<% 
String s=request.getParameter("operation");
if(s.equals("Addition")){%>
<jsp:forward page="add.jsp"/>
 <%}else if(s.equals("Subtraction")){%>
 <jsp:forward page="sub.jsp"/>
 <%}else if(s.equals("Multiplication")){%>
 <jsp:forward page="mul.jsp"/>
 <%} else{ %>
 <jsp:forward page="div.jsp"/>
 <% }%>