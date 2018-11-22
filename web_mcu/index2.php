<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Smart-Home</title>
</head>

<body>
	<table>
		<tr>
			<td>
				<img src=IMG/TV_ON.jpg width=200 height=200>			</td>
			<td>
				<img src=IMG/MUSIC_OFF.jpg width=200 height=200>			</td>
			<td>
				<img src=IMG/LIGHT_OFF.jpg width=200 height=200>			</td>
			<td>
				<img src=IMG/FAN_OFF.jpg width=200 height=200>			</td>
			<td>
				<img src=IMG/AC.jpg width=200 height=200><font size=50px color=#000000><b>25<b/></font>¡ãc			</td>
		</tr>
		<tr>
			<td>
				<form action="Data_Handler_TV1.php" method="get">
				<input type="radio" name="Status" value="1" /> ON
				<br />
				<input type="radio" name="Status" value="0" /> OFF
				<br>
				<input type="submit" value="Change" />
				</form>
			</td>
			<td>
				<form action="Data_Handler_MUSIC1.php" method="get">
				<input type="radio" name="Status" value="1" /> ON
				<br />
				<input type="radio" name="Status" value="0" /> OFF
				<br>
				<input type="submit" value="Change" />
				</form>
			</td>
			<td>
				<form action="Data_Handler_LIGHT1.php" method="get">
				<input type="radio" name="Status" value="1" /> ON
				<br />
				<input type="radio" name="Status" value="0" /> OFF
				<br>
				<input type="submit" value="Change" />
				</form>
			</td>
			<td>
				<form action="Data_Handler_FAN1.php" method="get">
				<input type="radio" name="Status" value="1" /> ON
				<br />
				<input type="radio" name="Status" value="0" /> OFF
				<br>
				<input type="submit" value="Change" />
				</form>
			</td>
			<td>
				<form action="Data_Handler_AC1.php" method="get">
				Temperture: 
				<input type="text" name="Status" />	
				<br>
				<input type="submit" value="Change" />
				</form>
			</td>
		</tr>
	</table>
</body>


</html>