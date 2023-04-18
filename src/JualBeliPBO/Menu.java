package JualBeliPBO;

import java.util.ArrayList;

public class Menu {
    private static ArrayList<String> namaMenu;
    private ArrayList<Double> hargaMenu;

    public Menu(ArrayList<String> namaMenu, ArrayList<Double> hargaMenu) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
    }

    public static ArrayList<String> getNamaMenu() {
        return namaMenu;
    }

    public ArrayList<Double> getHargaMenu() {
        return hargaMenu;
    }
}