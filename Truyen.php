<?php
$host ="localhost";
$username ="id20784220_truyen123";
$pass="Truyen123";

class Truyen{
    function __construct($ten,$chap,$anh){
        $this->tentruyen=$ten;
        $this->tenchap=$chap;
        $this->linkanh=$anh;
    }

}


$conn = msqli_connect("$host","$pass","$username");
mysqli_set_charset($com,'uft8');

$sql = 'SELECT * FROM `Truyen`';
$query = mysqli_query($conn,$sql);

$arr = array();

while($row = mysqli_fetch_assoc($query)){
    $ten = $row['Tentruyen'];
    $chap = $row['Chapmoi'];
    $anh = $row['Anhtruyen'];
    
    array_push($arr,new Truyen($ten,$chap,$anh));
}
$json = json_encode($arr);
echo $json;

?>