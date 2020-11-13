<html>
<head>
    <title>Sum Form</title>
</head>
<body>
<%--<i> Sum of your numbers is ----->  </i> <%=request.getAttribute("message")%>--%>

<form method="get" id="form" action="MessageServlet">

    <fieldset style="border:1px #ffb0dd solid;">
        <legend><span style="font-family:Monotype Corsiva;color:#cb6ac6;font-size:18px"></span> </legend>

        <div>
            <label><%=request.getAttribute("message")%></label>
        </div><br>

        <div>
            <input name="enter" type="submit" value="GET ONE MORE">
        </div>
    </fieldset>
</form>

</body>
</html>