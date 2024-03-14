package demo.kafka.customobjects;

public class MyData {

    private int i;
    private String s;
    private double d;

    public MyData() {}

    public MyData(int i, String s, double d) {
        this.i = i;
        this.s = s;
        this.d = d;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return String.format("MyData{%d,%s,%f}", i, s, d);
    }
}
