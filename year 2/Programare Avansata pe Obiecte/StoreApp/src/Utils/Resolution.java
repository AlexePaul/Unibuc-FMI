package Utils;

public class Resolution {
    private int Width;
    private int Height;

    public Resolution(int height, int width) {
        Width = width;
        Height = height;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }
}
