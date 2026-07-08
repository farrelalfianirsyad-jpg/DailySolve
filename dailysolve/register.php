<?php

include "db.php";


if(isset($_POST['username']) && 
   isset($_POST['email']) && 
   isset($_POST['password'])){


    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];


    // cek email atau username sudah ada
    $check = mysqli_query($conn,
        "SELECT * FROM users 
         WHERE username='$username' 
         OR email='$email'"
    );


    if(mysqli_num_rows($check) > 0){

        echo json_encode([
            "status"=>"failed",
            "message"=>"Username atau email sudah terdaftar"
        ]);


    } else {


        $query = mysqli_query($conn,
            "INSERT INTO users(username,email,password)
             VALUES('$username','$email','$password')"
        );


        if($query){

            echo json_encode([
                "status"=>"success",
                "message"=>"Register berhasil"
            ]);

        }else{

            echo json_encode([
                "status"=>"failed",
                "message"=>"Register gagal"
            ]);

        }

    }


}else{


    echo json_encode([
        "status"=>"failed",
        "message"=>"Data tidak lengkap"
    ]);


}

?>