package matrixmultiplication.matrix;

import java.util.ArrayList;
import java.util.List;

public class CRS extends SparseMatrix{

    private final List<Double> values;
    private final List<Integer> columns;
    private final List<Integer> rowPtr;


    public CRS(List<Double> values, List<Integer> columns, List<Integer> rowPtr) {
        this.values = values;
        this.columns = columns;
        this.rowPtr = rowPtr;
    }

    public List<Double> values() {
        return values;
    }

    public List<Integer> columns() {
        return columns;
    }

    public List<Integer> rowPtr() {
        return rowPtr;
    }

    @Override
    public List<Integer> size() {
        List<Integer> size = new ArrayList<>();
        int numRows = rowPtr.size() - 1;
        int numCols = 0;

        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i) > numCols) {
                numCols = columns.get(i);
            }
        }
        size.add(numRows);
        size.add(numCols + 1);
        return size;
    }
}