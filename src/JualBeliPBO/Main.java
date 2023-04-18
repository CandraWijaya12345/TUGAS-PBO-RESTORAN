package JualBeliPBO;
import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Login user_login = new Login();
        JualBeliPBO.Restoran restoran = new JualBeliPBO.Restoran();



        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean berhasilLogin = false;
        System.out.println("+======SELAMAT DATANG DAN HAPPY SHOPPING=======||");
        System.out.println("||Silahkan masukkan Username dan Password anda!||");
        do {
            boolean masuk = true;
            System.out.print("UserName Anda: ");
            String user = bf.readLine();
            System.out.print("Password Anda: ");
            String pw = bf.readLine();
            System.out.println("================================================");

            if (user.equals(user_login.getUser()) && pw.equals(user_login.getPw_user()) || user.equals(user_login.getAdmin()) && pw.equals(user_login.getPw_admin())) {
                int loginkembali;
                if (user.equals(user_login.getUser())) {
                    System.out.println("=====Selamat datang customer======");
                    do{
                        System.out.println("1. Lihat Restaurant");
                        System.out.println("2. Buat Pesanan");
                        System.out.println("3. Lihat Pesanan");
                        System.out.println("4. Kembali ke login");
                        System.out.print("Pilihlah aksi yang Anda inginkan : ");
                        String choice = bf.readLine();
                        switch (choice){
                            case"1":
                                restoran.lihatMenu();
                                break;
                            case"2":
                                restoran.buatPesanan();
                                break;
                            case"3":
                                Pesanan.lihatPesanan();
                                break;
                        }
                        System.out.print("Apakah Anda ingin login kembali? (1 = ya, 2 = tidak) : ");
                        loginkembali = scanner.nextInt();
                        System.out.println("\n\t Press enter to continue...\n");
                        scanner.nextLine();
                    }while(loginkembali==2);

                } else if (user.equals(user_login.getAdmin())) {
                    System.out.println("======Selamat datang Admin======");
                    do {
                        System.out.println("1. Lihat daftar restoran");
                        System.out.println("2. Tambah restoran");
                        System.out.println("3. Hapus restoran");
                        System.out.println("4. Kembali ke login");
                        System.out.print("Pilihlah aksi yang Anda inginkan : ");
                        String choice = bf.readLine();
                        switch (choice) {
                            case "1":
                                restoran.lihatRestoran();
                                break;

                            case "2":
                                restoran.tambahRestoran();
                                break;

                            case "3":
                                restoran.hapusRestoran();
                                break;

                            case "4":
                                 masuk = false;
                                 break;
                        }
                        System.out.print("Apakah Anda ingin login kembali? (1 = ya, 2 = tidak) : ");
                    loginkembali = scanner.nextInt();
                    } while (loginkembali==2);
                }
            } else {
                System.out.println("Username atau Password Anda tidak sesuai, silahkan coba lagi!");
            }
        } while (!berhasilLogin);
    }
    public static double validDouble(){
        double inp;
        Scanner scan = new Scanner(System.in);
        // System.out.print("\t=> ");
        while(true){
            try{
                inp = scan.nextDouble();
                scan.nextLine();
                return inp;
                // break;
            }catch(InputMismatchException e){
                System.out.print("\tInput salah!, Ulang\n\t=> ");
                scan.nextLine();
            }
        }
    }

    public static int validInt(){
        int inp;
        Scanner scan = new Scanner(System.in);
        System.out.print("\t=> ");
        while(true){
            try{
                inp = scan.nextInt();
                scan.nextLine();
                return inp;
                // break;
            }catch(InputMismatchException e){
                System.out.print("\tInput salah!, Ulang\n\t=> ");
                scan.nextLine();
            }
        }
    }
}