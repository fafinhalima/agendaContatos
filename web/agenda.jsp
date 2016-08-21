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
                <h:dataTable value="#{usuario.contatos}" var="item" border="1" cellpadding="2" cellspacing="0">
                    <f:facet name="header">
                        <h:outputText value="Contatos" />
                    </f:facet>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Nome" />
                        </f:facet>
                        <h:outputLabel value="#{item.nome}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Endereço" />
                        </f:facet>
                        <h:outputLabel value="#{item.endereco}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Idade" />
                        </f:facet>
                        <h:outputLabel value="#{item.idade}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Data de Nascimento" />
                        </f:facet>
                        <h:outputLabel value="#{item.dataNascimento}" >
                            <f:convertDateTime pattern="dd/MM/yyyy" />
                        </h:outputLabel>                    
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Excluir Contato" />
                        </f:facet>
                        <h:commandLink action="#{contato.onDelete}" value="Excluir">
                           <f:setPropertyActionListener target="#{contato}" value="#{item}" />
                        </h:commandLink>
                    </h:column>
                </h:dataTable> <br /> <br />
                <h:commandLink action="#{usuario.onLogoff}" value = "Fazer logoff" />
            </h:form>
        </body>
    </html>
</f:view>
