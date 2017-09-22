
import java.util.*;

public class Complex {
    private int x, y;

    public Complex() {
        x = 0;
        y = 0;
    }

    public Complex(int x) {
        this.x = x;
        y = 0;
    }

    public Complex(int u, int v) {
        x = u;
        v = y;
    }

    public void setValues(int u, int v) {
        x = u;
        y = v;
    }

    public int re() {
        return x;
    }

    public int im() {
        return y;
    }

}