package Services;

import Config.DbConfig;
import Models.*;

import java.io.*;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

import Utils.*;

public class ProductService implements GenericService<Product> {
    private static ProductService instance = null;

    private ProductService() {
    }

    public static ProductService getInstance() {
        if (instance == null)
            instance = new ProductService();
        return instance;
    }

    @Override
    public List<Product> GetAll() {
        return null;
    }

    @Override
    public void SaveIntoCSV() {
        try {
            File file = new File("./StoreApp/src/CSV/coffeeMaker.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The coffeeMaker CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/fridge.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The fridge CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/monitor.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The monitor CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/peripheral.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The peripheral CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/personalComputer.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The personalComputer CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/phone.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The phone CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/vacuumCleaner.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The vacuumCleaner CSV file was created!");
                }
            }
            file = new File("./StoreApp/src/CSV/washingMachine.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The washingMachine CSV file was created!");
                }
            }
        } catch (IOException e) {
            System.out.println("Error while creating the CSV files");
        }
        StoreService s = StoreService.getInstance();
        List<Store> stores = s.GetAll();
        for (Store store : stores) {
            List<Pair<Integer, Product>> stock = s.GetStockOfAStore(store.getStoreId());
            if (stock == null)
                continue;
            for (Pair<Integer, Product> p : stock) {
                String type = p.Second().getProductType();
                try {
                    if (Objects.equals(type, "Coffee Maker")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/coffeeMaker.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Fridge")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/fridge.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Monitor")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/monitor.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Peripheral")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/peripheral.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "PersonalComputer/Laptop")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/personalComputer.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Phone")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/phone.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Vaccum Cleaner")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/vacuumCleaner.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }
                    if (Objects.equals(type, "Washing Machine")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/washingMachine.csv", false));
                        writer.write(store.getStoreId() + ", " + p.First() + ", " + p.Second().getCSVFormat() + "\n");
                        writer.close();
                    }


                } catch (IOException m) {
                    System.out.println("Error while saving the date in CSV files");
                }
            }
        }
    }

    @Override
    public void ReadFromCSV() {
        try {
            try {
                File file = new File("./StoreApp/src/CSV/coffeeMaker.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The coffeeMaker CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/fridge.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The fridge CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/monitor.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The monitor CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/peripheral.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The peripheral CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/personalComputer.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The personalComputer CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/phone.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The phone CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/vacuumCleaner.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The vacuumCleaner CSV file was created!");
                    }
                }
                file = new File("./StoreApp/src/CSV/washingMachine.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The washingMachine CSV file was created!");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error while creating the CSV files");
            }

            StoreService s = StoreService.getInstance();
            BufferedReader reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/coffeeMaker.csv"));
            String product;

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new CoffeeMaker(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), Integer.parseInt((product.split(",")[5].trim())));
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/fridge.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Fridge(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())), Integer.parseInt((product.split(",")[7].trim())), Integer.parseInt((product.split(",")[8].trim())), Boolean.parseBoolean((product.split(",")[9].trim())));
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/monitor.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Monitor(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())), Integer.parseInt((product.split(",")[7].trim())), Integer.parseInt((product.split(",")[8].trim())));
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/peripheral.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Peripheral(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), Boolean.parseBoolean((product.split(",")[5].trim())),
                        (product.split(",")[6].trim()));
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/personalComputer.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new PersonalComputer(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())), (product.split(",")[7].trim()), (product.split(",")[8].trim()), (product.split(",")[9].trim()));
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/phone.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new Phone(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), (product.split(",")[5].trim()),
                        Integer.parseInt((product.split(",")[6].trim())), Integer.parseInt((product.split(",")[7].trim())), Integer.parseInt((product.split(",")[8].trim())), Integer.parseInt((product.split(",")[9].trim())),
                        product.split(",")[10].trim());
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/vacuumCleaner.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new VacuumCleaner(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), Integer.parseInt((product.split(",")[5].trim())),
                        (product.split(",")[6].trim()), Integer.parseInt((product.split(",")[7].trim())));
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

            reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/washingMachine.csv"));

            while ((product = reader.readLine()) != null) {
                String storeId = product.split(",")[0].trim();
                int amount = Integer.parseInt(product.split(",")[1].trim());
                Product p = new WashingMachine(Integer.parseInt((product.split(",")[2].trim())), Integer.parseInt((product.split(",")[3].trim())), (product.split(",")[4].trim()), Integer.parseInt((product.split(",")[5].trim())),
                        Integer.parseInt((product.split(",")[6].trim())), Integer.parseInt((product.split(",")[7].trim())), Integer.parseInt((product.split(",")[8].trim())));
                s.AddStock(Integer.parseInt(storeId), p, amount);
            }

        } catch (IOException m) {
            System.out.println("Store Service File Error!" + m);
        }
    }

    @Override
    public void SaveIntoDB() {
        try {
            Statement statement = DbConfig.getInstance().getDbConnection().createStatement();
            StoreService s = StoreService.getInstance();

            String queryD = "DELETE FROM JavaDB.CoffeeMaker WHERE 1=1;";
            statement.executeUpdate(queryD);
            queryD = "DELETE FROM JavaDB.Fridge WHERE 1=1;";
            statement.executeUpdate(queryD);
            queryD = "DELETE FROM JavaDB.Monitor WHERE 1=1;";
            statement.executeUpdate(queryD);
            queryD = "DELETE FROM JavaDB.Peripheral WHERE 1=1;";
            statement.executeUpdate(queryD);
            queryD = "DELETE FROM JavaDB.PersonalComputer WHERE 1=1;";
            statement.executeUpdate(queryD);
            queryD = "DELETE FROM JavaDB.Phone WHERE 1=1;";
            statement.executeUpdate(queryD);
            queryD = "DELETE FROM JavaDB.VacuumCleaner WHERE 1=1;";
            statement.executeUpdate(queryD);
            queryD = "DELETE FROM JavaDB.WashingMachine WHERE 1=1;";
            statement.executeUpdate(queryD);

            List<Store> stores = s.GetAll();
            for (Store store : stores) {
                List<Pair<Integer, Product>> stock = s.GetStockOfAStore(store.getStoreId());
                if (stock == null)
                    continue;
                for (Pair<Integer, Product> p : stock) {
                    String type = p.Second().getProductType();
                    try {
                        if (Objects.equals(type, "Coffee Maker")) {
                            String query = "INSERT INTO JavaDb.CoffeeMaker (ProductId, Price, Name, WaterTankSize, StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }
                        if (Objects.equals(type, "Fridge")) {
                            String query = "INSERT INTO JavaDb.Fridge (ProductId, Price, Name, Size, Width, Height, Depth, HasFreezer, StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }
                        if (Objects.equals(type, "Monitor")) {
                            String query = "INSERT INTO JavaDb.Monitor (ProductId, Price, Name, PixelWidth , PixelHeight, RefreshRate, Size, StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }
                        if (Objects.equals(type, "Peripheral")) {
                            String query = "INSERT INTO JavaDb.Peripheral (ProductId, Price, Name, Wireless, Connection, StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }
                        if (Objects.equals(type, "PersonalComputer/Laptop")) {
                            String query = "INSERT INTO JavaDb.PersonalComputer(ProductId, Price, Name,Ram, Storage, CPU, GPU, PSU,StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }
                        if (Objects.equals(type, "Phone")) {
                            String query = "INSERT INTO JavaDb.Phone (ProductId, Price, Name, CPU, ScreenHeight, ScreenWidth, RefreshRate, Storage, Color, StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }
                        if (Objects.equals(type, "Vaccum Cleaner")) {
                            String query = "INSERT INTO JavaDb.VacuumCleaner (ProductId, Price, Name, Weight, Color, Power, StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }
                        if (Objects.equals(type, "Washing Machine")) {
                            String query = "INSERT INTO JavaDb.WashingMachine (ProductId, Price, Name, Size, Width, Height, Depth ,StoreId, Amount) VALUES (" + p.Second().getDBFormat() + "," + store.getStoreId() + "," + p.First() + ")";
                            statement.executeUpdate(query);
                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void ReadFromDB() {
        try {
            StoreService s = StoreService.getInstance();
            Statement statement = DbConfig.getInstance().getDbConnection().createStatement();
            String query = "SELECT * FROM JavaDB.CoffeeMaker";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int ProductId = Integer.parseInt(resultSet.getString("ProductId"));
                int Price = Integer.parseInt(resultSet.getString("Price"));
                String Name = resultSet.getString("name");
                int WaterTankSize = Integer.parseInt(resultSet.getString("WaterTankSize"));
                int StoreId = Integer.parseInt(resultSet.getString("storeId"));
                int Amount = Integer.parseInt(resultSet.getString("Amount"));
                Product p = new CoffeeMaker(ProductId, Price, Name, WaterTankSize);
                s.AddStock(StoreId, p, Amount);
            }
            statement = DbConfig.getInstance().getDbConnection().createStatement();
            query = "SELECT * FROM JavaDB.Fridge";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int ProductId = Integer.parseInt(resultSet.getString("ProductId"));
                int Price = Integer.parseInt(resultSet.getString("Price"));
                String Name = resultSet.getString("name");
                int Size = Integer.parseInt(resultSet.getString("Size"));
                int Width = Integer.parseInt(resultSet.getString("Width"));
                int Height = Integer.parseInt(resultSet.getString("Height"));
                int Depth = Integer.parseInt(resultSet.getString("Depth"));
                int StoreId = Integer.parseInt(resultSet.getString("storeId"));
                int Amount = Integer.parseInt(resultSet.getString("Amount"));
                Boolean HasFreezer = Boolean.parseBoolean(resultSet.getString("HasFreezer"));
                Product p = new Fridge(ProductId, Price, Name, Size, Width, Height, Depth, HasFreezer);
                s.AddStock(StoreId, p, Amount);
            }
            statement = DbConfig.getInstance().getDbConnection().createStatement();
            query = "SELECT * FROM JavaDB.Monitor";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int ProductId = Integer.parseInt(resultSet.getString("ProductId"));
                int Price = Integer.parseInt(resultSet.getString("Price"));
                String Name = resultSet.getString("name");
                int PixelWidth = Integer.parseInt(resultSet.getString("PixelWidth"));
                int PixelHeight = Integer.parseInt(resultSet.getString("PixelHeight"));
                int RefreshRate = Integer.parseInt(resultSet.getString("RefreshRate"));
                int Size = Integer.parseInt(resultSet.getString("Size"));
                int StoreId = Integer.parseInt(resultSet.getString("storeId"));
                int Amount = Integer.parseInt(resultSet.getString("Amount"));
                Product p = new Monitor(ProductId, Price, Name, PixelHeight, PixelWidth, RefreshRate, Size);
                s.AddStock(StoreId, p, Amount);
            }
            statement = DbConfig.getInstance().getDbConnection().createStatement();
            query = "SELECT * FROM JavaDB.Peripheral";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int productId = Integer.parseInt(resultSet.getString("ProductId"));
                int price = Integer.parseInt(resultSet.getString("Price"));
                String name = resultSet.getString("Name");
                boolean wireless = Boolean.parseBoolean(resultSet.getString("Wireless"));
                int StoreId = Integer.parseInt((resultSet.getString("StoreId")));
                int Amount = Integer.parseInt((resultSet.getString("Amount")));
                String connection = resultSet.getString("Connection");

                Product peripheral = new Peripheral(productId, price, name, wireless, connection);
                s.AddStock(StoreId, peripheral, Amount);
            }
            statement = DbConfig.getInstance().getDbConnection().createStatement();
            query = "SELECT * FROM JavaDB.PersonalComputer";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int productId = Integer.parseInt(resultSet.getString("ProductId"));
                int price = Integer.parseInt(resultSet.getString("Price"));
                String name = resultSet.getString("Name");
                int ram = Integer.parseInt(resultSet.getString("Ram"));
                int storage = Integer.parseInt(resultSet.getString("Storage"));
                String CPU = resultSet.getString("CPU");
                String GPU = resultSet.getString("GPU");
                String PSU = resultSet.getString("PSU");
                int StoreId = Integer.parseInt((resultSet.getString("StoreId")));
                int Amount = Integer.parseInt((resultSet.getString("Amount")));

                Product pc = new PersonalComputer(productId, price, name, ram, storage, CPU, GPU, PSU);
                s.AddStock(StoreId, pc, Amount);
            }
            statement = DbConfig.getInstance().getDbConnection().createStatement();
            query = "SELECT * FROM JavaDB.Phone";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int productId = Integer.parseInt(resultSet.getString("ProductId"));
                int price = Integer.parseInt(resultSet.getString("Price"));
                String name = resultSet.getString("Name");
                String CPU = resultSet.getString("CPU");
                int screenHeight = Integer.parseInt(resultSet.getString("ScreenHeight"));
                int screenWidth = Integer.parseInt(resultSet.getString("ScreenWidth"));
                int screenRefreshRate = Integer.parseInt(resultSet.getString("ScreenRefreshRate"));
                int storage = Integer.parseInt(resultSet.getString("Storage"));
                String color = resultSet.getString("Color");
                int StoreId = Integer.parseInt((resultSet.getString("StoreId")));
                int Amount = Integer.parseInt((resultSet.getString("Amount")));

                Product phone = new Phone(productId, price, name, CPU, screenHeight, screenWidth, screenRefreshRate, storage, color);

                s.AddStock(StoreId, phone, Amount);
            }
            statement = DbConfig.getInstance().getDbConnection().createStatement();
            query = "SELECT * FROM JavaDB.VacuumCleaner";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int productId = Integer.parseInt(resultSet.getString("ProductId"));
                int price = Integer.parseInt(resultSet.getString("Price"));
                String name = resultSet.getString("Name");
                int weight = Integer.parseInt(resultSet.getString("Weight"));
                String color = resultSet.getString("Color");
                int power = Integer.parseInt(resultSet.getString("Power"));
                int StoreId = Integer.parseInt((resultSet.getString("StoreId")));
                int Amount = Integer.parseInt((resultSet.getString("Amount")));

                Product vacuumCleaner = new VacuumCleaner(productId, price, name, weight, color, power);
                s.AddStock(StoreId, vacuumCleaner, Amount);
            }
            statement = DbConfig.getInstance().getDbConnection().createStatement();
            query = "SELECT * FROM JavaDB.WashingMachine";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int productId = Integer.parseInt(resultSet.getString("ProductId"));
                int price = Integer.parseInt(resultSet.getString("Price"));
                String name = resultSet.getString("Name");
                int size = Integer.parseInt(resultSet.getString("Size"));
                int width = Integer.parseInt(resultSet.getString("Width"));
                int height = Integer.parseInt(resultSet.getString("Height"));
                int depth = Integer.parseInt(resultSet.getString("Depth"));
                int StoreId = Integer.parseInt((resultSet.getString("StoreId")));
                int Amount = Integer.parseInt((resultSet.getString("Amount")));

                WashingMachine washingMachine = new WashingMachine(productId, price, name, size, width, height, depth);

                // Do something with the created WashingMachine object
            }
        }
        catch (SQLException e) {
            System.out.println("A aparut o problema la incarcarea Agentiilor Imobiliare din baza de date.");
        }
    }

}
