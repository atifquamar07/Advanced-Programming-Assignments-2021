import java.util.ArrayList;

class Matrix_operations {

    static float[][] addition(int row1, int col1, float mat1[][], int row2, int col2, float mat2[][]) {

        float[][] compy1 = new float[row1][col1];
        Miscellaneous.copy(mat1, compy1, row1, col1);

        float[][] compy2 = new float[row2][row2];
        Miscellaneous.copy(mat2, compy2, row2, col2);

        if (row1 != row2 || col1 != col2) {

            System.out.println();
            System.out.println("Addition of matrices can only be performed of those matrices whose dimensions are same.");
            System.out.println();
            return null;

        } else {

            float result[][] = new float[row1][row1];

            for (int i = 0; i < row1; i++) {

                for (int j = 0; j < row1; j++) {

                    result[i][j] = compy1[i][j] + compy2[i][j];

                }
            }

            return result;

        }

    }

    static float[][] subtraction(int row1, int col1, float mat1[][], int row2, int col2, float mat2[][]) {

        float[][] compy1 = new float[row1][col1];
        Miscellaneous.copy(mat1, compy1, row1, col1);

        float[][] compy2 = new float[row2][row2];
        Miscellaneous.copy(mat2, compy2, row2, col2);

        if (row1 != row2 || col1 != col2) {

            System.out.println();
            System.out.println(
                    "Subtraction of matrices can only be performed of those matrices whose dimensions are same.");
            System.out.println();
            return null;

        } else {

            float result[][] = new float[row1][row1];

            for (int i = 0; i < row1; i++) {

                for (int j = 0; j < row1; j++) {

                    result[i][j] = compy1[i][j] - compy2[i][j];

                }
            }

            return result;

        }

    }

    static float[][] multiplication(int row1, int col1, float mat1[][], int row2, int col2, float mat2[][]) {

        float[][] compy1 = new float[row1][col1];
        Miscellaneous.copy(mat1, compy1, row1, col1);

        float[][] compy2 = new float[row2][row2];
        Miscellaneous.copy(mat2, compy2, row2, col2);

        float result[][] = new float[row1][col2];

        for (int i = 0; i < row1; i++) {

            for (int j = 0; j < col2; j++) {

                for (int k = 0; k < row2; k++) {

                    result[i][j] += compy1[i][k] * compy2[k][j];

                }

            }
        }

        return result;

    }

    static float[][] element_wise_multiplication(int row1, int col1, float mat1[][], int row2, int col2, float mat2[][]) {

        float[][] compy1 = new float[row1][col1];
        Miscellaneous.copy(mat1, compy1, row1, col1);

        float[][] compy2 = new float[row2][row2];
        Miscellaneous.copy(mat2, compy2, row2, col2);

        if (row1 != row2 || col1 != col2) {

            System.out.println();
            System.out.println(
                    "Element-wise multiplication of matrices can only be performed of those matrices whose dimensions are same.");
            System.out.println();
            return null;

        } else {

            float result[][] = new float[row1][row1];

            for (int i = 0; i < row1; i++) {

                for (int j = 0; j < row1; j++) {

                    result[i][j] = compy1[i][j] * compy2[i][j];

                }
            }

            return result;

        }

    }

    static float[][] element_wise_division(int row1, int col1, float mat1[][], int row2, int col2, float mat2[][]) {

        float[][] compy1 = new float[row1][col1];
        Miscellaneous.copy(mat1, compy1, row1, col1);

        float[][] compy2 = new float[row2][row2];
        Miscellaneous.copy(mat2, compy2, row2, col2);

        if (row1 != row2 || col1 != col2) {

            System.out.println();
            System.out
                    .println("Addition of matrices can only be performed of those matrices whose dimensions are same.");
            System.out.println();
            return null;

        } else {

            float result[][] = new float[row1][row1];

            for (int i = 0; i < row1; i++) {

                for (int j = 0; j < row1; j++) {

                    result[i][j] = compy1[i][j] / compy2[i][j];

                }
            }

            return result;

        }

    }

    static float[][] row_wise_mean(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        float mean[][] = new float[row][1]; 

        for (int i = 0; i < row; i++) {

            float temp = 0;

            for (int j = 0; j < col; j++) {

                temp += compy[i][j];

            }

            temp = temp / col;
            mean[i][0] = temp;

        }

        return mean;

    }

    static float[][] col_wise_mean(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        float mean[][] = new float[1][col];

        for (int i = 0; i < col; i++) {

            float temp = 0;

            for (int j = 0; j < row; j++) {

                temp += compy[j][i];

            }

            temp = temp / col;
            mean[0][i] = temp;

        }

        return mean;

    }

