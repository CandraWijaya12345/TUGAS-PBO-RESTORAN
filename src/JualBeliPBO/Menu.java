package JualBeliPBO;

import java.util.ArrayList;

public class Menu {
    private static ArrayList<String> namaMenu;
    private static ArrayList<Double> hargaMenu;

    public Menu(ArrayList<String> namaMenu, ArrayList<Double> hargaMenu) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
    }

    public static void setNamaMenu(ArrayList<String> namaMenu) {
        Menu.namaMenu = namaMenu;
    }

    public void setHargaMenu(ArrayList<Double> hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public static ArrayList<String> getNamaMenu() {
        return namaMenu;
    }

    public ArrayList<Double> getHargaMenu() {
        return hargaMenu;
    }
}
