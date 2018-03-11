<%@ page import="fr.epsi.myEpsi.models.beans.Ad" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <%@ include file="header.jsp"%>

    <body>
        <div>
            Bienvenue en tant qu'invité !!
        </div>

        <br/>

        <div>
            <table>
                <th>
                <td>Titre</td>
                <td>Status</td>
                <td>Description</td>
                <td>Vendeur</td>
                <td>Prix</td>
                </th>

                <% for (Ad ad : ((List<Ad>) pageContext.getRequest().getAttribute("ads"))) {
                    out.println("<tr>");

                    out.println("<td>" + ad.getTitle() + "</td>");
                    out.println("<td>" + ad.getStatus() + "</td>");
                    out.println("<td>" + ad.getDescription() + "</td>");
                    out.println("<td>" + ad.getSeller() + "</td>");
                    out.println("<td>" + ad.getPrice() + "</td>");

                    out.println("</tr>");
                } %>
            </table>
        </div>
    </body>
</html>