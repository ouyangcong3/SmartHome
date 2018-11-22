<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Background</title>

<body>
	<?php 
		$conn = mysql_connect("localhost", "zjwdb_491469", "A1s2d3f4");
		if(!$conn)
		{
			die('Failed' . mysql_error());
		}
		mysql_select_db("zjwdb_491469", $conn);
		echo "TV:";
		$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='TV'");
		$row = mysql_fetch_array($result);
		$Tem_Status = $row['furniture_status'];
		echo $Tem_Status;
		
		echo "MUSIC:";
		$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='MUSIC'");
		$row = mysql_fetch_array($result);
		$Tem_Status = $row['furniture_status'];
		echo $Tem_Status;
		
		echo "LIGHT:";
		$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='LIGHT'");
		$row = mysql_fetch_array($result);
		$Tem_Status = $row['furniture_status'];
		echo $Tem_Status;
		
		echo "FAN:";
		$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='FAN'");
		$row = mysql_fetch_array($result);
		$Tem_Status = $row['furniture_status'];
		echo $Tem_Status;
		
		echo "AC:";
		$result = mysql_query("SELECT furniture_status FROM furniture_status2 WHERE furniture_name='AC'");
		$row = mysql_fetch_array($result);
		$Tem_Status = $row['furniture_status'];
		echo $Tem_Status;
		
		mysql_close($conn);
	?>
	
</body>

</html>
