<?php 
    require_once('connection.php');
    if( $_SERVER['REQUEST_METHOD'] == 'GET' ){
        $sql = "SELECT * FROM t_buku ORDER BY id ASC";
        $res = mysqli_query($con, $sql);
        $result = [];
        while( $row = mysqli_fetch_array($res) ) {
            array_push($result,[
                    'id'=>$row[0],
                    'judul'=>$row[1],
                    'gambar'=>$row[2],
                    'jenis'=>$row[3],
                    'halaman'=>$row[4],
                    'bahasa'=>$row[5],
                    'penulis'=>$row[6],
                    'tahun'=>$row[7],
            ]);
        }
        echo json_encode(["value"=>1, "result"=>$result]);
        mysqli_close($con);
    }
?>