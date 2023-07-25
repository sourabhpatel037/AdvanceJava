
<html> 

<body bgcolor=black text=red>

<h1>
<% 
    String s1=request.getParameter("uname");
    String s2=request.getParameter("pword");
    
    if(s1.equals("abc")&& s2.equals("xyz"))
    {
    	out.println("Welcome: \t \t"+s1);
    }
    else 
    {
    	out.println("Invalid Usernaame/password");
    	
    }
%>
</h1>
</body>
</html>