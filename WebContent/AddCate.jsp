<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý danh mục - Thêm mới</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>

<link href="css/manager.css" rel="stylesheet" type="text/css" />
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Thêm <b>danh mục</b>
						</h2>
					</div>
					<div class="col-sm-6"></div>
				</div>
			</div>
		</div>
		<div id="editEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form action="addcate" method="post">
						<div class="modal-header">
							<h4 class="modal-title">Thêm danh mục</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Tên danh mục</label> 
								<input name="name" type="text"
									class="form-control" required>
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" value="Cancel">
					<input type="submit" class="btn btn-success" value="Add">
				</div>
				</form>

			</div>
		</div>
	</div>
	<a href="home"><button type="button" class="btn btn-primary">Back
			to home</button></a>
	</div>


	<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>