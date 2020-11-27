<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${student.firstName}&nbsp;${student.lastName}</title>
    <!-- Bootstrap core CSS -->
    <link>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <style>

        .row {
            margin-top: 10px;
            margin-bottom: 10px;
        }

        li{
            margin-top: 4px;
            margin-bottom: 4px;
        }

        html, body {
            background: url("${pageContext.request.contextPath}/static/img/background.jpg") no-repeat;
            background-size: cover;
            height: 100%;
        }

    </style>
</head>
<body>
<c:import url="common.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card">

                <div class="card-body">
                    <div class="card-title mb-4">
                        <div class="d-flex justify-content-start">
                            <div class="image-container">
                                <img src="${pageContext.request.contextPath}/static/img/head.png" id="imgProfile" style="width: 150px; height: 150px" class="img-thumbnail"  alt=""/>
                            </div>
                            <div class="userData ml-3">
                                <h2 class="d-block" style="font-size: 1.5rem; font-weight: bold"><a href="javascript:void(0);">${student.firstName}&nbsp;${student.lastName}</a></h2>

                            </div>
                            <div class="ml-auto">
                                <input type="button" class="btn btn-primary d-none" id="btnDiscard" value="Discard Changes" />
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <ul class="nav nav-tabs mb-4" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="basicInfo-tab" data-toggle="tab" href="#basicInfo" role="tab" >Basic Info</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="connectedServices-tab" data-toggle="tab" href="#connectedServices" role="tab">Company Info</a>
                                </li>
                            </ul>
                            <div class="tab-content ml-1" id="myTabContent">
                                <div class="tab-pane fade show active" id="basicInfo" role="tabpanel" aria-labelledby="basicInfo-tab">

                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Identify :</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.studentId}
                                        </div>
                                    </div>
                                    <hr />

                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">First Name</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                           ${student.firstName}
                                        </div>
                                    </div>
                                    <hr />

                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Last Name</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.lastName}
                                        </div>
                                    </div>
                                    <hr />


                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Group</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.studentGroup}
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Note Com</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.noteCom}
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Note Tech</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.noteTech}
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Description of Mission</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                           ${student.description}
                                        </div>
                                    </div>
                                    <hr />
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Comments</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.comment}
                                        </div>
                                    </div>
                                    <hr />

                                </div>
                                <div class="tab-pane fade" id="connectedServices" role="tabpanel" aria-labelledby="ConnectedServices-tab">
                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Name</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.companyName}
                                        </div>
                                    </div>
                                    <hr />

                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Address</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.address}
                                        </div>
                                    </div>
                                    <hr />

                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Charger</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.charger}
                                        </div>
                                    </div>
                                    <hr />

                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">Start Date</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                           ${student.startDate}
                                        </div>
                                    </div>
                                    <hr />

                                    <div class="row">
                                        <div class="col-sm-3 col-md-2 col-5">
                                            <label style="font-weight:bold;">End date</label>
                                        </div>
                                        <div class="col-md-8 col-6">
                                            ${student.endDate}
                                        </div>
                                    </div>
                                    <hr />
                                </div>
                                <div>
                                    <button class="btn btn-success" onclick="javascript :history.back(-1);" type="button">Go back</button>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>

            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
</body>


</html>