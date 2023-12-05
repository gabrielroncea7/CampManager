<jsp:useBean id="userBean" scope="session" class="es.uco.pw.data.display.CustomerBean"></jsp:useBean>
<%
	if(userBean.getEmail() != null)
	{
		response.sendRedirect(request.getContextPath()+"/usuarioServlet");
	}

%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"  href="css/Login.css">
    <title>Iniciar Sesi�n</title>
</head>
<body>
    <div class="login-container">
        <form action="#" method="post" class="login-form">
            <h2>Iniciar Sesi�n</h2>
            <label for="username">Usuario:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Contrase�a:</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Iniciar Sesi�n</button>
            <p class="register-link">�No tienes una cuenta? <a href="mvc/view/registroView.jsp">Reg�strate aqu�</a></p>
        </form>
    </div>
</body>
</html>




