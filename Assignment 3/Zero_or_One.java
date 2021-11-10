import java.util.*;

class Zero_or_One extends Square implements Interface_Zero_or_One{


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



    static ArrayList<Zero_or_One> store = new ArrayList<>();


    Zero_or_One(){}


    public ArrayList<String> getTypes() {

        return this.types;

    }

    public float[][] getMat() {

        return this.mat;

    }

    Zero_or_One(float[][] mat, ArrayList<String> types, int row, int col){

        this.mat = mat;
        this.types = types;
        this.row = row;
        this.col = col;

    }

    @Override
    public int is_ones_matrix(int row, int col, float mat[][]){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        if (row==1 && col==1 && compy[0][0]==1){
            return 1;
        }

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        if (row==0 && col==0){
            return 1;
        }

        float[][] two_d = {{1, 1}, {1, 1}};
 
        float[][] three_d = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        if (row==2){

            if (Miscellaneous.equal(compy, two_d)){
                return 1;
            } else { 
                return 0;
            }
        }

        else if (row==3){

            if (Miscellaneous.equal(compy, three_d)){
                return 1;
            } else { 
                return 0;
            }
        }

        return 0;

    }

    @Override
    public int is_null_matrix(int row, int col, float mat[][]){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        if (row==1 && col==1 && compy[0][0]==0){
            return 1;
        }

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        if (row==0 && col==0){
            return 1;
        }

        float[][] two_d = {{0, 0}, {0, 0}};
 
        float[][] three_d = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        if (row==2){

            if (Miscellaneous.equal(compy, two_d)){
                return 1;
            } else { 
                return 0;
            }
        }

        else if (row==3){

            if (Miscellaneous.equal(compy, three_d)){
                return 1;
            } else { 
                return 0;
            }
        }
        
        return 0;

    }
    
}
