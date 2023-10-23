package matrixmultiplication.matrixbuilders;

import matrixmultiplication.MatrixBuilder;
import matrixmultiplication.matrix.Coordinate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CooMatrixBuilder implements MatrixBuilder {
    public final String filePath;
    private final List<Coordinate> coordinates = new ArrayList<>();


    public CooMatrixBuilder(String filePath){
        this.filePath = filePath;
        compress();
    }

    public List<Coordinate> getCooMatrix() {
        return coordinates;
    }

    @Override
    public void compress() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        avoidMetadata(reader);
        String line;

        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 3) {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                if (Double.parseDouble(parts[2]) != 0){
                    double value = Double.parseDouble(parts[2]);
                    coordinates.add(new Coordinate(row,col,value));
                }
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void avoidMetadata(BufferedReader reader) {
        String line;

        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line.startsWith("%")) {
                continue;
            }

            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 2) {
                break;
            }
        }
    }
}

