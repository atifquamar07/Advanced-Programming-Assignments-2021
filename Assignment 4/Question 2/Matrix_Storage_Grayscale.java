import java.util.*;

class Matrix_Storage_Grayscale {

    private final int[][] mat;
    private final int row;
    private final int col;


    static ArrayList<Matrix_Storage_Grayscale> store_grayscale = new ArrayList<>();


    public int[][] getMat() {
        return this.mat;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }


    Matrix_Storage_Grayscale (int[][] mat, int row, int col) {

        this.mat = mat;
        this.row = row;
        this.col = col;

    }

    @Override
    public String toString() {
         
        return mat + " " + row + " " + col;
          
    }
    
}
