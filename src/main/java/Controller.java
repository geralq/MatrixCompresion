import matrixmultiplication.MatrixMultiplication;
import matrixmultiplication.matrix.CCS;
import matrixmultiplication.matrix.COO;
import matrixmultiplication.matrix.CRS;
import matrixmultiplication.matrix.Coordinate;
import matrixmultiplication.matrixbuilders.CompressedColMatrixBuilder;
import matrixmultiplication.matrixbuilders.CompressedRowMatrixBuilder;
import matrixmultiplication.matrixbuilders.CooMatrixBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final String path = "C:\\Users\\gerar\\OneDrive\\Escritorio\\ULPGC\\BD\\mycielskian3.mtx";
    private final CooMatrixBuilder cooMatrixBuilder = new CooMatrixBuilder(path);
    private final List<Coordinate> coordinateMatrix = cooMatrixBuilder.getCooMatrix();
    private final CompressedRowMatrixBuilder compressedRowMatrixBuilder = new CompressedRowMatrixBuilder(coordinateMatrix);
    private final CompressedColMatrixBuilder compressedColMatrixBuilder = new CompressedColMatrixBuilder(coordinateMatrix);
    public Controller() throws IOException {
    }

    public void execute(){

        CRS a = compressedRowMatrixBuilder.getCRSMatrix();
        CCS b = compressedColMatrixBuilder.getCSSMatrix();
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        System.out.println("Welcome to the matrix multiplication system.");
        System.out.println("Please write the format of the matrix multiplication result.");
        Scanner read = new Scanner(System.in);
        while (true){

            String format = read.next();

            switch (format) {
                case "CRS" -> {
                    COO coo = matrixMultiplication.PrepareMultiplication(a,b);
                    CompressedRowMatrixBuilder compressedRowMatrixBuilder = new CompressedRowMatrixBuilder(coo.coordinates);
                    CRS crs = compressedRowMatrixBuilder.getCRSMatrix();
                    System.out.println("RowPointer: " + crs.rowPtr());
                    System.out.println("Columns :" + crs.columns());
                    System.out.println("Values :" + crs.values());
                    System.out.println("If you are done with the matrix multiplication system, write 'exit' to finish the system");
                }
                case "CCS" -> {
                    COO coo = matrixMultiplication.PrepareMultiplication(a,b);
                    CompressedColMatrixBuilder compressedColMatrixBuilder = new CompressedColMatrixBuilder(coo.coordinates);
                    CCS ccs = compressedColMatrixBuilder.getCSSMatrix();
                    System.out.println("ColPointer: " + ccs.colPtr());
                    System.out.println("Rows :" + ccs.rows());
                    System.out.println("Values :" + ccs.values());
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
