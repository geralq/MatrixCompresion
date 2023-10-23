package matrixmultiplication.matrix;

import java.util.List;

public class CRS {

    private final List<Double> values;
    private final List<Integer> columns;
    private final List<Integer> rowPtr;


    public CRS(List<Double> values, List<Integer> columns, List<Integer> rowPtr) {
        this.values = values;
        this.columns = columns;
        this.rowPtr = rowPtr;
    }

    public List<Double> getValues() {
        return values;
    }

    public List<Integer> getColumns() {
        return columns;
    }

    public List<Integer> getRowPtr() {
        return rowPtr;
    }
}
