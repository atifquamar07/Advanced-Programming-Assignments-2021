import java.util.*;

class Matrix_Storage {

    private float[][] mat;
    private int row;
    private int col;
    private ArrayList<String> types;


    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    //main storage list
    /*******************************************************************/

    static ArrayList<Matrix_Storage> store = new ArrayList<>();

    /*******************************************************************/

    public ArrayList<String> getTypes() {

        return this.types;

    }

    public float[][] getMat() {

        return this.mat;

    }

    Matrix_Storage(float[][] mat, ArrayList<String> types, int row, int col){

        this.mat = mat;
        this.types = types;
        this.row = row;
        this.col = col;

    }

    static float[][] diagonal_mat = new float[100][3];
    static float[][] identity_mat = new float[100][1];
    static float[][] scalar_mat = new float[100][1];
    static float[][] singleton_mat = new float[100][1];

    static void efficient_storage(float[][] mat, int row, int col){

        int con=-1;
        Scalar_types obj = new Scalar_types();

        if (obj.is_diagonal_matrix(row, col, mat)==1 || obj.is_identity_matrix(row, col, mat)==1 || obj.is_scalar_matrix(row, col, mat)==1 || obj.is_singleton_matrix(row, col, mat)==1){
            con=1;
        }

        if (con==1){

            int diag_ctr = 0;
            int identity_ctr = 0;
            int scalar_ctr = 0;
            int singleton_ctr = 0;


            if (obj.is_diagonal_matrix(row, col, mat)==1){

                float[] matt = new float[row];

                for (int i = 0 ; i<row ; i++){
                    matt[i] = mat[i][i];
                }

                diagonal_mat[diag_ctr++] = matt;
                
            } else if (obj.is_identity_matrix(row, col, mat)==1){

                float[] matt = new float[row];
                float x = mat[0][0];
                matt[0] = x;
                identity_mat[identity_ctr++] = matt;

            } else if (obj.is_scalar_matrix(row, col, mat)==1){

                float[] matt = new float[row];
                float x = mat[0][0];
                matt[0] = x;
                scalar_mat[scalar_ctr++] = matt;

            } else if (obj.is_singleton_matrix(row, col, mat)==1){

                float[] matt = new float[row];
                float x = mat[0][0];
                matt[0] = x;
                singleton_mat[singleton_ctr++] = matt;

            }
    
        }

    }

}
