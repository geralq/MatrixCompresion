package matrixmultiplication;

import matrixmultiplication.matrix.CRS;
import matrixmultiplication.matrix.CCS;
import matrixmultiplication.matrix.Coordinate;
import matrixmultiplication.matrixbuilders.CompressedColMatrixBuilder;
import matrixmultiplication.matrixbuilders.CompressedRowMatrixBuilder;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplication {

    private final List<Coordinate> coordinateList;

    public MatrixMultiplication(CRS a, CCS b){
        this.coordinateList = PrepareMultiplication(a, b);

    }

    private List<Coordinate> PrepareMultiplication(CRS a, CCS b) {
        List<Coordinate> coordinateList = new ArrayList<>();
        for (int i = 0; i < a.getRowPtr().size() -1 ; i++) {
            for (int j = 0; j < b.getColPtr().size() -1; j++) {
                int ii = a.getRowPtr().get(i);
                int iEnd = a.getRowPtr().get(i+1);
                int jj = b.getColPtr().get(j);
                int jEnd = b.getColPtr().get(j+1);
                long s = 0;
                while (ii < iEnd && jj < jEnd){
                    int aa = a.getColumns().get(ii);
                    int bb = b.getRows().get(jj);
                    if(aa == bb){
                        s += (long) (a.getValues().get(ii) * b.getValues().get(jj));
                        ii++;
                        jj++;
                    } else if (aa < bb) {
                        ii++;
                    }
                    else jj++;
                }
                if (s !=0) coordinateList.add(new Coordinate(i,j,s));
            }
        }
        return coordinateList;
    }

    public CRS CRSMultiplication(){
        CompressedRowMatrixBuilder compressedRowMatrixBuilder = new CompressedRowMatrixBuilder(coordinateList);
        return compressedRowMatrixBuilder.getCRSMatrix();
    }
    
    public CCS CSSMultiplication(){
        CompressedColMatrixBuilder compressedColMatrixBuilder = new CompressedColMatrixBuilder(coordinateList);
        return compressedColMatrixBuilder.getCSSMatrix();
    }

}
