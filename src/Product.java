import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Product {

    private static List<Product> products = new ArrayList<Product>();
    protected static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    protected int id;
    private String name;
    private double price;
    private int quantity;
    protected Brand brand;
    private int storage;
    private double screenSize;
    private int ram;
    protected String color;
    protected double batteryCapacity;

    public Product(String name, double price, int quantity, Brand brand, int storage,
            double screenSize, int ram) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }   

    public double getBatteryCapacity() {
        return batteryCapacity;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getRam() {
        return ram;
    }

    public static void delete() {
        System.out.println("Enter the ID of the product to delete:");
        int idToDelete = scanner.nextInt();
    
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId() == idToDelete) {
                if (product instanceof Notebook) {
                    Notebook.notebooks.remove(product);
                } else if (product instanceof Phone) {
                    Phone.phones.remove(product);
                }
                products.remove(product);
                System.out.println(product.getName() + " with ID " + idToDelete + " has been deleted.");
                return;
            }
        }
        
        System.out.println("Product with ID " + idToDelete + " was not found.");
    }

    public static void list(String productType) {
        List<Product> products;
        if (productType.equalsIgnoreCase("Notebook")) {
            products = Notebook.notebooks;
        } else if (productType.equalsIgnoreCase("Phone")) {
            products = Phone.phones;
        } else {
            System.out.println("Invalid product type");
            return;
        }
        System.out.printf("%-5s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s",
            "ID", "Name", "Price", "Quantity", "Brand", "Storage", "ScreenSize", "RAM");
        if (productType.equalsIgnoreCase("Phone")) {
            System.out.printf(" | %-20s | %-10s", "Battery Capacity", "Color");
        }
        System.out.println();
        for (int i = 0; i < 130; i++) {
            System.out.print("-");
        }
        if (productType.equalsIgnoreCase("Phone")) {
            for (int i = 0; i < 20;i++){
                System.out.print("-");
            }
        }
        System.out.println();
    
        for (Product product : products) {
            System.out.printf("%-5s | %-30s | $%-9.2f | %-10d | %-10s | %-10d | %-10.2f | %-10d",
                product.getId(), product.getName(), product.getPrice(), product.getQuantity(),
                product.getBrand().getName(), product.getStorage(), product.getScreenSize(),
                product.getRam());
            if(productType.equalsIgnoreCase("Phone")){
                System.out.printf(" | %-20s | %-10s", product.getBatteryCapacity(), product.getColor());
            }
            System.out.println();
        }
    }
    
    
    public static void add(String productType){
        System.out.println("Enter the name of the product:");
        String name = scanner.next();
        
        double price = getPositiveDoubleInput("Enter the price of the product: ");
        int quantity = getPositiveIntegerInput("Enter the quantity of the product: ");
        System.out.println("Enter the brand of the product: ");
        String brand = scanner.next();
        if(!Brand.isBrand(brand)){
            Brand.brands.add(new Brand(brand));
            System.out.println("A new brand has been created: " + brand);
        }
        int storage = getPositiveIntegerInput("Enter the storage capacity of the product: ");
        double screenSize = getPositiveDoubleInput("Enter the screen size of the product: ");        
        int ram = getPositiveIntegerInput("Enter the RAM of the product:");
        double batteryCapacity = 0.0;
        String color = "";
        if(productType.equalsIgnoreCase("Phone")){
            batteryCapacity = getPositiveDoubleInput("Enter the battery capacity of the product: ");
            System.out.println("Enter the color of the product:");
            color = scanner.next();
        }
        if(productType.equalsIgnoreCase("Notebook")){
            Notebook newNotebook = new Notebook(name, price, quantity, Brand.getByName(brand), storage, screenSize, ram);
            System.out.println("A new notebook has been created: " + newNotebook.getName());
        } else if(productType.equalsIgnoreCase("Phone")){
            Phone newPhone = new Phone(name, price, quantity, Brand.getByName(brand), storage, screenSize, ram, batteryCapacity, color);
            System.out.println("A new phone has been created: " + newPhone.getName());
        }
    }

    public static int getPositiveIntegerInput(String prompt) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive number.");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input <= 0);
        scanner.nextLine();
        return input;
    }
    
    public static double getPositiveDoubleInput(String prompt) {
        double input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a positive number.");
                scanner.next();
            }
            input = scanner.nextDouble();
        } while (input <= 0);
        scanner.nextLine();
        return input;
    }
    
}
