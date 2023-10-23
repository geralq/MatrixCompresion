public class test {
    public static void main(String[] args) {
        double[] data = {1,6,2,7,3,5,4};
        int[] rows = {0,0,1,1,2,3,3};
        int[] columns = {0,2,1,3,2,0,3};

        int numRows = 0;
        int numCols = 0;

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] > numRows) {
                numRows = rows[i];
            }
            if (columns[i] > numCols) {
                numCols = columns[i];
            }
        }

        // Sumar 1 a los valores para obtener el número real de filas y columnas
        numRows += 1;
        numCols += 1;

        System.out.println("Número de filas: " + numRows);
        System.out.println("Número de columnas: " + numCols);
    }
}
