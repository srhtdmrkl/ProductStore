public class App {
    public static void main(String[] args) throws Exception {
        
        ProductPopulator.populateProducts();
        
        StoreManagement.run();
    }
}
