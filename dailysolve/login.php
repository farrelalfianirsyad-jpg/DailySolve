<?php

include "db.php";


if(isset($_POST['username_email']) && isset($_POST['password'])){


$username_email = $_POST['username_email'];
$password = $_POST['password'];



$query = mysqli_query($conn,

"SELECT * FROM users 
WHERE 
(username='$username_email' 
OR email='$username_email')
AND password='$password'"

);



if(mysqli_num_rows($query)>0){


echo json_encode([
"status"=>"success",
"message"=>"Login berhasil"
]);


}else{


echo json_encode([
"status"=>"failed",
"message"=>"Username/email atau password salah"
]);


}


}else{


echo json_encode([
"status"=>"failed",
"message"=>"Data kosong"
]);


}

?>