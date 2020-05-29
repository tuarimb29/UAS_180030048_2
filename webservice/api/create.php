<?php 
    require_once('connection.php');
    if( $_SERVER['REQUEST_METHOD'] == 'POST' ){
        $response = [];
        $judul = $_POST['judul'];
        $gambar = $_POST['gambar'];
        $jenis = $_POST['jenis'];
        $halaman = $_POST['halaman'];
        $bahasa = $_POST['bahasa'];
        $penulis = $_POST['penulis'];
        $tahun = $_POST['tahun'];
        $table = 't_buku';
        $sql = "SELECT * FROM $table WHERE judul = '$judul'";
        $check = mysqli_fetch_array(mysqli_query($con, $sql));
        if(isset($check)){
            $response["value"] = 0;
            $response["message"] = "Buku Berjudul $judul Sudah Tersedia";
            echo json_encode($response);
        } else {
            $sql = "INSERT INTO $table 
                    VALUES (0, '$judul', '$gambar', '$jenis', '$halaman', '$bahasa', '$penulis', '$tahun')";
            $res = mysqli_query($con, $sql);
            if( $res ){
                $response["value"] = 1;
                $response["message"] = "Data Buku Berhasil Ditambahkan";
                echo json_encode($response);
            } else {
                $response["value"] = 0;
                $response["message"] = "Data Buku Gagal Ditambahkan";
                echo json_encode($response);
            }
        }
    } else {
        $response["value"] = 0;
        $response["message"] = "Gagal Menambah Data Buku, Silahkan Coba Lagi";
        echo json_encode($response);
    }
?>