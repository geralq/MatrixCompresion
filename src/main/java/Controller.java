import matrixmultiplication.MatrixMultiplication;
import matrixmultiplication.matrix.CCS;
import matrixmultiplication.matrix.COO;
import matrixmultiplication.matrix.CRS;
import matrixmultiplication.matrix.Coordinate;
import matrixmultiplication.matrixbuilders.CompressedColMatrixBuilder;
import matrixmultiplication.matrixbuilders.CompressedRowMatrixBuilder;
import matrixmultiplication.matrixbuilders.CooMatrixBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final String path = "C:\\Users\\gerar\\OneDrive\\Escritorio\\ULPGC\\BD\\1138_bus.mtx";
    private final CooMatrixBuilder cooMatrixBuilder = new CooMatrixBuilder(path);
    private final COO coo = cooMatrixBuilder.getCooMatrix();
    private final CompressedRowMatrixBuilder compressedRowMatrixBuilder = new CompressedRowMatrixBuilder(coo);
    private final CompressedColMatrixBuilder compressedColMatrixBuilder = new CompressedColMatrixBuilder(coo);
    public Controller() {
    }

    public void execute(){

        CRS a = compressedRowMatrixBuilder.getCRSMatrix();
        CCS b = compressedColMatrixBuilder.getCSSMatrix();
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        CLI(matrixMultiplication, a, b);
    }

    private void CLI(MatrixMultiplication matrixMultiplication, CRS a, CCS b) {
        System.out.println("Welcome to the matrix multiplication system.");
        System.out.println("Please write the format of the matrix multiplication result.");
        Scanner read = new Scanner(System.in);
        COO coo = matrixMultiplication.PrepareMultiplication(a, b);
        while (true){

            String format = read.next();

            switch (format) {
                case "CRS" -> {
                    CompressedRowMatrixBuilder compressedRowMatrixBuilder = new CompressedRowMatrixBuilder(coo);
                    CRS crs = compressedRowMatrixBuilder.getCRSMatrix();
                    System.out.println("RowPointer :" + crs.rowPtr());
                    System.out.println("Columns :" + crs.columns());
                    System.out.println("Values :" + crs.values());
                    System.out.println("If you are done with the matrix multiplication system, write 'exit' to finish the system");
                }
                case "CCS" -> {
                    CompressedColMatrixBuilder compressedColMatrixBuilder = new CompressedColMatrixBuilder(coo);
                    CCS ccs = compressedColMatrixBuilder.getCSSMatrix();
                    System.out.println("ColPointer :" + ccs.colPtr());
                    System.out.println("Rows :" + ccs.rows());
                    System.out.println("Values :" + ccs.values());
                    System.out.println("If you are done with the matrix multiplication system, write 'exit' to finish the system");
                }
                case "COO" -> {
                    List<Coordinate> coordinateList = coo.coordinates();
                    List<Integer> row = new ArrayList<>();
                    List<Integer> column = new ArrayList<>();
                    List<Double> value = new ArrayList<>();
                    for (Coordinate coordinate : coordinateList){
                        row.add(coordinate.i());
                        column.add(coordinate.j());
                        value.add(coordinate.value());
                    }
                    System.out.println("Rows :" + row);
                    System.out.println("Cols :" + column);
                    System.out.println("Values :" + value);
                    System.out.println("If you are done with the matrix multiplication system, write 'exit' to finish the system");
                }
                case "exit" -> System.exit(0);
                default -> {
                    System.out.println("Please write an available format for the matrix multiplication.");
                    System.out.println("The available formats are: CRS or CSS.");
                }
            }

        }
    }
}
