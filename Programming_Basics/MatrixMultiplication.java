/*
    Title : Performing multiplication operation on two matrices.
 */
//-----------------------------------------------------------------------------------------

class MatrixMultiplication{
    
    /* SPACE COMPLEXITY = O(n^2) */
    /*
    static void multiplyMatrices(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int columns = matrix2[0].length;

        if(rows != columns){
            System.out.println("The two matrices are incompatible for multiplication !");
            return;
        }
        
        int[][] result = new int[rows][columns];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                    result[i][j] = 0;
                for(int k=0; k<columns; k++){
                    result[i][j] += (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                    System.out.printf("%5d", result[i][j]);
            }
            System.out.println();
        }
    }
    */
//----------------------------------------------------------------------------------------------

    /* SPACE COMPLEXITY = O(1)  */
    static void multiplyMatrices(int[][] matrix1, int[][] matrix2){
        int rows = matrix1.length;
        int columns = matrix2[0].length;

        if(rows != columns){
            System.out.println("The two matrices are incompatible for multiplication !");
            return;
        }
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                    int temp = 0;
                for(int k=0; k<columns; k++){
                    temp += (matrix1[i][k] * matrix2[k][j]);
                }
                System.out.printf("%5d", temp);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] matrix1 = {
                            {1,2,3},
                            {4,5,6},
                            {7,8,9}
                        };

        int[][] matrix2 = {
                            {1,2,3},
                            {4,5,6},
                            {7,8,9}
                        };

        multiplyMatrices(matrix1, matrix2);
    }
}