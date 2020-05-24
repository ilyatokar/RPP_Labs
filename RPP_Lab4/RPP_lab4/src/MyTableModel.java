
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends AbstractTableModel {


    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return null;
    }

    public boolean isCellEditable(int row, int column){
        if(row == 0 && column == 0)
            return false;
        return true;
    }



}
