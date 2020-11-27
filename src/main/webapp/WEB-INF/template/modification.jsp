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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dtsel-master/dtsel.css"/>
    <style>
        .row {
            margin-top: 10px;
            margin-bottom: 10px;
        }

        li {
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
            <div id="alert" class="alert alert-warning alert-danger" style="display: none">
                <a href="#" class="close" data-dismiss="alert">&times;</a>
                <strong>Error! </strong>Operation failed!
            </div>
            <div id="alert1" class="alert alert-warning alert-warning" style="display: none">
                <a href="#" class="close" data-dismiss="alert">&times;</a>
                <strong>Attention! </strong>Element end with <span style="color: red">*</span> can't be empty!
            </div>
            <div id="alert2" class="alert alert-warning alert-warning" style="display: none">
                <a href="#" class="close" data-dismiss="alert">&times;</a>
                <strong>Attention! </strong>Format of note is not correct!
            </div>
            <div class="card">
                <div class="card-body">
                    <div class="card-title mb-4">
                        <div class="d-flex justify-content-start">
                            <div class="image-container">
                                <img src="${pageContext.request.contextPath}/static/img/head.png" id="imgProfile"
                                     style="width: 150px; height: 150px"
                                     class="img-thumbnail"/>
                            </div>
                            <div class="userData ml-3">
                                <h2 class="d-block"
                                    style="font-size: 1.5rem; font-weight: bold">${student.firstName} ${student.lastName}</h2>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <ul class="nav nav-tabs mb-4" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="basicInfo-tab" data-toggle="tab" href="#basicInfo"
                                       role="tab">Basic Info</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="connectedServices-tab" data-toggle="tab"
                                       href="#connectedServices" role="tab">Company Info</a>
                                </li>
                            </ul>
                            <form id="form" name="form" class="form-group">
                                <div class="tab-content ml-1" id="myTabContent">
                                    <div class="tab-pane fade show active" id="basicInfo" role="tabpanel"
                                         aria-labelledby="basicInfo-tab">

                                        <%--                                        <input type="hidden" name="_method" value="put"/>--%>
                                        <input hidden id="contextPaht" value="">
                                        <input hidden id="studentId" name="studentId" class="form-control" type="text"
                                               value="${student.studentId}">

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">First Name</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="firstName" name="firstName" class="form-control" type="text"
                                                       required="" value="${student.firstName}">
                                            </div>
                                        </div>
                                        <hr/>

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Last Name</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="lastName" name="lastName" class="form-control" type="text"
                                                       required="" value="${student.lastName}">
                                            </div>
                                        </div>
                                        <hr/>


                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Group</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <select id="studentGroup" name="studentGroup" class="form-control">
                                                    <c:forEach items="${groups}" var="group">
                                                        <option value="${group}" <c:if
                                                                test="${student.studentGroup == group}"> selected </c:if> >${group}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Note Com</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="noteCom" name="noteCom" class="form-control" type="number"
                                                       max="20" min="0" value="${student.noteCom}">
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Note Tech</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="noteTech" name="noteTech" class="form-control" type="number"
                                                       max="20" min="0" value="${student.noteTech}">
                                            </div>
                                        </div>
                                        <hr/>

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Description of Mission</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <textarea id="description" name="description" class="form-control"
                                                          size="30">${student.description}</textarea>
                                            </div>
                                        </div>
                                        <hr/>
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Comment</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <textarea id="comment" name="comment"
                                                          class="form-control">${student.comment}</textarea>
                                            </div>
                                        </div>
                                        <hr/>

                                    </div>
                                    <div class="tab-pane fade" id="connectedServices" role="tabpanel"
                                         aria-labelledby="ConnectedServices-tab">
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Company Name</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="companyName" name="companyName" class="form-control"
                                                       type="text" required="" value="${student.companyName}">
                                            </div>
                                        </div>
                                        <hr/>

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Address</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="address" name="address" class="form-control" type="text"
                                                       required="" value="${student.address}">
                                            </div>
                                        </div>
                                        <hr/>

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Charger</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="charger" name="charger" class="form-control" type="text"
                                                       required="" value="${student.charger}">
                                            </div>
                                        </div>
                                        <hr/>

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Start Date</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="startDate" name="startDate"
                                                       class="form-control" required="" readonly="true"
                                                       value="${student.startDate}"/>
                                            </div>
                                        </div>
                                        <hr/>

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">End date</label>&nbsp;<span
                                                    style="color: red">*</span>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                <input id="endDate" name="endDate" readonly="true" class="form-control"
                                                       required="" value="${student.endDate}"/>
                                            </div>
                                        </div>
                                        <hr/>
                                    </div>
                                </div>

                            </form>
                            <div class="row">
                                <button class="btn btn-success col-md-1 ml-3" onclick="javascript :history.back(-1);"
                                        type="button">Go back
                                </button>
                                <button id="btnSub" class="btn btn-success col-md-1 ml-auto ">Submit</button>
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
<script src="${pageContext.request.contextPath}/static/dtsel-master/dtsel.js"></script>
<script>
    instance = new dtsel.DTS('input[name="startDate"]', {
        direction: 'BOTTOM'
    });

    instance = new dtsel.DTS('input[name="endDate"]', {
        direction: 'BOTTOM'
    })

    function getContextPath() {
        let contextPath = document.location.pathname;
        let index = contextPath.substr(1).indexOf("/");
        contextPath = contextPath.substr(0, index + 1);
        return contextPath;
    }

    $(
        function () {
            let contextPath = getContextPath();
            let path = "/student";
            if (!contextPath === "/student") {
                path = contextPath + path;
            }
            console.log(path);
            let id = $('#studentId').val();
            let method = (id === '') ? 'post' : 'put';
            $("#btnSub").click(function () {
                let student = new Object();

                student.studentId = $('#studentId').val();
                student.firstName = $('#firstName').val();
                student.lastName = $('#lastName').val();
                student.address = $('#address').val();
                student.companyName = $('#companyName').val();
                student.charger = $('#charger').val();
                student.startDate = $('#startDate').val();
                student.endDate = $('#endDate').val();
                student.description = $('#description').val();
                student.comment = $('#comment').val();
                student.studentGroup = $('#studentGroup').val();
                student.noteCom = $('#noteCom').val();
                student.noteTech = $('#noteTech').val();

                if (student.firstName === '' || student.lastName === '' || student.address === '' || student.companyName === ''
                    || student.charger === '' || student.startDate === '' || student.endDate === '' || student.studentGroup === '') {
                    $("#alert1").attr('style', 'display:block');
                } else if ((student.noteTech !== '' && isNaN(student.noteTech)) || (student.noteCom !== '' && isNaN(student.noteCom))) {
                    $('#alert2').attr('style', 'display:block');
                } else {
                    let res = JSON.stringify(student);
                    $.ajax({
                        url: path,
                        data: res,
                        async: true,
                        dataType: 'json',
                        contentType: 'application/json',
                        type: method,
                        success: function (data) {
                            if (data.msg === 'success') {
                                window.location.href = path + 's';
                            } else {
                                $('#alert').attr('style', 'display:block');
                            }
                        },
                        fail: function () {
                            $('#alert').attr('style', 'display:block');
                        }
                    })
                }

            });
        }
    )
</script>
</body>


</html>