package day3;
import java.util.Scanner;

public class MatrixToolkit {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter rows and columns (2-10): ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matA = readMatrix(r, c, "A");
        int[][] matB = readMatrix(r, c, "B");

        while (true) {
            System.out.println("\n1)Add \n2)Subtract \n3)Multiply \n4)Transpose \n5)Sums \n6)Exit");
            int choice = sc.nextInt();
            if (choice == 6) break;

            switch (choice) {
                case 1: printMatrix(add(matA, matB)); break;
                case 2: printMatrix(subtract(matA, matB)); break;
                case 3: 
                    if (r != c) System.out.println("Error: Rows must equal Columns for square multiplication.");
                    else printMatrix(multiply(matA, matB)); 
                    break;
                case 4: printMatrix(transpose(matA)); break;
                case 5: rowColSums(matA); break;
            }
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }

    public static int[][] add(int[][] A, int[][] B) {
        int[][] res = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                res[i][j] = A[i][j] + B[i][j];
            }
        }
        return res;
    }

    public static int[][] subtract(int[][] A, int[][] B) {
        int[][] res = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                res[i][j] = A[i][j] - B[i][j];
            }
        }
        return res;
    }

    public static int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[0].length; j++){
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

    public static void rowColSums(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int rSum = 0;
            for (int j = 0; j < A[0].length; j++) {
                rSum += A[i][j];
            }
            System.out.println("Row " + i + " sum: " + rSum);
        }
    }

    public static int[][] readMatrix(int r, int c, String name) {
        System.out.println("Enter Matrix " + name + ":");
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }

    public static void printMatrix(int[][] m) {
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}