<?php
include "db.php";

$title = $_POST['title'];
$description = $_POST['description'];
$category = $_POST['category'];

$query = mysqli_query($conn,
    "INSERT INTO reports(title, description, category)
    VALUES('$title','$description','$category')"
);

if ($query) {
    echo json_encode(["status" => "success"]);
} else {
    echo json_encode(["status" => "failed"]);
}
?>