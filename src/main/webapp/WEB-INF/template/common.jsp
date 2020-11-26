<nav id="myNavbar" class="navbar navbar-dark bg-primary static-top" style="display: flex;
justify-content: space-between;">
    <div class="navbar-brand">
        <a href="${pageContext.request.contextPath}/students">
            <img src="${pageContext.request.contextPath}/static/img/myefrei.png" width="130" height="45"
                 alt="background-images"/>
        </a>
    </div>


    <div id= class="text-capitalize" style="display: flex; flex-direction: row;">
        <h4 class="mr-lg-4 text-capitalize text-light mt-1">${tutor.username}</h4>
        <a class="btn btn-danger my-2 my-sm-0" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</nav>