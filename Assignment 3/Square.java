class Square {

    public int is_square_matrix(int row, int col, float mat[][]) {

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){

            return 0;

        }

        int cond = obj.is_rectangular_matrix(row, col, compy);

        if (cond==0) {
            return 1;
        } else {
            return 0;
        }

    }
    
}