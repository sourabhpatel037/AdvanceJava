<html>
<body bgcolor=black text=red>
<h1>

<% 

String s1=request.getParameter("first");
String s2=request.getParameter("second");
int x=Integer.parseInt(s1);
int y=Integer.parseInt(s2);

out.println("Output : "+(x-y));
%>
</h1>
</body>
</html>