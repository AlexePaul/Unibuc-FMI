package Utils;

public class Pair <Type1, Type2>{
    private Type1 a;
    private Type2 b;

    public Pair(Type1 a, Type2 b) {
        this.a = a;
        this.b = b;
    }

    public Type1 First(){
        return a;
    }
    public Type2 Second(){
        return b;
    }

    public void SetFirst(Type1 a) {
        this.a = a;
    }

    public void SetSecond(Type2 b) {
        this.b = b;
    }
}
