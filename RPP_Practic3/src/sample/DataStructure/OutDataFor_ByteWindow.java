package sample.DataStructure;

public class OutDataFor_ByteWindow {
    private String col_0;
    private String col_1;
    private String col_2;
    private String col_3;
    private String col_4;
    private String col_5;
    private String col_6;
    private String col_7;
    private String col_8;

    public void RightBit(){
        col_8 = col_7;
        col_7 = col_6;
        col_6 = col_5;
        col_5 = col_4;
        col_4 = col_3;
        col_3 = col_2;
        col_2 = col_1;
        col_1 = "0";
    }

    @Override
    public String toString() {
        return
               col_1 + col_2 +  col_3 +  col_4 +  col_5 + col_6 + col_7 + col_8;
    }

    public void LeftBit(){
        col_1 = col_2;
        col_2 = col_3;
        col_3 = col_4;
        col_4 = col_5;
        col_5 = col_6;
        col_6 = col_7;
        col_7 = col_8;
        col_8 = "0";
    }

    public String getCol_0() {
        return col_0;
    }

    public String getCol_1() {
        return col_1;
    }

    public void setCol_1(String col_1) {
        this.col_1 = col_1;
    }

    public String getCol_2() {
        return col_2;
    }

    public void setCol_2(String col_2) {
        this.col_2 = col_2;
    }

    public String getCol_3() {
        return col_3;
    }

    public void setCol_3(String col_3) {
        this.col_3 = col_3;
    }

    public String getCol_4() {
        return col_4;
    }

    public void setCol_4(String col_4) {
        this.col_4 = col_4;
    }

    public String getCol_5() {
        return col_5;
    }

    public void setCol_5(String col_5) {
        this.col_5 = col_5;
    }

    public String getCol_6() {
        return col_6;
    }

    public void setCol_6(String col_6) {
        this.col_6 = col_6;
    }

    public String getCol_7() {
        return col_7;
    }

    public void setCol_7(String col_7) {
        this.col_7 = col_7;
    }

    public String getCol_8() {
        return col_8;
    }

    public void setCol_8(String col_8) {
        this.col_8 = col_8;
    }

    public OutDataFor_ByteWindow(String col_0, String col_1, String col_2, String col_3, String col_4, String col_5, String col_6, String col_7, String col_8) {
        this.col_0 = col_0;
        this.col_1 = col_1;
        this.col_2 = col_2;
        this.col_3 = col_3;
        this.col_4 = col_4;
        this.col_5 = col_5;
        this.col_6 = col_6;
        this.col_7 = col_7;
        this.col_8 = col_8;
    }
}
