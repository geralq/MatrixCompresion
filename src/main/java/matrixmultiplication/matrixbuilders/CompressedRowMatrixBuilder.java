package matrixmultiplication.matrixbuilders;

import matrixmultiplication.MatrixBuilder;
import matrixmultiplication.matrix.COO;
import matrixmultiplication.matrix.CRS;
import matrixmultiplication.matrix.Coordinate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompressedRowMatrixBuilder implements MatrixBuilder {
    private final COO coo;
    private List<Double> values;
    private List<Integer> columns;
    private List<Integer> rowPtr;

    public CompressedRowMatrixBuilder(COO coo) {
        this.coo = coo;
        compress();
    }

    public CRS getCRSMatrix(){
        return new CRS(values,columns,rowPtr, coo.size());
    }

    @Override
    public void compress() {
        List<Coordinate> coordinateList = coo.coordinates();
        Comparator<Coordinate> coordinateComparator = Comparator.comparingInt(Coordinate::i);
        coordinateList.sort(coordinateComparator);

        List<Double> valueList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();
        List<Integer> rowPtrList = new ArrayList<>();

        int count = 0;
        int i = coordinateList.get(0).i();
        rowPtrList.add(count);
        for (Coordinate coordinate : coordinateList){
            columnList.add(coordinate.j());
            if (i != coordinate.i()){
                rowPtrList.add(count);
                i++;
            }
            count++;
            valueList.add(coordinate.value());
        }
        rowPtrList.add(count);

        values = valueList;
        columns = columnList;
        rowPtr = rowPtrList;
    }

}
