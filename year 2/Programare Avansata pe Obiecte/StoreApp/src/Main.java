import Exceptions.ExceptionInvalidValue;
import Models.*;
import Services.AuditService;
import Services.ProductService;
import Services.StoreService;
import Utils.Pair;
import Utils.Resolution;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static StoreService s = StoreService.getInstance();
    public static ProductService p = ProductService.getInstance();

    public static void AddStore(){
        scanner.nextLine();
        System.out.println("Please provide the Address for the store: ");
        String Address = scanner.nextLine();
        System.out.println("Please provide the Id for the store: ");
        int storeId = scanner.nextInt();
        while(!s.AddStore(new Store(Address, storeId))){
            System.out.println("The given Store Id is already in use, pick another one: ");
            storeId = scanner.nextInt();
        }
        AuditService.getInstance().writeMessage("A store with the id: " + storeId + " And the address " + Address + " was Added");
        System.out.println("Store Added");
    }

    public static void getAllStores(){
        AuditService.getInstance().writeMessage("A list of all the stores was printed");
        List<Store> stores = s.GetAll();
        for(Store st : stores){
            System.out.println("Store address: " + st.getAddress());
            System.out.println("Store Id: " + st.getStoreId());
            System.out.println();
        }
        System.out.println("Press Enter To Continue!");
        String s = scanner.nextLine();
        s = scanner.nextLine();
    }

    public static void AddProduct(String input){
        System.out.println("Please provide the Store Id where to add the new product: ");
        int storeId = scanner.nextInt();
        System.out.println("Please provide the amount of the new products you want to add");
        int count = scanner.nextInt();
        System.out.println("Please provide the productId of the new product:");
        int productId = scanner.nextInt();
        System.out.println("Please provide the price of the new product:");
        int price = scanner.nextInt();
        System.out.println("Please provide the name of the new product");
        scanner.nextLine();
        String name = scanner.nextLine();
        AuditService.getInstance().writeMessage("A product with the following characteristics was added {"
                                                + " storeId: " + storeId
                                                + " count: " + count
                                                + " productId: " + productId
                                                + " price: " + price + " }");
        if(input == "Coffee"){
            System.out.println("Please provide the Water tank size of the coffee maker in cl:");
            int size = scanner.nextInt();
            while(s.AddStock(storeId, new CoffeeMaker(productId, price, name, size), count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
        if(input == "Fridge"){
            System.out.println("Please provide the size of the fridge in liters: ");
            int size = scanner.nextInt();
            System.out.println("Please provide the height of the fridge: ");
            int height = scanner.nextInt();
            System.out.println("Please provide the width of the fridge: ");
            int width = scanner.nextInt();
            System.out.println("Please provide the depth of the fridge: ");
            int depth = scanner.nextInt();
            System.out.println("Please provide if the fridge has a freezer: ");
            boolean hasFreezer = scanner.nextBoolean();
            while(s.AddStock(storeId, new Fridge(productId, price, name, size,width,height,depth,
                            hasFreezer),count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
        if(input == "Monitor"){
            System.out.println("Please provide the number of vertical pixels: ");
            int pixelHeight = scanner.nextInt();
            System.out.println("Please provide the number of horizontal pixels: ");
            int pixelWidth = scanner.nextInt();
            System.out.println("Please provide the refresh rate of the monitor: ");
            int refreshRate = scanner.nextInt();
            System.out.println("Please provide the size of the monitor: ");
            int size = scanner.nextInt();
            while(s.AddStock(storeId, new Monitor(productId, price, name, pixelHeight, pixelWidth,
                            refreshRate, size), count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
        if(input == "Peripheral"){
            System.out.println("Please provide whether the device has wireless or not 1/0: ");
            boolean wireless = scanner.nextBoolean();
            System.out.println("Please provide the Connection port of the device: ");
            scanner.nextLine();
            String connection = scanner.nextLine();
            while(s.AddStock(storeId, new Peripheral(productId, price, name,wireless, connection),
                    count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
        if(input == "PersonalComputer"){
            System.out.println("Please provide the amount of RAM: ");
            int RAM = scanner.nextInt();
            System.out.println("Please provide the amount of storage in Gb: ");
            int storage = scanner.nextInt();
            System.out.println("Please Provide the name of the CPU");
            scanner.nextLine();
            String CPU = scanner.nextLine();
            System.out.println("Please Provide the name of the GPU");
            String GPU = scanner.nextLine();
            System.out.println("Please Provide the name of the PSU");
            String PSU = scanner.nextLine();
            while(s.AddStock(storeId, new PersonalComputer(productId, price, name, RAM, storage,
                            CPU, GPU, PSU), count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
        if(input == "Phone"){
            System.out.println("Please provide the number of vertical pixels: ");
            int pixelHeight = scanner.nextInt();
            System.out.println("Please provide the number of horizontal pixels: ");
            int pixelWidth = scanner.nextInt();
            System.out.println("Please provide the refresh rate: ");
            int refreshRate = scanner.nextInt();
            System.out.println("Please provide the Amount Of Storage in Gb: ");
            int storage = scanner.nextInt();
            System.out.println("Please Provide the name of the CPU: ");
            scanner.nextLine();
            String CPU = scanner.nextLine();
            System.out.println("Please Provide the Color of the Phone: ");
            String color = scanner.nextLine();
            while(s.AddStock(storeId, new Phone(productId, price, name, CPU,
                            pixelHeight, pixelWidth, refreshRate, storage, color),
                    count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
        if(input == "VacuumCleaner"){
            System.out.println("Please provide the weight in kg: ");
            int weight = scanner.nextInt();
            System.out.println("Please provide the power in Watts: ");
            int power = scanner.nextInt();
            System.out.println("Please Provide the color of the vacuum cleaner: ");
            scanner.nextLine();
            String color = scanner.nextLine();
            while(s.AddStock(storeId, new VacuumCleaner(productId, price, name, weight, color,
                            power), count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
        if(input == "WashingMachine"){
            System.out.println("Please provide the size of the Washing Machine in liters: ");
            int size = scanner.nextInt();
            System.out.println("Please provide the height of the Washing Machine: ");
            int height = scanner.nextInt();
            System.out.println("Please provide the width of the Washing Machine: ");
            int width = scanner.nextInt();
            System.out.println("Please provide the depth of the Washing Machine: ");
            int depth = scanner.nextInt();
            while(s.AddStock(storeId, new WashingMachine(productId, price, name, size,width,height,depth),
                    count) == null){
                System.out.println("The given Store Id doesn't exist, pick another one: ");
                storeId = scanner.nextInt();
            }
        }
    }

    public static void getAllProducts(){
        System.out.println("Please provide the Store Id where to check: ");
        int storeId = scanner.nextInt();
        while(!s.CheckStore(storeId)){
            System.out.println("The given Store Id doesn't exist, pick another one: ");
            storeId = scanner.nextInt();
        }
        AuditService.getInstance().writeMessage("The stock of the store with the store id: " + storeId + " was checked");
        List<Pair<Integer, Product>> stock = s.CheckStock(storeId);
        for(Pair<Integer, Product> st : stock){
            System.out.println("Product Name: " + st.Second().getName());
            System.out.println("Product Count: " + st.First());
            System.out.println();
        }
        System.out.println("Press Enter To Continue!");
        String s = scanner.nextLine();
    }

    public static void main(String[] args) throws IOException {
        int input = 2;
        AuditService.getInstance().writeMessage("The program has started");
        s.ReadFromCSV();
        p.ReadFromCSV();
        do{
            try {
                System.out.println("1. Add a Store");
                System.out.println("2. Get all stores");
                System.out.println("3. Add a CoffeeMaker");
                System.out.println("4. Add a Fridge");
                System.out.println("5. Add a Monitor");
                System.out.println("6. Add a Peripheral");
                System.out.println("7. Add a PersonalComputer");
                System.out.println("8. Add a Phone");
                System.out.println("9. Add a VacuumCleaner");
                System.out.println("10. Add a WashingMachine");
                System.out.println("11. Check all the products in a Store");
                input = scanner.nextInt();
                try {
                    switch (input) {
                        case 1 -> AddStore();
                        case 2 -> getAllStores();
                        case 3 -> AddProduct("Coffee");
                        case 4 -> AddProduct("Fridge");
                        case 5 -> AddProduct("Monitor");
                        case 6 -> AddProduct("Peripheral");
                        case 7 -> AddProduct("PersonalComputer");
                        case 8 -> AddProduct("Phone");
                        case 9 -> AddProduct("VacuumCleaner");
                        case 10 -> AddProduct("WashingMachine");
                        case 11 -> getAllProducts();
                    }
                } catch (ExceptionInvalidValue m) {
                    System.out.println(m);
                    scanner.nextLine();
                    input = 12;
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } catch (InputMismatchException e){
                System.out.println(e);
                scanner.nextLine();
                input = 12;
            } catch (Exception e){
                System.out.println(e);
                scanner.nextLine();
                input = 12;
            }
        }while(input != 0);
        AuditService.getInstance().writeMessage("The program has stopped");
        s.SaveIntoCSV();
        p.SaveIntoCSV();
        s.SaveIntoDB();
        p.SaveIntoDB();
    }
}