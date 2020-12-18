package model;
import java.sql.*; 
import database.Database;

public class Mahasiswa {
    private String npm;
    private String nama;
    private Double IPK;
    private int jumlahMatKul;
    
    public Mahasiswa(){
        
    }
    
    public Mahasiswa(String npm, String nama, double IPK, int jumlahMatkul){
        this.npm = npm;
        this.nama = nama;
        this.IPK = IPK;
        this.jumlahMatKul = jumlahMatkul;
    }
    
    public void create(){
        String insertQuery = "INSERT INTO `mahasiswa`"
                + "(`npm`, `nama`, `ipk`, `jumlah_matkul`) "
                + "VALUES"
                +"(?,?,?,?)";
        Database database = new Database();
        Connection con = database.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, this.npm);
            ps.setString(2, this.nama);
            ps.setDouble(3, this.IPK);
            ps.setInt(4, this.jumlahMatKul);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void update(){
        String updateQuery = "UPDATE mahasiswa "
                + "SET "
                + "nama = ?, "
                + "ipk = ?, "
                + "jumlah_matkul = ? "
                + "WHERE npm = ?";
        Database database = new Database();
        Connection con = database.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setString(1, this.nama);
            ps.setDouble(2, this.IPK);
            ps.setInt(3, this.jumlahMatKul);
            ps.setString(4, this.npm);
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void delete(){
        Database db = new Database();
        Connection con = db.getConnection();
        
        String deleteQuery = "DELETE FROM mahasiswa where npm = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteQuery);
            ps.setString(1, this.npm);
            ps.execute();
            System.out.println("Hapus Data Berhasil!");
        } catch (SQLException throwables) {
            System.out.println("Hapus Data Gagal");
            throwables.printStackTrace();
        }
        
    }
    
    public void read(){
        String selectQuery = "SELECT * FROM mahasiswa";
        Database database = new Database();
        Connection con = database.getConnection();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(selectQuery);
            System.out.println("NPM       "
                    + " |  Nama      |  IPK   |  Jumlah Mata Kuliah   |");
            while(rs.next()){
                System.out.println(rs.getString("npm")+ "   | "+rs.getString("nama")+"     |  "+rs.getString("ipk")+"     |  "+rs.getString("jumlah_matkul") );
            }
//            System.out.println(selectQuery);
        }catch (SQLException ex){
            System.out.println(ex.toString());
        }
                
    }
    
    public void isiAbsen(){
    
    }
    
    public void tambahMatKul(){
        
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getIPK() {
        return IPK;
    }

    public void setIPK(Double IPK) {
        this.IPK = IPK;
    }

    public int getJumlahMatKul() {
        return jumlahMatKul;
    }

    public void setJumlahMatKul(int jumlahMatKul) {
        this.jumlahMatKul = jumlahMatKul;
    }
}
