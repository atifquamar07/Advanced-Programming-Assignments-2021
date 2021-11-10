import java.util.*;

class Miscellaneous {

    static float determinant(float[][] mat) {

        float[][] compy = new float[mat.length][mat.length];
        Miscellaneous.copy(mat, compy, mat.length, mat.length);

		if (compy.length == 1) {
            float result1 = 0;
			result1 = compy[0][0];
			return result1;
		}

		if (compy.length == 2) {
            float result2 = 999999;
			result2 = (compy[0][0] * compy[1][1]) - (compy[0][1] * compy[1][0]);
			return result2;
		}

        float result = 0;

		for (int i = 0; i < compy[0].length; i++) {

			float temp[][] = new float[compy.length - 1][compy[0].length - 1];

			for (int j = 1 ; j < compy.length; j++) {

				for (int k = 0 ; k < compy[0].length; k++) {

					if (k < i) {
						temp[j-1][k] = compy[j][k];
					} else if (k > i) {
						temp[j-1][k-1] = compy[j][k];
					}

				}

			}

			result += compy[0][i] * Math.pow(-1, (int) i) * determinant(temp);
            
		}

		return result;
	}

    static float[][] transpose_matrix(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        float transpose[][] = new float[row][col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                transpose[i][j] = compy[j][i];

            }

        }

        return transpose;

    }

    static boolean equal(float[][] mat1, float[][] mat2) {

        if (mat1.length != mat2.length) {
            return false;
        }

        for (int i = 0; i < mat1.length; i++) {
            
            if (!Arrays.equals(mat1[i], mat2[i])) {
                return false;
            }
        }

        return true;
    }

    static ArrayList<String> print_matrix_types(float[][] mat, int row, int col){

        ArrayList<String> types = new ArrayList<>();

        float[][] op_mat = new float[row][col];
        Miscellaneous.copy(mat, op_mat, row, col);

        Singular obj1 = new Singular();

        if (obj1.is_singular_matrix(row, col, op_mat)==1) {
            types.add("Singular Matrix");
        }

        Single_row_cols obj2 = new Single_row_cols();

        if (obj2.is_column_matrix(row, col, op_mat)==1){
            types.add("Column Matrix");
        }

        if (obj2.is_row_matrix(row, col, op_mat)==1){
            types.add("Row Matrix");
        }
      

        Scalar_types obj3 = new Scalar_types();

        if (obj3.is_diagonal_matrix(row, col, op_mat)==1){
            types.add("Diagonal Matrix");
        }


        if (obj3.is_identity_matrix(row, col, op_mat)==1){
            types.add("Identity Matrix");
        }

        if (obj3.is_scalar_matrix(row, col, op_mat)==1){
            types.add("Scalar Matrix");
        }

        if (obj3.is_singleton_matrix(row, col, op_mat)==1){
            types.add("Singleton Matrix");
        }

        Triangular obj4 = new Triangular();

        if (obj4.is_lower_triangular_matrix(op_mat, row, col)==1){
            types.add("Lower Triangular Matrix");
        }

        if (obj4.is_upper_triangular_matrix(row, col, op_mat)==1){
            types.add("Upper Triangular Matrix");
        }

        Zero_or_One obj5 = new Zero_or_One();

        if (obj5.is_null_matrix(row, col, op_mat)==1){
            types.add("Null Matrix");
        }


        if (obj5.is_ones_matrix(row, col, op_mat)==1){
            types.add("One's Matrix");
        }

        Rectangular obj6 = new Rectangular();

        if (obj6.is_rectangular_matrix(row, col, op_mat)==1){
            types.add("Rectangular Matrix");
        }

        Symmetricity obj7 = new Symmetricity();

        if (obj7.is_skew_symmetric_matrix(row, col, op_mat)==1){
            types.add("Skew Symmetric Matrix");
        }

        if (obj7.is_symmetric_matrix(row, col, op_mat)==1){
            types.add("Symmetric Matrix");
        }

        Square obj8 = new Square();

        if (obj8.is_square_matrix(row, col, op_mat)==1){
            types.add("Square Matrix");
        }

        return types;

    }

    static void display(float A[][], int row, int col){

        for (int i = 0; i < A.length; i++){

            for (int j = 0; j < A[i].length; j++){

                System.out.print(A[i][j] + " ");

            }

            System.out.println();

        }
        System.out.println();
    }

    static void copy(float mainn[][], float copy[][], int row, int col){

        for (int i = 0; i < row; i++){

            for (int j = 0; j < col; j++){

                copy[i][j] = mainn[i][j];
                    
            }
            
        }
    }
    
    static void display_all_entered_matrices(){

        for (int i = 0 ; i<Matrix_Storage.store.size() ; i++){

            System.out.println("S.no :- " + i);
            System.out.println();
            display(Matrix_Storage.store.get(i).getMat(), Matrix_Storage.store.get(i).getRow(), Matrix_Storage.store.get(i).getCol());

        }
    }


}