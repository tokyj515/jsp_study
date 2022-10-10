<%
	int x = 3;
	int y = 4;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실제 계산기 모양(jsp)</title>
<style>
	input{
		height: 50px;
		width: 50px;
	}
	
	.output{
		height:50px;
		width:50px;
		background: #e9e9e9;
		font-size: 24px;
		font-weight: bold;
		text-align: right;
		padding: 0px 5px;
	}
</style>
</head>
<body>
	<form action="calc3" method="post">
		<table>
			<tr>
				<td class="output" colspan = "4">${3+4}</td>
			</tr>
			<tr>
				<td><input type="submit" name="operator" value="CE" /></td>
				<td><input type="submit" name="operator" value="C" /></td>
				<td><input type="submit" name="operator" value="BS" /></td>
				<td><input type="submit" name="operator" value="/" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="7" /></td>
				<td><input type="submit" name="value" value="8" /></td>
				<td><input type="submit" name="value" value="9" /></td>
				<td><input type="submit" name="operator" value="*" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="4" /></td>
				<td><input type="submit" name="value" value="5" /></td>
				<td><input type="submit" name="value" value="6" /></td>
				<td><input type="submit" name="operator" value="-" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="1" /></td>
				<td><input type="submit" name="value" value="2" /></td>
				<td><input type="submit" name="value" value="3" /></td>
				<td><input type="submit" name="operator" value="+" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="operator" value=" Â±" /></td>
				<td><input type="submit" name="value" value="0" /></td>
				<td><input type="submit" name="dot" value="." /></td>
				<td><input type="submit" name="operator" value="=" /></td>
			</tr>
		
		</table>
	</form>
</body>
</html>





