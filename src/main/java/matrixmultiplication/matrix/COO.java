package matrixmultiplication.matrix;

import java.util.ArrayList;
import java.util.List;

public class COO extends SparseMatrix{
    private final List<Coordinate> coordinates;

    public COO(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates(){
        return coordinates;
    }

    @Override
    public List<Integer> size() {
        List<Integer> size = new ArrayList<>();
        int numRows = 0;
        int numCols = 0;
        for (Coordinate coordinate : coordinates) {
            if (coordinate.i() > numRows) {
                numRows = coordinate.i();
            }
            if (coordinate.j() > numCols) {
                numCols = coordinate.j();
            }
        }

        size.add(numRows + 1);
        size.add(numCols + 1);
        return size;
    }
}
