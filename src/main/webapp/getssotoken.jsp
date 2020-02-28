<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.ResourceBundle" %>
<%
    String contextPath = request.getContextPath();
    String scheme = request.getScheme();
    String serverName = request.getServerName();    
    int serverPort = request.getServerPort();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("ssoConfig");//application.properties文件读取文件路径
    String  redirecturl = resourceBundle.getString("redirecturl");
%>
<html>
<head>
<title></title>
<SCRIPT LANGUAGE="JavaScript" >
        window.location.href="<%=redirecturl%>?service='<%=scheme%>://<%=serverName%>:<%=serverPort%><%=contextPath%>/setssotoken.jsp'&needtoken=true";
</SCRIPT>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" >
<br>
</body>

</html>