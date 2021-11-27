import java.util.ArrayList;

class Matrix_Storage_RGB {

    private final int[][] mat_red;
    private final int[][] mat_green;
    private final int[][] mat_blue;
    private final int row;
    private final int col;


    static ArrayList<Matrix_Storage_RGB> store_rgb = new ArrayList<>();


    public int[][] getMat_red() {
        return this.mat_red;
    }

    public int[][] getMat_green() {
        return this.mat_green;
    }

    public int[][] getMat_blue() {
        return this.mat_blue;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }


    Matrix_Storage_RGB (int[][] mat_red, int[][] mat_green, int[][] mat_blue, int row, int col) {

        this.mat_red = mat_red;
        this.mat_green = mat_green;
        this.mat_blue = mat_blue;
        this.row = row;
        this.col = col;

    }

    @Override
    public String toString() {
         
        return mat_red + " " + mat_green + " " + mat_blue + " " + row + " " + col;

    } 
    
}
