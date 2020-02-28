<%@ page contentType="text/html;charset=utf-8" %>
<%
    //String contextPath = request.getContextPath();
    String ssotoken = request.getParameter("ssotoken");
%>
<html>
<head>
<title></title>
<SCRIPT LANGUAGE="JavaScript" >
    <% if(ssotoken!=null && !"".equals(ssotoken)){%>
        var d = new Date();
        d.setTime(d.getTime()+(2*60*60*1000));
        var expires = "expires="+d.toGMTString();
        document.cookie='cookssotoken=<%=ssotoken%>'+';'+expires;
        window.location.href="./#/login";
    <%}else{%>
        window.location.href="./#/login";
    <%}%>
</SCRIPT>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" >
<br>
</body>

</html>