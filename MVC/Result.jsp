<html>
<body bgcolor=black text=red>

<% mvc2.ResultBean rb=(mvc2.ResultBean)request.getAttribute("data");%>
<%= rb.getHno() %>
<%= rb.getName() %>
<%= rb.getC() %>
 <%= rb.getCpp() %>
 <%= rb.getJava() %>
</body>
</html>