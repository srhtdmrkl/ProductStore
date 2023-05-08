import java.util.ArrayList;
import java.util.List;

public class Notebook extends Product {

    static List<Product> notebooks = new ArrayList<>();

    public Notebook(String name, double price, int quantity, Brand brand, int storage,
    double screenSize, int ram) {
        super(name, price, quantity, brand, storage, screenSize, ram);
        notebooks.add(this);
    }    

}
