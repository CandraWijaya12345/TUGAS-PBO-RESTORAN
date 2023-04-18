package JualBeliPBO;

import java.util.ArrayList;

public class Pesanan {

    private static String namaResto;
    private static String menuPesan;
    private static int jmlhPesanan;
    private static double harga;
    static ArrayList<Pesanan> pesananan = new ArrayList<>();


    public static void addPesanan(Pesanan pesanan){
        pesananan.add(pesanan);
    }

    public String getNamaResto(int i) {
        return namaResto;
    }

    public void setNamaResto() {
        this.namaResto = namaResto;
    }

    public Pesanan( String menuPesan , int jmlhPesanan, double harga) {;
        this.menuPesan = menuPesan;
        this.jmlhPesanan = jmlhPesanan;
        this.harga = harga;
//        this.namaResto = namaResto;
    }

    public String getMenuPesan() {
        return  menuPesan;
    }

    public void setMenuPesan(String menuPesan) {
        this.menuPesan = menuPesan;
    }

    public int getJmlhPesanan() {
        return jmlhPesanan;
    }

    public void setJmlhPesanan(int jmlhPesanan) {
        this.jmlhPesanan = jmlhPesanan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public static void lihatPesanan(){
        if(pesananan.size()==0){
            System.out.println("Tidak ada pesanan");
        }

        for(Pesanan pesanan : pesananan){
            System.out.printf("\nPesanan : %s  \nJumlah pesan : %d  \nTotal Harga : Rp%f \n", pesanan.getMenuPesan(),pesanan.getJmlhPesanan(),pesanan.getHarga());
        }
    }
}
