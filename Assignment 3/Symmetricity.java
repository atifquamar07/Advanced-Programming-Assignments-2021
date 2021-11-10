import java.util.*;

class Symmetricity extends Square implements Interface_Symmetricity{

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


    static ArrayList<Symmetricity> store = new ArrayList<>();


    public ArrayList<String> getTypes() {

        return this.types;

    }

    public float[][] getMat() {

        return this.mat;

    }

    Symmetricity(float[][] mat, ArrayList<String> types, int row, int col){

        this.mat = mat;
        this.types = types;
        this.row = row;
        this.col = col;

    }

    Symmetricity(){}

    @Override
    public int is_symmetric_matrix(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        if (row==1 && col==1){
            return 1;
        }

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        float temp[][] = Miscellaneous.transpose_matrix(row, col, compy);

        if (Miscellaneous.equal(temp, compy)) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public int is_skew_symmetric_matrix(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        if (row==1 && col==1){
            return 1;
        }

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        float temp[][] = Miscellaneous.transpose_matrix(row, col, compy);

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (compy[i][j]!=0){
                    compy[i][j] = compy[i][j]*(-1);
                }
                
            }

        }

        if (Miscellaneous.equal(temp, compy)) {
            return 1;
        } else{
            return 0;
        }

    }
    
}
