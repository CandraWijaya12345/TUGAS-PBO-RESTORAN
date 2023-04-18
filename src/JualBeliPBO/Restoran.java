package JualBeliPBO;
import java.util.ArrayList;
import java.util.Scanner;

public class Restoran {
    private static ArrayList<Restoran> daftarRestoran = new ArrayList<>();
    private static ArrayList<Menu> menuu = new ArrayList<>();

//    public static ArrayList<Pesanan> pesanann = new ArrayList<>();
    private String namaRestoran;
    private String alamatRestoran;
    private static ArrayList<String> daftarMenu;
    private static ArrayList<Double> harga;

    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<Restoran> setDaftarRestoran;

    public Restoran(String namaRestoran, String alamatRestoran, ArrayList<String> daftarMenu, ArrayList<Double> harga) {
        this.namaRestoran = namaRestoran;
        this.alamatRestoran = alamatRestoran;
        this.daftarMenu = daftarMenu;
        this.harga = harga;
    }

    public Restoran() {

    }

    public String getNama() {
        setNama(namaRestoran);
        return namaRestoran;
    }

    public String getAlamat() {
        return alamatRestoran;
    }

    public static ArrayList<String> getDaftarMenu() {
        return daftarMenu;
    }

    public static ArrayList<Double> getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.namaRestoran = nama;
    }

    public void setAlamat(String alamat) {
        this.alamatRestoran = alamat;
    }

//    public void setDaftarMenu(ArrayList<String> daftarMenu) {
//        this.daftarMenu = daftarMenu;
//    }
//
//    public void setHarga(ArrayList<Double> harga) {
//        this.harga = harga;
//    }



    public static int size() {
        return 0;
    }
    public void getDaftarRestoran(){
        setDaftarRestoran = daftarRestoran;
    }

    public static Object get(int i) {
        return null;
    }

    public String toString() {
        return "Restoran || " +
                ", nama=" + namaRestoran + ' ' +
                ", alamat=" + alamatRestoran + ' ';
    }

    public static void tambahRestoran() {
        ArrayList<String> daftarMenu = new ArrayList<>();
        ArrayList<Double> harga = new ArrayList<>();
//        System.out.println("\n\t Press enter to continue...\n");
//        scanner.nextLine();
        System.out.print("Nama Restoran: ");
        String namaRestoran = scanner.nextLine();
        System.out.println(namaRestoran);
        System.out.print("Alamat Restoran: ");
        String alamatRestoran = scanner.nextLine();

        int kembali;

        String menu;
        do {
            System.out.print("Masukkan Jumlah Menu: ");
            int jumlahMenu = Main.validInt();
            for (int i = 0; i < jumlahMenu; i++) {
                System.out.print("Nama Menu " + (i + 1) + ": ");
                menu = scanner.nextLine();
                System.out.print("Harga Menu " + (i + 1) + ": ");
                double hrg = Main.validDouble();
                daftarMenu.add(menu);
                harga.add(hrg);
                Menu menubaru = new Menu(daftarMenu, harga);
                menuu.add(menubaru);
            }
            Restoran restoranTambah = new Restoran(namaRestoran, alamatRestoran, daftarMenu, harga);
            daftarRestoran.add(restoranTambah);
            System.out.print("Apakah anda ingin menambah menu lagi? (1 = ya, 2 = tidak) : ");
            kembali = scanner.nextInt();
            System.out.println("\n\t Press enter to continue...\n");
            scanner.nextLine();
        } while (kembali == 1);
    }


    public static void hapusRestoran() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama restoran yang ingin dihapus : ");
        String namaRestoran = scanner.next();
        boolean found = false;
        int index = 0;
        for (int i = 0; i < daftarRestoran.size(); i++) {
            if (daftarRestoran.get(i).getNama().equalsIgnoreCase(namaRestoran)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            daftarRestoran.remove(index);
            System.out.println("Restoran dengan nama " + namaRestoran + " berhasil dihapus");
        } else {
            System.out.println("Restoran dengan nama " + namaRestoran + " tidak ditemukan");
        }
    }

    public static void lihatRestoran() {
        if (daftarRestoran.size() > 0) {
            for (int i = 0; i < daftarRestoran.size(); i++) {
                System.out.println(i + 1 + ". " + daftarRestoran.get(i).toString());
            }
        } else {
            System.out.println("Tidak ada restoran yang tersedia!");
        }
    }

    public static void lihatMenu() {
        Scanner scanner = new Scanner(System.in);
        if (daftarRestoran.size() > 0) {
            System.out.print("Masukkan nama restoran yang ingin dilihat menunya :");
            String namaRestoran = scanner.next();
            System.out.println("Daftar Menu di Restoran " + namaRestoran + " :");
            if (menuu.size() > 0) {
                for (int i = 0; i < menuu.size(); i++) {
                    Menu menu = menuu.get(i);
                    System.out.println((i + 1) + ". " + Menu.getNamaMenu() + "\tRp " + menu.getHargaMenu());
                }
            } else {
                System.out.println("Tidak ada Menu yang tersedia!");
            }
        } else {
            System.out.println("Tidak ada restoran yang tersedia!");
        }
    }

    public static void buatPesanan() {
        Scanner scanner = new Scanner(System.in);
        if (daftarRestoran.size() > 0) {
            int memesanlagi;
            do {
                Scanner input = new Scanner(System.in);

                String namaResto,menuPesan;
                int jmlhPesanan;
                double harga;
                int i = 1;
                for(Restoran resto : daftarRestoran){
                    System.out.printf("%d- %s ",i, resto);
                    i++;
                }
                System.out.print("Pilih restoran : ");
                int noRes = input.nextInt();
                input.nextLine();

                if(noRes > daftarRestoran.size()) {
                    System.out.println("Restaurant tak tersedia");
                }else{
                    System.out.println("Daftar Menu:");
                    int a = 1;
                    for (String menuu : daftarMenu) {
                        System.out.printf("%d- %s%n",a, menuu);
                        a++;
                    }

                    System.out.print("Pesan menu yang diinginkan: ");
                    int menuu = input.nextInt();
                    input.nextLine();

                    if (menuu > daftarMenu.size()) {
                        System.out.println("Makanan tidak tersedia di menu.");
                    } else {
                        menuPesan = daftarMenu.get(menuu-1);

                        System.out.print("Jumlah: ");
                        int jumlah = input.nextInt();
                        jmlhPesanan = jumlah;


                        double total = 20000;
                        harga = total;
                        Pesanan pesanananTambah = new Pesanan(menuPesan,jmlhPesanan, harga);
                        Pesanan.addPesanan(pesanananTambah);

                    }
                }
                System.out.print("Apakah anda ingin memesan lagi? (1 = ya, 2 = tidak) : ");
                memesanlagi = scanner.nextInt();
            }while(memesanlagi==1);
            }else{
            System.out.println("Restoran tidak tersedia! bawah");
        }
        }
    }

