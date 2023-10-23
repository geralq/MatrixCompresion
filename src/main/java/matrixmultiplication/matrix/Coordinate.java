package matrixmultiplication.matrix;

public record Coordinate(int i, int j, double value) {
    @Override
    public int i() {
        return i;
    }

    @Override
    public int j() {
        return j;
    }

    @Override
    public double value() {
        return value;
    }
}
