package Models;
@SuppressWarnings("unused")
public class Peripheral extends Product{

    private boolean Wireless;
    private String Connection;
    @Override
    public String getProductType() {
        return "Peripheral";
    }
    @Override
    public String getCSVFormat(){
        return getBaseCSVString() + Wireless + ", " + Connection;
    }
    @Override
    public String getDBFormat(){
        return getBaseDBString() + Wireless + ", '" + Connection+"'";
    }
    public Peripheral(int productId, int price, String name, boolean wireless, String connection) {
        super(productId, price, name);
        Wireless = wireless;
        Connection = connection;
    }

    public boolean isWireless() {
        return Wireless;
    }

    public void setWireless(boolean wireless) {
        this.Wireless = wireless;
    }

    public String getConnection() {
        return Connection;
    }

    public void setConnection(String connection) {
        Connection = connection;
    }
}
