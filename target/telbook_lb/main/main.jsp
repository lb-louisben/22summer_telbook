<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<jsp:include page="/main/head.jsp"></jsp:include>
				</div>
				<div id="content">
					<table border="0" width="100%">
						<tr>
							<td width="15%" valign="top">
								<p id="whereami"></p>
								<jsp:include page="/main/menu.jsp"></jsp:include>
							</td>
							<td>
								<jsp:include page="/index.jsp"></jsp:include>
							</td>
						</tr>
					</table>

				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
</body>
</html>