<?php

include "db.php";


$id = $_POST['id'];


$query = mysqli_query($conn,
"DELETE FROM reports WHERE id='$id'"
);


if($query){

    echo json_encode([
        "status"=>"success",
        "message"=>"Data berhasil dihapus"
    ]);

}else{

    echo json_encode([
        "status"=>"failed",
        "message"=>"Gagal menghapus"
    ]);

}

?>