import java.util.ArrayList;
import java.util.List;

public class CRS {
    private final int[][] matrix;
    private List<Integer> values;
    private List<Integer> columns;
    private List<Integer> rowPtr;

    public CRS(int[][] matrix) {
        this.matrix = matrix;
        compress();
    }

    private void compress() {
        List<Integer> valueList = new ArrayList<>();
        List<Integer> columnsList = new ArrayList<>();
        List<Integer> rowPtrList = new ArrayList<>();

        int count = 0;
        for (int[] ints : matrix) {
            rowPtrList.add(count);
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] != 0) {
                    valueList.add(ints[j]);
                    columnsList.add(j);
                    count++;
                }
            }
        }
        rowPtrList.add(count);

        values = valueList;
        columns = columnsList;
        rowPtr = rowPtrList;
    }
    public List<Integer> getValues() {
        return values;
    }

    public List<Integer> getColumns() {
        return columns;
    }

    public List<Integer> getRowPtr() {
        return rowPtr;
    }

}

