package matrixmultiplication.matrix;

import matrixmultiplication.Matrix;
import java.util.List;

public record CRS(List<Double> values, List<Integer> columns, List<Integer> rowPtr,
                  List<Integer> size) implements Matrix {

}