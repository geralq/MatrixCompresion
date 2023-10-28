package matrixmultiplication;

import matrixmultiplication.matrix.COO;
import matrixmultiplication.matrix.CRS;
import matrixmultiplication.matrix.CCS;
import matrixmultiplication.matrix.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplication {

    public MatrixMultiplication(){
    }

    public COO matrixMultiplication(CRS a, CCS b) {
        List<Coordinate> coordinateList = new ArrayList<>();
        for (int i = 0; i < a.size().get(1) ; i++) {
            for (int j = 0; j < b.size().get(1); j++) {
                int ii = a.rowPtr().get(i);
                int iEnd = a.rowPtr().get(i+1);
                int jj = b.colPtr().get(j);
                int jEnd = b.colPtr().get(j+1);
                long s = 0;
                while (ii < iEnd && jj < jEnd){
                    int aa = a.columns().get(ii);
                    int bb = b.rows().get(jj);
                    if(aa == bb){
                        s += (long) (a.values().get(ii) * b.values().get(jj));
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
        return new COO(coordinateList, a.size());
    }

}
