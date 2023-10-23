package matrixmultiplication.matrixbuilders;

import matrixmultiplication.MatrixBuilder;
import matrixmultiplication.matrix.CCS;
import matrixmultiplication.matrix.Coordinate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompressedColMatrixBuilder implements MatrixBuilder {

    private final List<Coordinate> coordinateMatrix;
    private List<Double> values;
    private List<Integer> rows;
    private List<Integer> colPtr;

    public CompressedColMatrixBuilder(List<Coordinate> coordinateList) {
        this.coordinateMatrix = coordinateList;
        compress();
    }

    public CCS getCSSMatrix(){
        return new CCS(values,rows,colPtr);
    }

    public void compress(){
        Comparator<Coordinate> coordinateComparator = Comparator.comparingInt(Coordinate::j);
        coordinateMatrix.sort(coordinateComparator);

        List<Double> valueList = new ArrayList<>();
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colPtrList = new ArrayList<>();

        int count = 0;
        int j = coordinateMatrix.get(0).j();
        colPtrList.add(count);
        for (Coordinate coordinate : coordinateMatrix){

            rowList.add(coordinate.i());
            if (j != coordinate.j()){
                colPtrList.add(count);
                j++;
            }
            count++;
            valueList.add(coordinate.value());
        }
        colPtrList.add(count);

        values = valueList;
        rows = rowList;
        colPtr = colPtrList;

    }



}

