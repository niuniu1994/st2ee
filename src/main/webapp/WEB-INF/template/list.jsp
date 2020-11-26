<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Main page</title>
    <!-- Bootstrap core CSS -->
    <link>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .row {
            margin-top: 10px;
            margin-bottom: 10px;
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
<main>
    <div class="container-fluid">
        <div id="myAlert1" class="alert alert-success alert-dismissable" style="display: none">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>Success! </strong>Changes have been saved.
        </div>
        <div id="myAlert3" class="alert alert-warning alert-dismissable" style="display: none">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>Error! </strong>Save changes failed.
        </div>
        <div class="row">

            <div class="col offset-md-9">
                <form id="searchGroup" class="form-inline" method="get" action="#">
                    <input id="keyWord" class="form-control mr-sm-2 b-1" type="search" placeholder="Search"
                           aria-label="Search" value="">
                    <button id="btnSearch" class=" btn btn-sm btn-success " type="submit">Search</button>
                </form>
            </div>


        </div>

        <div class="row">
            <div class="col-md-10 offset-md-1" style="background-color: whitesmoke; border: solid 2px #007bff ">
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                        <tr class="text-center">
                            <th>Gr</th>
                            <th>FIRST NAME</th>
                            <th>LAST NAME</th>
                            <th>CdC</th>
                            <th>FICHE VISIT</th>
                            <th>FICHE EVAL ENTR</th>
                            <th>SONDAGE WEB</th>
                            <th>RAPPORT RENDU</th>
                            <th>SOUT.</th>
                            <th>PLANIF</th>
                            <th>FAITE</th>
                            <th>Detail</th>
                            <th>Edit</th>
                        </tr>
                        </thead>
                        <tbody class="text-center">
                        <c:forEach items="${studentList}" var="student">
                            <tr class="intern">
                                <td>${student.studentGroup}</td>
                                <td>${student.firstName}</td>
                                <td>${student.lastName}</td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="cdc"
                                <c:if test="${student.cdc == true}"> checked </c:if>></td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="fv"
                                <c:if test="${student.fv == true}"> checked </c:if>></td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="fee"
                                <c:if test="${student.fee == true}"> checked </c:if>></td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="sw"
                                <c:if test="${student.sw == true}"> checked </c:if>></td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="rr"
                                <c:if test="${student.rr == true}"> checked </c:if>></td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="sout"
                                <c:if test="${student.sout == true}"> checked </c:if>></td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="plan"
                                <c:if test="${student.plan == true}"> checked </c:if>></td>
                                <td><input class="attribute" type="checkbox" value="${student.studentId}" name="fait"
                                <c:if test="${student.fait == true}"> checked </c:if>></td>
                                <td><a class="btn btn-secondary btn-sm"
                                       href="${pageContext.request.contextPath}/student/${student.studentId}/detail">Detail</a>
                                </td>
                                <td><a class="btn btn-warning btn-sm"
                                       href="${pageContext.request.contextPath}/student/${student.studentId}">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="targetModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="targetModalLabel"></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure about saving the changes ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button id="confirm" type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-1 offset-1 custom-control-inline">
                <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/student" style="margin-right: 10px">Add</a>
                <button class="btn btn-success btn-sm" style="margin-right: 10px" data-toggle="modal"
                        data-target="#targetModal">Save changes
                </button>
            </div>

        </div>
    </div>
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
</main>

<script>
    function getContextPath() {
        let contextPath = document.location.pathname;
        let index = contextPath.substr(1).indexOf("/");
        contextPath = contextPath.substr(0,index+1);
        console.log(contextPath);
        return contextPath;
    }
    $(
        function () {
            let contextPath = getContextPath();
            let path = "/students";
            if (!contextPath === ""){
                path = contextPath + path;
            }
            let arr = [];
            $('.alert').hide();
            $('.attribute').click(function () {
                let flag = false;
                let studentId = $(this).attr('value');
                let name = $(this).attr('name');
                let checked = false;

                if ($(this).prop('checked')) {
                    checked = true;
                }

                $.each(arr, function (index, data) {
                    if (data.studentId === studentId) {
                        let flag2 = false;
                        let nList = data.nameList;
                        let cList = data.checkedList;
                        for (let i = 0; i < nList.length; i++) {
                            if (nList[i] === name) {
                                cList[i] = checked;
                                flag = true;
                                flag2 = true;
                            }
                        }
                        if (!flag2) {
                            data.nameList.push(name);
                            data.checkedList.push(checked);
                            flag = true;
                        }
                    }
                })

                if (!flag) {
                    let nameList = [name];
                    let checkedList = [checked];
                    arr.push({'studentId': studentId, 'nameList': nameList, 'checkedList': checkedList});
                }
                console.log(arr)

            })

            $('#confirm').click(function () {
                $.ajax({
                    url: path,
                    data: JSON.stringify(arr),
                    type: 'put',
                    datatype: 'json',
                    contentType: 'application/json',
                    success: function (data) {
                        data = JSON.parse(data);
                        if (data.msg === 'success') {
                            $('#myAlert1').attr('style', 'display:block');}
                    },
                    fail: function () {
                        $('#myAlert3').attr('style', 'display:block');
                    }
                })
            })

            $('#btnSearch').click(function () {
                let keyWord = $('#keyWord').val();
                if (keyWord !== '') {
                    $('#searchGroup').attr('action', path +'/'+ keyWord);
                }
            })
        }
    )
</script>
<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
</body>

</html>