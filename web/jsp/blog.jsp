<%--
User: ABDERRAHIM
Date: 17/01/2019
Time: 20:18
--%>

<html>
<head>
    <%@include file="Header.jsp" %>
</head>

<body class="grey lighten-5">

<!--Main Navigation-->
<header>

    <!-- Navbar -->
    <%@include file="Navbar.jsp" %>
    <!-- Navbar -->

</header>
<!--Main Navigation-->

<main>
    <div class="container">
        <br><br><br>
        <!--Search button-->
        <div class="row mb-4 mt-2">
            <div class="col-6 mt-4">
                <form class="form-inline  mr-auto " action="blog">
                    <input class="form-control mr-sm-2 my-0" type="text" value="${keyword}" placeholder="Search"
                           aria-label="Search"
                           name="keyword">
                    <button class="btn btn-red btn-rounded btn-md my-0" style="margin-left : -8px; border-radius : 3px;" type="submit"><i class="fas fa-search"></i></button>
                </form>
            </div>
            <!--Search button-->

            <!--Add blog-->
            <div class="col-md-6 text-right mt-2">

                <a class="btn btn-red ${empty sessionScope.donnateur ? 'invisible': ''}" href="addBlog">New Blog</a>

            </div>
            <!--Add blog-->

        </div>
        <!--Section: Cards-->

        <section class="text-center">
            <c:if test="${not empty blogs}">
            <c:forEach var="i" begin="0" end="1" step="1">


            <c:if test="${ i == 1 }">
                <c:set var="i" value="${i+2}"></c:set>
            </c:if>


            <!--Grid row-->
            <div class="row mb-4 wow fadeIn">
                <c:forEach var="j" begin="0" end="2">
                    <c:if test="${not empty blogs[i + j]}">
                        <!--Grid column-->
                        <div class="col-lg-4 col-md-12 mb-3 ">
                            <!--Card-->
                            <div class="card">
                                <!--Card image-->
                                <div class="overlay">
                                    <div class="embed-responsive embed-responsive-16by9 rounded-top">
                                        <img class="embed-responsive-item"
                                             src="${blogs[i + j].getPathImgBlog().substring(55)}" allowfullscreen/>
                                    </div>
                                </div>
                                <!--Card content-->
                                <div class="card-body ">
                                    <!--Title-->
                                    <h4 class="card-title"
                                        style="height: 80px">${blogs[i + j].getTitreBlog().substring(0, (blogs[i + j].getTitreBlog().length() < 48) ? blogs[i + j].getTitreBlog().length(): 48)}</h4>
                                    <!--Text-->
                                    <p class="card-text">${blogs[i + j].getContenueBlog().substring(0, (blogs[i + j].getContenueBlog().length() < 150) ? blogs[i + j].getContenueBlog().length(): 150)}</p>
                                    <a href="blog?id=${blogs[i + j].getIdBlog()}" class="btn btn-red btn-md">Read More
                                        <i class="fa fa-play ml-2"></i>
                                    </a>
                                </div>

                            </div>
                            <!--/.Card-->
                        </div>
                        <!--Grid column-->
                    </c:if>
                </c:forEach>
            </div>
            <!--Grid row-->
            </c:forEach>
            </c:if>
            <c:if test="${empty blogs}">
            <!-- Card -->
            <!-- Grid column -->
            <div class="col-md-10 offset-1 mb-4">
                <!--Card-->
                <div class="card mb-5" style="background: #AE1F23">
                    <!--Card image-->
                    <div class="card-header pt-4" style="background: #AE1F23">
                        <h4 class="card-title white-text">No article available</h4>
                    </div>

                    <!--Card content-->
                    <div class="card-body text-center">
                        <!--Title-->

                        <!--Text-->
                        <p class="card-text white-text">If your life has been impacted as a result of blood donations
                            then we want to hear from you. Help spread the word about the importance of blood donation
                            and share your story.
                        </p>
                        <a href="login" class="btn btn-outline-white btn-md waves-effect">Join us</a>
                    </div>

                </div>
                <!--/.Card-->

            </div>
            <!-- Grid column -->
            <!-- Card -->


    </div>

    </c:if>
    <!--Pagination-->

    ${pg}

    <!--Pagination-->

    </section>
    <!--Section: Cards-->
    </div>
</main>

<%@include file="Footer.jsp" %>

</body>

</html>