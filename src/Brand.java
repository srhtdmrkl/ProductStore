import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brand {
    public static List<Brand> brands = new ArrayList<>();
    
    private int nextId = 1;
    private int id;
    private String name;

    public Brand(String name) {
        this.id = nextId++;
        this.name = name;
        brands.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Brand getByName(String name) {
        for(Brand brand : brands) {
            if(brand.getName().equalsIgnoreCase(name)){
                return brand;
            }
        }
        return null;
    }
    
    public static List<Brand> sortByName() {
        Collections.sort(brands, (b1, b2) -> b1.name.compareTo(b2.name));
        return brands;
    }

    public static void listByName(){
        List<Brand> brands = Brand.sortByName();
        System.out.println("List of Brands:");
        System.out.println("------------------------------");
        for (Brand brand : brands) {
            System.out.println(" - " + brand.getName());
        }
        System.out.println("------------------------------");
    }

    public static boolean isBrand(String brandName) {
        for (Brand brand : brands) {
            if (brand.getName().equalsIgnoreCase(brandName)) {
                return true;
            }
        }
        return false;
    }

}
