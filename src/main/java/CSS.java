import java.util.ArrayList;
import java.util.List;

public class CSS {
    private final int[][] matrix;
    private List<Integer> values;
    private List<Integer> rows;
    private List<Integer> colPtr;

    public CSS(int[][] matrix) {
        this.matrix = matrix;
        compress();
    }

    private void compress(){
        List<Integer> valueList = new ArrayList<>();
        List<Integer> rowsList = new ArrayList<>();
        List<Integer> colPtrList = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < matrix[0].length; i++){
            colPtrList.add(count);
            for (int j = 0; j< matrix.length; j++){
                if (matrix[j][i] != 0){
                    valueList.add(matrix[j][i]);
                    rowsList.add(j);
                    count++;
                }
            }
        }
        colPtrList.add(count);

        values = valueList;
        rows = rowsList;
        colPtr = colPtrList;
    }
    public List<Integer> getValues() {
        return values;
    }

    public List<Integer> getRows() {
        return rows;
    }

    public List<Integer> getColPtr() {
        return colPtr;
    }

}
