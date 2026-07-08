<?php
include "db.php";

$query = mysqli_query($conn, "SELECT * FROM reports ORDER BY id DESC");

$data = array();

while ($row = mysqli_fetch_assoc($query)) {
    $data[] = $row;
}

echo json_encode($data);
?>