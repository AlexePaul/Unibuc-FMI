package Models;
@SuppressWarnings({"unused"})
public class Store {
    private int StoreId;
    private String Address;
    public Store(String address, int id) {
        Address = address;
        StoreId = id;
    }

    public int getStoreId() {
        return StoreId;
    }

    public void setStoreId(int storeId) {
        StoreId = storeId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
