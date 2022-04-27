<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>boardDetail</title>

    <!-- Custom fonts for this template -->
    <link href="${path }/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${path }/resources/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="${path }/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       		<c:import url="/WEB-INF/views/common/sidebar.jsp"/>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
				<c:import url="/WEB-INF/views/common/topbar.jsp"/>
  
                <!-- Begin Page Content -->
                 <div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
	                            
	                            <form id="boardDelete" action="${path }/board/boardDelete" method="post" >
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                  <colgroup>
									<col width="25%">
									<col width="75%">
								</colgroup>
                                  
                                  <tr>
                                      <th>게시판 타입</th>
                                      <td>자유게시판 
                                      <input type="hidden" name="board_seq" class="form-control" id="no" value="${boardDetail.board_seq }" readonly>
										</td>
                                  </tr>
                                  <tr>
                                      <th >작성자</th>
                                      <td >${boardDetail.board_writer }</td>
                                   </tr>
                                   <tr>
                                      <th>제목</th>
                                      <td>${boardDetail.board_title }</td>
                                   </tr>
                                   <tr>
                                      <th>내용</th>
                                      <td>${boardDetail.board_text }</td>
                                   </tr>
							      <tr>
							         <td >파일</td>
							          <td>
							            <a href=""></a>   
							         </td>
							      </tr>
							      <tr>
							         <td colspan="2">
										<button class="btn btn-primary" type="button" onclick="location.href='${path}/board/board'">목록으로</button> &nbsp;&nbsp;  
										<!-- type="button" 추가하기 -->
										<!-- &nbsp;는 띄어쓰기, 즉 공백을 나타내는 특수문자  -->
							            <c:if test="${sessionScope.userNick == boardDetail.board_writer }">
							            <button class="btn btn-primary" type="button" onclick="location.href='${path}/board/boardDetailModi?board_seq=${boardDetail.board_seq }'">수정</button> &nbsp;&nbsp;  
							            <%-- <button class="btn btn-primary" onclick="location.href='${path}/board/boardDelete?board_seq=${boardDetail.board_seq }'">삭제</button> &nbsp;&nbsp;  --%>  
							            <a class="btn btn-primary" onclick="return delete_check()">삭제</a> 
							         	</c:if>
							         </td>
							      </tr>
   
                                </table>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

	<script src="${path }/resources/js/boardDetail.js"></script>

    <!-- Bootstrap core JavaScript-->
    <script src="${path }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${path }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${path }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${path }/resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${path }/resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="${path }/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${path }/resources/js/demo/datatables-demo.js"></script>

</body>
</html>