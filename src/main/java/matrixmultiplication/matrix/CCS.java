package matrixmultiplication.matrix;

import java.util.List;

public class CCS {
    private final List<Double> values;
    private final List<Integer> rows;
    private final List<Integer> colPtr;


    public CCS(List<Double> values, List<Integer> rows, List<Integer> colPtr) {
        this.values = values;
        this.rows = rows;
        this.colPtr = colPtr;
    }

    public List<Double> getValues() {
        return values;
    }

    public List<Integer> getRows() {
        return rows;
    }

    public List<Integer> getColPtr() {
        return colPtr;
    }
}
