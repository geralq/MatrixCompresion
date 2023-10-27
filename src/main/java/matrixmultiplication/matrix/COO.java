package matrixmultiplication.matrix;

import matrixmultiplication.Matrix;

import java.util.List;

public record COO(List<Coordinate> coordinates, List<Integer> size) implements Matrix {
}
