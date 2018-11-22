<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv=refresh content="0.1;url=http://ouyangcong3.top/index.php">
<title>Data_Handler</title>

<body>
	<p>
	  <?php 
		$conn = mysql_connect("localhost", "zjwdb_491469", "A1s2d3f4");
		if(!$conn)
		{
			die('Failed' . mysql_error());
		}
		mysql_select_db("zjwdb_491469", $conn);
		
		$Tem_Status = $_GET["Status"];
		$query = sprintf("UPDATE furniture_status2 SET furniture_status = %d WHERE furniture_name = 'FAN'", $Tem_Status);
		mysql_query($query);
		
		mysql_close($conn);
		echo "OK!";
	?>
	<br>
</p>
	<p><a href="index.php">Back </a></p>
</body>


</html>
