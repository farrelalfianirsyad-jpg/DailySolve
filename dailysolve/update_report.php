<?php

include "db.php";


$id = $_POST['id'];
$title = $_POST['title'];
$description = $_POST['description'];
$category = $_POST['category'];



$query = mysqli_query($conn,

"UPDATE reports SET

title='$title',
description='$description',
category='$category'

WHERE id='$id'"

);



if($query){

echo json_encode([
"status"=>"success",
"message"=>"Update berhasil"
]);


}else{


echo json_encode([
"status"=>"failed",
"message"=>"Update gagal"
]);

}

?>