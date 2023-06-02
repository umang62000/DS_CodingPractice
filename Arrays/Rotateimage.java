import java.util.*;
public class Rotateimage {
    public static int[][] rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
        return matrix;
    }
    
    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    
    public static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
   public static void main(String[] args) {
       int[][]arr={{1,2,3},{4,5,6},{7,8,9}};
       int[][]rarr=rotate(arr);
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr.length;j++){
            System.out.print(rarr[i][j]);
        }
        System.out.println();
    }
   } 
}
