public class inverseOfMatrix {
    public static void main(String[] args) {
        int [][] A =  {{1,2},
                       {3,4}};


        int det = A[0][0] * A[1][1] - A[0][1] * A[1][0];
        System.out.println("Determinant of matrix A = " );
    }
}
