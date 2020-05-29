<?php 
    require_once('connection.php');
    if( $_SERVER['REQUEST_METHOD'] == 'POST' ){      
        $search = $_POST['search'];
        $table = 't_buku';
        $sql = "SELECT * FROM $table WHERE
                judul LIKE '%$search%' OR
                jenis LIKE '%$search%' OR
                halaman LIKE '%$search%' OR
                bahasa LIKE '%$search%' OR
                penulis LIKE '%$search%' OR
                tahun LIKE '%$search%'
                ORDER BY judul ASC
        ";
        $res = mysqli_query($con, $sql);
        $result = [];
        while( $row = mysqli_fetch_array($res) ) {
            array_push($result, [
                'id'=>$row[0], 
                'judul'=>$row[1], 
                'gambar'=>$row[2], 
                'jenis'=>$row[3], 
                'halaman'=>$row[4], 
                'bahasa'=>$row[5], 
                'penulis'=>$row[6],
                'tahun'=>$row[6],
            ]);
        }
        echo json_encode(["value"=>1, "result"=>$result]);
        mysqli_close($con);
    }
?>