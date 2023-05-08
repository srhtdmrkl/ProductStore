import java.util.ArrayList;
import java.util.List;

public class Phone extends Product{

    static List<Product> phones = new ArrayList<>();

    public Phone(String name, double price, int quantity, Brand brand, int storage,
    double screenSize, int ram, double batteryCapacity, String color) {
        super(name, price, quantity, brand, storage, screenSize, ram);
        this.batteryCapacity = batteryCapacity;
        this.color = color;
        phones.add(this);
    }
    
}
