import java.util.Scanner;

class Matrix {
    int rows, cols;
    int[][] data;

    Matrix(int r, int c) {
        rows = r;
        cols = c;
        data = new int[rows][cols];
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = sc.nextInt();
            }
        }
    }

    void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    Matrix transpose() {
        Matrix t = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t.data[j][i] = data[i][j];
            }
        }
        return t;
    }

    Matrix multiply(Matrix m) {
        if (this.cols != m.rows) {
            System.out.println("Matrix multiplication not possible!");
            return null;
        }

        Matrix result = new Matrix(this.rows, m.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result.data[i][j] = 0;
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }

        return result;
    }
}

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First matrix
        System.out.print("Enter rows and columns of Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        Matrix A = new Matrix(r1, c1);
        A.input();

        // Second matrix
        System.out.print("Enter rows and columns of Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        Matrix B = new Matrix(r2, c2);
        B.input();

        // Display matrices
        System.out.println("\nMatrix A:");
        A.display();

        System.out.println("\nMatrix B:");
        B.display();

        // Transpose
        System.out.println("\nTranspose of Matrix A:");
        Matrix tA = A.transpose();
        tA.display();

        // Multiplication
        System.out.println("\nMultiplication (A x B):");
        Matrix result = A.multiply(B);
        if (result != null) {
            result.display();
        }
    }
}