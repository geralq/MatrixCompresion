package matrixmultiplication.matrix;

import matrixmultiplication.Matrix;

import java.util.List;

public record CCS(List<Double> values, List<Integer> rows, List<Integer> colPtr, List<Integer> size) implements Matrix {
}
