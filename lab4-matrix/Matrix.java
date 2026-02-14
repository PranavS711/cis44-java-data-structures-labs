import java.util.Random;

public class Matrix {
    private int[][] data;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and cols must be positive.");
        }
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        if (data == null || data.length == 0 || data[0] == null || data[0].length == 0) {
            throw new IllegalArgumentException("Data array cannot be empty.");
        }

        int cols = data[0].length;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null || data[i].length != cols) {
                throw new IllegalArgumentException("All rows must have the same number of columns.");
            }
        }

        // copy so outside changes don’t mess up this matrix
        this.data = new int[data.length][cols];
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < cols; c++) {
                this.data[r][c] = data[r][c];
            }
        }
    }

    public void populateRandom() {
        Random rand = new Random();
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                data[r][c] = rand.nextInt(10) + 1; // 1 to 10
            }
        }
    }

    public Matrix add(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Other matrix cannot be null.");
        }
        if (this.rows() != other.rows() || this.cols() != other.cols()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions to add.");
        }

        Matrix result = new Matrix(rows(), cols());
        for (int r = 0; r < rows(); r++) {
            for (int c = 0; c < cols(); c++) {
                result.data[r][c] = this.data[r][c] + other.data[r][c];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Other matrix cannot be null.");
        }
        if (this.cols() != other.rows()) {
            throw new IllegalArgumentException(
                    "Invalid dimensions for multiply: cols of A must equal rows of B."
            );
        }

        Matrix result = new Matrix(this.rows(), other.cols());

        for (int r = 0; r < result.rows(); r++) {
            for (int c = 0; c < result.cols(); c++) {
                int sum = 0;
                for (int k = 0; k < this.cols(); k++) {
                    sum += this.data[r][k] * other.data[k][c];
                }
                result.data[r][c] = sum;
            }
        }

        return result;
    }

    public int rows() {
        return data.length;
    }

    public int cols() {
        return data[0].length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < data.length; r++) {
            sb.append("[ ");
            for (int c = 0; c < data[0].length; c++) {
                sb.append(String.format("%3d", data[r][c]));
                if (c < data[0].length - 1) sb.append(" ");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }
}
