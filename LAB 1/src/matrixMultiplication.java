public class matrixMultiplication {
    public static void main(String[] args) {
        int [][] A = {{1,2},
                {3,4}};

        int [][] B = {{1,2},
                {3,4}};

        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;

        if(colA != rowB){
            System.out.println("PLEASE ENTER 2 VALID MATRIX FOR MULTIPLICATION");
            return;
        }

        int [][] result = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {

            for (int j = 0; j < colB; j++) {

                for (int k = 0; k < colA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for (int i=0; i< rowA ; i++){
            for (int j = 0; j< colB; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
