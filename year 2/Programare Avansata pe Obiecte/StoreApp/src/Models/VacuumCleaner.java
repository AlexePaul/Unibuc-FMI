package Models;
@SuppressWarnings("unused")
public class VacuumCleaner extends Product{

    private int Weight;
    private String Color;
    private int Power; //this will be stored in Watts
    @Override
    public String getProductType() {
        return "Vaccum Cleaner";
    }
    @Override
    public String getCSVFormat(){
        return getBaseCSVString() + Weight + ", " + Color + ", " + Power;
    }
    @Override
    public String getDBFormat(){
        return getBaseDBString() + Weight + ",' " + Color + "', " + Power;
    }
    public VacuumCleaner(int productId, int price, String name, int weight, String color,
                         int power) {
        super(productId, price, name);
        Weight = weight;
        Color = color;
        Power = power;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }
}
