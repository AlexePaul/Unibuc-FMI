package Services;

import Config.DbConfig;
import Exceptions.ExceptionInvalidValue;
import Models.Product;
import Models.Store;
import Utils.Pair;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.Math.max;
@SuppressWarnings("unused")
public class StoreService implements GenericService<Store> {

    static StoreService instance = null;
    List<Store> Stores = new ArrayList<>();
    TreeMap<Integer, List<Pair<Integer, Product>>> Stock = new TreeMap<>();

    private StoreService(){}

    public static StoreService getInstance(){
        if(instance == null)
            instance = new StoreService();
        return instance;
    }
    @Override
    public List<Store> GetAll(){
        return Stores;
    }

    @Override
    public void SaveIntoCSV(){
            try{
                File file = new File("./StoreApp/src/CSV/store.csv");
                if (!file.exists() || file.isDirectory()) {
                    if (file.createNewFile()) {
                        System.out.println("The store CSV file was created!");
                    }
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter("./StoreApp/src/CSV/store.csv", false));

                for(Store st : Stores) {
                    writer.write(st.getStoreId() + ", "+ st.getAddress() + "\n");
                }
                writer.close();

            }
            catch(IOException m){
                System.out.println("StoreFile Error!" + m);
            }
    }
    @Override
    public void ReadFromCSV() {
        try{
            File file = new File("./StoreApp/src/CSV/store.csv");
            if (!file.exists() || file.isDirectory()) {
                if (file.createNewFile()) {
                    System.out.println("The store CSV file was created!");
                }
            }
            BufferedReader reader = new BufferedReader(new FileReader("./StoreApp/src/CSV/store.csv"));
            String store;

            while ((store = reader.readLine()) != null) {
                Store st = new Store(store.split(",")[1].trim(), Integer.parseInt(store.split(",")[0].trim()));
                AddStore(st);
            }
        }
        catch(IOException m){
            System.out.println("Store Service File Error!" + m);
        }
    }

    @Override
    public void SaveIntoDB(){
        try {
            Statement statement = DbConfig.getInstance().getDbConnection().createStatement();
            String query = "DELETE FROM JavaDB.Store WHERE 1=1;";
            statement.executeUpdate(query);
            for(Store st : Stores) {
                query = "INSERT INTO JavaDB.Store (StoreId, Address) VALUES (" + st.getStoreId() + ", '" + st.getAddress() + "')";
                statement.executeUpdate(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void ReadFromDB(){
        try {
            Statement statement = DbConfig.getInstance().getDbConnection().createStatement();
            String query = "SELECT * FROM JavaDB.Store";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Store st = new Store(resultSet.getString("Address"), Integer.parseInt(resultSet.getString("StoreId")));
                AddStore(st);
            }
        }
        catch (SQLException e) {
            System.out.println("A aparut o problema la incarcarea Agentiilor Imobiliare din baza de date.");
        }
    }

    public boolean CheckStore(int storeId){
        for(Store st : Stores)
            if (st.getStoreId() == storeId) {
                return true;
            }
        return false;
    }
    public boolean AddStore(Store StoreToAdd){
        boolean checkStore = false;
        for(Store st : Stores)
            if (st.getStoreId() == StoreToAdd.getStoreId()) {
                checkStore = true;
                throw new ExceptionInvalidValue("There is already a Store with the given StoreId");
            }
        if(checkStore)
            return false;
        Stores.add(StoreToAdd);
        return true;
    }
    public List<Pair<Integer, Product>> AddStock(int storeId, Product product, int count){
        boolean checkStore = false;
        for(Store st : Stores)
            if (st.getStoreId() == storeId) {
                checkStore = true;
                break;
            }
        if(!checkStore)
            throw new ExceptionInvalidValue("There is no store with the given StoreId");
        if(!Stock.containsKey(storeId)){
            List<Pair<Integer, Product>>  s = new ArrayList<>();
            s.add(new Pair<>(count, product));
            Stock.put(storeId,s);
            List<Pair<Integer, Product>> l = Stock.get(storeId);
            return l;
        }
        else{
            List<Pair<Integer, Product>> s = Stock.get(storeId);
            boolean ok = false;
            for (Pair<Integer, Product> integerProductPair : s) {
                if (integerProductPair.Second() == product) {
                    integerProductPair.SetFirst(integerProductPair.First() + count);
                    ok = true;
                }
            }
            if(!ok){
                s.add(new Pair<>(count, product));
            }
            return Stock.replace(storeId,s);
        }
    }

    public List<Pair<Integer, Product>> CheckStock(int storeId){
        return Stock.get(storeId);
    }

    public Set<Product> GetStockGraterThan0(int storeId){
        if(!CheckStore(storeId))
            throw new ExceptionInvalidValue("There is no store with the given StoreId");
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        Set<Product> setP = new HashSet<>();
        for(Pair<Integer, Product> st : s){
            if(st.First() > 0)
                setP.add(st.Second());
        }
        return setP;
    }

    public void checkStock(int storeId){ //this will remove a product from the list if it's stock is 0
        if (!CheckStore(storeId))
            throw new ExceptionInvalidValue("There is no store with the given StoreId");
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        for(int i = 0; i < s.size(); i++){
            if(s.get(i).First() == 0) {
                s.remove(i);
                i = 0;
            }
        }
    }

    public boolean removeStock(int storeId, int productId, int count){
        if(!CheckStore(storeId))
            throw new ExceptionInvalidValue("There is no store with the given StoreId");
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        for(Pair<Integer, Product> st : s) {
            if(st.Second().getProductId() == productId){
                st.SetFirst(max(0,st.First()-count));
                checkStock(storeId);
                return true;
            }
        }
        return false;
    }

    public boolean checkStockOfAProduct(int storeId, int productId) {
        if (!CheckStore(storeId))
            throw new ExceptionInvalidValue("There is no store with the given StoreId");
        List<Pair<Integer, Product>> s = Stock.get(storeId);
        for (Pair<Integer, Product> st : s) {
            if (st.Second().getProductId() == productId && st.First() > 0) {
                return true;
            }
        }
        return false;
    }

    public List<Pair<Integer, Product>> GetStockOfAStore(int storeId) {return Stock.get(storeId);}

    public int numberOfStores() {return Stores.size();}
    public int numberOfProductsInStore(int storeId){return Stock.get(storeId).size();}
}
