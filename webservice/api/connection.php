<?php 
    define('DB_HOST', 'localhost');
    define('DB_USER', 'id13747406_perpustakaan');
    define('DB_PASS', 'S?C4JU@geAK9BxC]');
    define('DB_NAME', 'id13747406_db_perpustakaan');
    
    $con = mysqli_connect(
        DB_HOST, 
        DB_USER, 
        DB_PASS, 
        DB_NAME
        )
    
    OR DIE('Gagal Terhubung Ke Database');
    
?>