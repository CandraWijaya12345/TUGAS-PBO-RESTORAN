package JualBeliPBO;
import java.util.ArrayList;
import java.util.Scanner;

public class Restoran {
    private static ArrayList<Restoran> daftarRestoran = new ArrayList<>();
    private static ArrayList<Menu> menuu = new ArrayList<>();

    private static ArrayList<Pesanan> pesanann = new ArrayList<>();
    private String namaRestoran;
    private String alamatRestoran;
    private static ArrayList<String> daftarMenu;
    private ArrayList<Double> harga;

    private static Scanner scanner = new Scanner(System.in);

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

    public ArrayList<Double> getHarga() {
        return harga;
    }

    public void setNama(String nama) {
        this.namaRestoran = nama;
    }

    public void setAlamat(String alamat) {
        this.alamatRestoran = alamat;
    }

    public void setDaftarMenu(ArrayList<String> daftarMenu) {
        this.daftarMenu = daftarMenu;
    }

    public void setHarga(ArrayList<Double> harga) {
        this.harga = harga;
    }

    public static int size() {
        return 0;
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
        System.out.print("Nama Restoran: ");
        String namaRestoran = scanner.nextLine();
        System.out.print("Alamat Restoran: ");
        String alamatRestoran = scanner.nextLine();

        int kembali;
        do {
            System.out.print("Masukkan Jumlah Menu: ");
            int jumlahMenu = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < jumlahMenu; i++) {
                System.out.print("Nama Menu " + (i + 1) + ": ");
                String menu = scanner.nextLine();
                System.out.print("Harga Menu " + (i + 1) + ": ");
                Double hrg = Double.parseDouble(scanner.nextLine());
                daftarMenu.add(menu);
                harga.add(hrg);
                Menu menubaru = new Menu(daftarMenu, harga);
                menuu.add(menubaru);
            }
            Restoran restoranTambah = new Restoran(namaRestoran, alamatRestoran, daftarMenu, harga);
            daftarRestoran.add(restoranTambah);
            System.out.print("Apakah anda ingin menambah menu lagi? (1 = ya, 2 = tidak) : ");
            kembali = scanner.nextInt();
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
                ArrayList<String> daftarMenu = new ArrayList<>(getDaftarMenu());

                Scanner input = new Scanner(System.in);

                System.out.println("Daftar Menu:");

                for (String menu : daftarMenu) {
                    System.out.println("- " + menu);
                }

                ArrayList<String> pesanan = new ArrayList<String>();
                ArrayList<Double> harga = new ArrayList<Double>();

                System.out.print("Pesan menu yang diinginkan: ");
                String menuu = input.nextLine();

                if (!daftarMenu.contains(menuu)) {
                    System.out.println("Makanan tidak tersedia di menu.");
                } else {
                    pesanan.add(menuu);

                    System.out.print("Jumlah: ");
                    int jumlah = input.nextInt();
                    input.nextLine();

                    double hargaMakanan = getHarga(menuu) * jumlah;
                    harga.add(hargaMakanan);

                }
                System.out.print("Apakah anda ingin memesan lagi? (1 = ya, 2 = tidak");
                memesanlagi = scanner.nextInt();
            }while(memesanlagi==1);
            }else{
            System.out.println("Restoran tidak tersedia!");
        }
        }

    private static double getHarga(String menuu) {
        return 0;
    }

    public void lihatPesanan() {
        if (pesanann.size() > 0) {
            for (int i = 0; i < pesanann.size(); i++) {
                System.out.println(i + 1 + ". " + pesanann.get(i).toString());
            }
        }
    }
}
