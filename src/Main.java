package JualBeliPBO;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        JualBeliPBO.Login user_login = new JualBeliPBO.Login();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean berhasilLogin = false;
        System.out.println("+======SELAMAT DATANG DAN HAPPY SHOPPING=======||");
        System.out.println("||Silahkan masukkan Username dan Password anda!||");
        do {
            System.out.print("UserName Anda: ");
            String user = bf.readLine();
            System.out.print("Password Anda: ");
            String pw = bf.readLine();
            System.out.println("================================================");

            if (user.equals(user_login.getUser()) && pw.equals(user_login.getPw_user()) || user.equals(user_login.getAdmin()) && pw.equals(user_login.getPw_admin())) {
                berhasilLogin = true;
                if (user.equals(user_login.getUser())) {
                    System.out.println("Selamat datang customer, selamat berbelanja");
                } else if (user.equals(user_login.getAdmin())) {
                    System.out.println("======Selamat datang Admin======");
                    System.out.println("Berikut merupakan List nama restoran:");
                    System.out.println("Ayam Goreng Robert");
                    System.out.println("Siomay Pak Lebah");
                    System.out.println("Nasi Lawar Buk Novi");

                    boolean exit = false;
                    do {
                        System.out.println("Tentukan Aksi yang anda inginkan!");
                        System.out.println("1. Tambah restoran");
                        System.out.println("2. Hapus restoran");
                        System.out.println("3. Kembali ke login");

                        String choice = scanner.nextLine();

                        switch (choice) {
                            case "1":

                        }
                    } while (!exit);
                }
            } else {
                System.out.println("Username atau Password Anda tidak sesuai, silahkan coba lagi!");
            }
        } while (!berhasilLogin);
    }
}