package sample.DataStructure;

public class DigitInput {
    private double inputCol;

    public DigitInput(float inputCol) {
        this.inputCol = inputCol;
    }

    public int getInputCol_Int(){
        return (int)inputCol;
    }

    public String getInputColString_Float() {
        return Float.toString((float) inputCol);
    }

    public String getInputColString_Int(){
        return Integer.toString((int)inputCol);
    }

    public void setInputCol(float inputCol) {
        this.inputCol = inputCol;
    }

    public void setInputCol(String inputCol) {
        this.inputCol = Float.parseFloat(inputCol);
    }
}
