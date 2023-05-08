import java.util.ArrayList;
import java.util.List;

public class ProductPopulator {
    
    public static List<Product> populateProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        //populate brands
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand("Samsung"));
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Huawei"));
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("HP"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Monster"));

        // populate phones
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("SAMSUNG GALAXY A51", 3199.0, 3, Brand.getByName("Samsung"), 128, 6.5, 6, 4000.0, "Siyah"));
        phones.add(new Phone("iPhone 11 64 GB", 7379.0, 3, Brand.getByName("Apple"), 64, 6.1, 6, 3046.0, "Mavi"));
        phones.add(new Phone("Redmi Note 10 Pro 8GB", 4012.0, 1, Brand.getByName("Xiaomi"), 128, 6.5, 12, 4000.0, "Beyaz"));

        // populate notebooks
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("HUAWEI Matebook 14", 7000.0, 10, Brand.getByName("Huawei"), 512, 14.0, 16));
        notebooks.add(new Notebook("LENOVO V14 IGL", 3699.0, 10, Brand.getByName("Lenovo"), 1024, 14.0, 8));
        notebooks.add(new Notebook("ASUS Tuf Gaming", 8199.0, 10, Brand.getByName("Asus"), 2048, 15.6, 32));

        // add phones and notebooks to products list
        products.addAll(phones);
        products.addAll(notebooks);

        return products;
    }
}
