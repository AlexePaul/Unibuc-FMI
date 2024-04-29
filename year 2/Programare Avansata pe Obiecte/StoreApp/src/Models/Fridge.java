package Models;
@SuppressWarnings("unused")
public class Fridge extends Product{

    private int Size; //this will represent the actual Size in liters of the fridge
    private int Width;
    private int Height;
    private int Depth;
    private boolean HasFreezer;

    @Override
    public String getProductType() {
        return "Fridge";
    }

    public Fridge(int productId, int price, String name, int size, int width, int height,
                  int depth, boolean hasFreezer) {
        super(productId, price, name);
        Size = size;
        Width = width;
        Height = height;
        Depth = depth;
        HasFreezer = hasFreezer;
    }
    @Override
    public String getCSVFormat(){
        return getBaseCSVString() + Size + ", " + Width + ", " + Height + ", " + Depth + ", " + HasFreezer;
    }
    @Override
    public String getDBFormat(){
        return getBaseDBString()  + Size + ", " + Width + ", " + Height + ", " + Depth + ", " + HasFreezer;
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
        this.Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        this.Height = height;
    }

    public int getDepth() {
        return Depth;
    }

    public void setDepth(int depth) {
        this.Depth = depth;
    }

    public boolean getHasFreezer() {
        return HasFreezer;
    }

    public void setHasFreezer(boolean hasFreezer) {
        HasFreezer = hasFreezer;
    }
}
