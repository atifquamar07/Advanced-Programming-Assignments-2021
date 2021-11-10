import java.util.*;

class Triangular extends Square implements Interface_Triangular {


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

    

    static ArrayList<Triangular> store = new ArrayList<>();



    
    public ArrayList<String> getTypes() {

        return this.types;

    }

    public float[][] getMat() {

        return this.mat;

    }

    Triangular(float[][] mat, ArrayList<String> types, int row, int col){

        this.mat = mat;
        this.types = types;
        this.row = row;
        this.col = col;

    }

    Triangular(){}

    @Override
    public int is_upper_triangular_matrix(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        if (row==1 && col==1){
            return 1;
        }

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        for (int i = 1; i < row; i++){

            for (int j = 0; j < i; j++){

                if (compy[i][j] != 0){
                    return 0;
                }

            }
        }

        return 1;
				
    }

    @Override
    public int is_lower_triangular_matrix(float mat[][], int row, int col){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        if (row==1 && col==1){
            return 1;
        }

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        for (int i = 0; i < row; i++){

            for (int j = i + 1; j < row; j++){

                if (compy[i][j] != 0){
                    return 0;
                } 
                    
            }

        }

        return 1;

    }
    
}
