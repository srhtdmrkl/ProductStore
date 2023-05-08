import java.util.Scanner;

public class StoreManagement {

    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        
        while (true) {
            System.out.println("PatikaStore Management Panel\n1 - Notebook\n2 - Phone\n3 - List Brands\n0 - Exit");
            
            int choice;
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    displayMenu("Notebook");
                    break;
                case 2:
                    displayMenu("Phone");
                    break;
                case 3:
                    Brand.listByName();
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void displayMenu(String productType) {


        System.out.println(productType + " Menu\n1 - List\n2 - Add\n3 - Delete\n0 - Back");
        
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                list(productType);
                break;
            case 2:
                add(productType);
                break;
            case 3:
                delete(productType);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void list(String productType){
        Product.list(productType);
        displayMenu(productType);
    }

    public static void add(String productType){
        if(productType.equals("Notebook")){
            Notebook.add(productType);
        } else if(productType.equals("Phone")){
            Phone.add(productType);
        }
        displayMenu(productType);
    }

    public static void delete(String productType){
        if(productType.equals("Notebook")){
            Notebook.delete();
        } else if(productType.equals("Phone")){
            Phone.delete();
        }
        displayMenu(productType);
    }

    

}
