public class inverseOfMatrix {
    public static void main(String[] args) {
        // Static 2x2 Matrix
        double[][] A = {
                {4, 7},
                {2, 6}
        };

        // Calculate determinant
        double det = (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);

        if (det == 0) {
            System.out.println("Inverse does not exist (determinant is 0)");
            return;
        }

        // Inverse formula for 2x2 matrix
        double[][] inverse = new double[2][2];
        inverse[0][0] = A[1][1] / det;
        inverse[0][1] = -A[0][1] / det;
        inverse[1][0] = -A[1][0] / det;
        inverse[1][1] = A[0][0] / det;

        // Display inverse
        System.out.println("Inverse of matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(inverse[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
