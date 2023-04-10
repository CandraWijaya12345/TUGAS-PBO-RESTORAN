import java.util.ArrayList;
public class Restoran {
    private String name;
    private String address;
    private ArrayList<String> menu;
    private ArrayList<Double> prices;

    public Restoran (String name, String address, ArrayList<String> menu, ArrayList<Double> prices) {
        this.name = name;
        this.address = address;
        this.menu = menu;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getMenu() {
        return menu;
    }

    public ArrayList<Double> getPrices() {
        return prices;
    }
}
}
