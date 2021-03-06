<%@ page import="fr.epsi.myEpsi.misc.ServletUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="card border-secondary mb-3" style="max-width: 20rem;">
    <div class="card-header <% if (!ServletUtil.retrieveValue(request, "owner").isEmpty()) { %>bg-success<% } %>">
        <h5 class="card-title text-center">${param.title}</h5>
        <p class="card-text">${param.status}</p>
    </div>

    <div class="card-body text-secondary">
        <p class="card-text">${param.desc}</p>
        <p class="card-text">${param.price}</p>
        <p class="card-text text-right">${param.seller}</p>

        <% if (!ServletUtil.retrieveValue(request, "modification").isEmpty()) { %>
        <p class="card-text text-right">${param.modification}</p>
        <% } %>
    </div>

    <div class="card-footer">
        <% if (!ServletUtil.retrieveValue(request, "detail").isEmpty()) { %>
        <a href="${pageContext.request.contextPath}/detail?id=${param.id}" class="btn btn-secondary">Détail</a>
        <% } %>

        <% if (!ServletUtil.retrieveValue(request, "canBuy").isEmpty()) { %>
        <a href="${pageContext.request.contextPath}/buy?id=${param.id}" class="btn btn-secondary">Acheter</a>
        <% } %>
    </div>
</div>