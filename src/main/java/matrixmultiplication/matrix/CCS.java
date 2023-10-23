package matrixmultiplication.matrix;

import java.util.ArrayList;
import java.util.List;

public class CCS extends SparseMatrix{
    private final List<Double> values;
    private final List<Integer> rows;
    private final List<Integer> colPtr;


    public CCS(List<Double> values, List<Integer> rows, List<Integer> colPtr) {
        this.values = values;
        this.rows = rows;
        this.colPtr = colPtr;
    }

    public List<Double> values() {
        return values;
    }

    public List<Integer> rows() {
        return rows;
    }

    public List<Integer> colPtr() {
        return colPtr;
    }

    @Override
    public List<Integer> size() {
        List<Integer> size = new ArrayList<>();
        int numCols = colPtr.size() - 1;
        int numRows = 0;

        for (int j = 0; j < rows.size(); j++) {
            if (rows.get(j) > numRows) {
                numRows = rows.get(j);
            }
        }
        size.add(numRows + 1);
        size.add(numCols);
        return size;
    }
}
