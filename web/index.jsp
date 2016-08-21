<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Agenda de Contatos</title>
        </head>
        <body>
            <h:form>
                <h:outputLabel value="Acesso"/> <br /><br />
                <h:outputLabel value="Login: "/>
                <h:inputText value="#{usuario.login}"/><br />
                <h:outputLabel value="Senha: "/>
                <h:inputSecret value="#{usuario.senha}"/> <br /> <br />
                <h:commandButton value="Fazer Login" action="#{usuario.onLogin}"/>
            </h:form>
        </body>
    </html>
</f:view>