    static float mean_all_elements(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        float temp = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                temp += compy[i][j];

            }

        }

        temp = temp / (row * col);

        return temp;

    }

    static float use_singleton_as_scalar(int row, int col, float mat[][]) {

        Scalar_types obj = new Scalar_types();

        if (obj.is_singleton_matrix(row, col, mat)==1) {

            float ans = mat[0][0];
            return ans;

        } else {

            System.out.println();
            System.out.println("Given matrix is not singleton, hence connot convert it into scalar.");
            System.out.println();
            return 0;

        }

    }

    static float[][] compute_transpose_addition(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        float transpose_mat[][] = Miscellaneous.transpose_matrix(row, col, compy);

        float ans[][] = addition(row, col, compy, row, col, transpose_mat);

        return ans;

    }

    static void getCofactor(float mat[][], float temp[][], int p, int q, int n){

        float[][] compy = new float[n][n];
        Miscellaneous.copy(mat, compy, n, n);

        int i = 0;
        int j = 0;

        for (int m = 0; m < n; m++){

            for (int b = 0; b < n; b++){
    
                if (m != p && b != q){

                    temp[i][j++] = compy[m][b];

                    if (j == n - 1){

                        j = 0;
                        i++;

                    }
                }
            }
        }
    }
    
    static float[][] adjoint(float mat[][], int row, int col){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        float[][] adj_matrix = new float[row][row];

        if (row == 1){

            adj_matrix[0][0] = 1;
            return adj_matrix;

        }

        int var = 1;

        float temp[][] = new float[row][col];
    
        for (int i = 0; i < row; i++){

            for (int j = 0; j < col; j++){

                getCofactor(compy, temp, i, j, row);

                var = ((i + j) % 2 == 0)? 1: -1;

                adj_matrix[j][i] = var*(Miscellaneous.determinant(temp));
            }
        }

        return adj_matrix;

    }

    static float[][] solve_linear_equations (float mat[][], float [][] b, int row, int col){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        float inv[][] = invert(compy);

        float ans[][] = multiplication(row, col, inv, row, 1, b);

        return ans;

    }

    static float[][] invert(float a[][]) {

        float[][] compy = new float[a.length][a.length];
        Miscellaneous.copy(a, compy, a.length, a.length);

        int n = compy.length;
        float x[][] = new float[n][n];
        float b[][] = new float[n][n];
        int idx[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        gaussian(compy, idx);

        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[idx[j]][k] -= compy[idx[j]][i] * b[idx[i]][k];

        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[idx[n - 1]][i] / compy[idx[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[idx[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= compy[idx[j]][k] * x[k][i];
                }
                x[j][i] /= compy[idx[j]][j];
            }
        }
        return x;
    }

    static void gaussian(float a[][], int idx[]) {
        int n = idx.length;
        float c[] = new float[n];

        for (int i = 0; i < n; ++i)
            idx[i] = i;

        for (int i = 0; i < n; ++i) {
            float c1 = 0;
            for (int j = 0; j < n; ++j) {
                float c0 = Math.abs(a[i][j]);
                if (c0 > c1)
                    c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            float pi1 = 0;
            for (int i = j; i < n; ++i) {
                float pi0 = Math.abs(a[idx[i]][j]);
                pi0 /= c[idx[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = idx[j];
            idx[j] = idx[k];
            idx[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                float pj = a[idx[i]][j] / a[idx[j]][j];
                a[idx[i]][j] = pj;
                for (int l = j + 1; l < n; ++l)
                    a[idx[i]][l] -= pj * a[idx[j]][l];
            }
        }
    }

    static ArrayList<Float> roots(float a, float b, float c){

        ArrayList<Float> res = new ArrayList<>();

        float root1, root2;

        float discriminant = b * b - 4 * a * c;
    
        if (discriminant > 0) {
    
            root1 = (float) ((-b + Math.sqrt(discriminant)) / (2 * a));
            root2 = (float) ((-b - Math.sqrt(discriminant)) / (2 * a));

            res.add(root1);
            res.add(root2);

        }
    
        else if (discriminant == 0) {

            root1 = -b / (2 * a);
            res.add(root1);
          
        }

        return res;

    }

    static ArrayList<Float> eigenvalues (float[][] mat) {

        float[][] compy = new float[mat.length][mat[0].length];
        Miscellaneous.copy(mat, compy, mat.length, mat[0].length);

        float a = 1;
        float b = -(compy[0][0] + compy[1][1]);
        float c = ((compy[0][0] * compy[1][1]) - (compy[0][1] * compy[1][0]));

        ArrayList<Float> eigen_vals = roots(a, b, c);

        return eigen_vals;

    }

    static ArrayList<float[][]> eigenvectors (float[][] mat) {

        float[][] compy = new float[mat.length][mat[0].length];
        Miscellaneous.copy(mat, compy, mat.length, mat[0].length);

        ArrayList<Float> eigen_vals = eigenvalues(compy);

        ArrayList<float[][]> x = new ArrayList<>();

        if (eigen_vals.size()==1){

            float[][] identity = {{1,0},{0,1}};

            float[][] ll =  scalar_multiplication(2, 2, identity, eigen_vals.get(0));

            float[][] ans = subtraction(2, 2, compy, 2, 2, ll);

            float[][] v1 = new float[2][1];

            v1[0][0] = ans[0][0];
            v1[1][0] = ans[1][0];

            x.add(v1);

            return x;

        } else if (eigen_vals.size()==2){

            float[][] identity = {{1,0},{0,1}};

            float[][] ll =  scalar_multiplication(2, 2, identity, eigen_vals.get(0));

            float[][] ans1 = subtraction(2, 2, compy, 2, 2, ll);

            float[][] v1 = new float[2][1];

            v1[0][0] = ans1[0][0];
            v1[1][0] = ans1[1][0];

            float[][] gg =  scalar_multiplication(2, 2, identity, eigen_vals.get(1));

            float[][] ans2 = subtraction(2, 2, compy, 2, 2, gg);

            float[][] v2 = new float[2][1];

            v2[0][0] = ans2[0][0];
            v2[1][0] = ans2[1][0];

            // float[][] v3 = new float[2][1];

            // v1[0][0] = ans2[0][1];
            // v1[1][0] = ans2[1][1];

            x.add(v1);
            x.add(v2);

            return x;

        }

        return x;

    }

    static float[][] scalar_multiplication(int row, int col, float mat[][], float scalar){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        for (int i = 0 ; i<row ; i++){

            for (int j = 0 ; j<col ; j++){

                compy[i][j] = compy[i][j]*scalar;

            }

        }

        return compy;

    }

    
}
