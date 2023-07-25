<html>
<body bgcolor=red text=yellow>
<h1>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="a" value="10"/>
<c:if test="${a>0 }">
<c:out value="Positive Number"/>
</c:if>
</h1>
</body>
</html>