package sample.DataStructure;

public class OutDataFor_DoublePrecisionWindow {
    private byte col_0;
    private int col_1;
    private double col_2;

    public double getCol_0() {
        return col_0;
    }

    public void setCol_0(int col_0) {
        this.col_0 = (byte) col_0;
    }

    public int getCol_1() {
        return (int)col_1;
    }

    public void setCol_1(int col_1) {
        this.col_1 = col_1;
    }

    public double getCol_2() {
        return col_2;
    }

    public void setCol_2(double col_2) {
        this.col_2 = col_2;
    }

    public OutDataFor_DoublePrecisionWindow(double col_0, double col_1, double col_2) {
        this.col_0 = (byte) col_0;
        this.col_1 = (int) col_1;
        this.col_2 = col_2;
    }
}
