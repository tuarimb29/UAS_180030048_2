<?php 
    require_once('connection.php');
    if( $_SERVER['REQUEST_METHOD'] == 'POST' ){
        $response = [];
        $id = $_POST['id'];
        $table = 't_buku';
        $sql = "DELETE FROM $table WHERE id = $id";
        if( mysqli_query($con, $sql) ){
            $response['value'] = 1;
            $response['message'] = "Data Buku Berhasil Dihapus";
            echo json_encode($response);
        } else {
            $response['value'] = 0;
            $response['message'] = "Data Buku Gagal Dihapus";
            echo json_encode($response);
        }
    } else {
        $response['value'] = 0;
        $response['message'] = "Gagal Menghapus Data Buku, Silahkan Coba Lagi";
        echo json_encode($response);
    }
?>