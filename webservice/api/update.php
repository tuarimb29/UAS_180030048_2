<?php 
    require_once('connection.php');
    if( $_SERVER['REQUEST_METHOD'] == 'POST' ){
        $response = [];
        $id = $_POST['id'];
        $judul = $_POST['judul'];
        $gambar = $_POST['gambar'];
        $jenis = $_POST['jenis'];
        $halaman = $_POST['halaman'];
        $bahasa = $_POST['bahasa'];
        $penulis = $_POST['penulis'];
        $tahun = $_POST['tahun'];
        $table = 't_buku';
        $sql = "UPDATE $table SET
                judul = '$judul',
                gambar = '$gambar',
                jenis = '$jenis',
                halaman = '$halaman',
                bahasa = '$bahasa',
                penulis = '$penulis',
                tahun = '$tahun'
                WHERE id = '$id'
        ";
        if( mysqli_query($con, $sql) ){
            $response['value'] = 1;
            $response['message'] = "Data Buku Berhasil Diperbarui";
            echo json_encode($response);
        } else {
            $response['value'] = 0;
            $response['message'] = "Data Buku Gagal Diperbarui";
            echo json_encode($response);
        }
        mysqli_close($con);
    } else {
        $response['value'] = 0;
        $response['message'] = "Gagal Memperbarui Data Buku, Silahkan Coba Lagi";
        echo json_encode($response);
    }
?>