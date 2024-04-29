package Models;
@SuppressWarnings("unused")
public class WashingMachine extends Product{

    private int Size; //this will represent the actual size in liters of the fridge
    private int Width;
    private int Height;
    private int Depth;

    @Override
    public String getProductType() {
        return "Washing Machine";
    }

    @Override
    public String getCSVFormat(){
        return getBaseCSVString() + Size + ", " + Width + ", " + Height + ", " + Depth;
    }
    @Override
    public String getDBFormat(){
        return getBaseDBString() + Size + ", " + Width + ", " + Height + ", " + Depth;
    }
    public WashingMachine(int productId, int price, String name, int size, int width, int height,
                          int depth) {
        super(productId, price, name);
        Size = size;
        Width = width;
        Height = height;
        Depth = depth;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getDepth() {
        return Depth;
    }

    public void setDepth(int depth) {
        Depth = depth;
    }
}
