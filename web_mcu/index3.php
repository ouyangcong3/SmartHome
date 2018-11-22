<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Smart-Home</title>
</head>

<?php
	$conn = mysql_connect("localhost", "zjwdb_491469", "A1s2d3f4");
	if(!$conn)
	{
		die('Failed' . mysql_error());
	}
	mysql_select_db("zjwdb_491469", $conn);
?>
<body>
	<table>
		<tr>
			<td>
				<?php
					$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='TV'");
					$row = mysql_fetch_array($result);
					$Tem_Status = $row['furniture_status'];
					if($Tem_Status == 1)
					{
						echo "<img src=IMG/TV_ON.jpg width=200 height=200>";
					}
					else
					{
						echo "<img src=IMG/TV_OFF.jpg width=200 height=200>";
					}
				?>
			</td>
			<td>
				<?php
					$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='MUSIC'");
					$row = mysql_fetch_array($result);
					$Tem_Status = $row['furniture_status'];
					if($Tem_Status == 1)
					{
						echo "<img src=IMG/MUSIC_ON.jpg width=200 height=200>";
					}
					else
					{
						echo "<img src=IMG/MUSIC_OFF.jpg width=200 height=200>";
					}
				?>
			</td>
			<td>
				<?php
					$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='LIGHT'");
					$row = mysql_fetch_array($result);
					$Tem_Status = $row['furniture_status'];
					if($Tem_Status == 1)
					{
						echo "<img src=IMG/LIGHT_ON.jpg width=200 height=200>";
					}
					else
					{
						echo "<img src=IMG/LIGHT_OFF.jpg width=200 height=200>";
					}
				?>
			</td>
			<td>
				<?php
					$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='FAN'");
					$row = mysql_fetch_array($result);
					$Tem_Status = $row['furniture_status'];
					if($Tem_Status == 1)
					{
						echo "<img src=IMG/FAN_ON.jpg width=200 height=200>";
					}
					else
					{
						echo "<img src=IMG/FAN_OFF.jpg width=200 height=200>";
					}
				?>
			</td>
			<td>
				<?php
				echo "<img src=IMG/AC.jpg width=200 height=200>";
				$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='AC'");
				$row = mysql_fetch_array($result);
				$Tem_Status = $row['furniture_status'];
				echo "<font size=50px color=#000000><b>$Tem_Status<b/></font>";
				echo "°c";
				?>
			</td>
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

<?php
	mysql_close($conn);
?>

</html>