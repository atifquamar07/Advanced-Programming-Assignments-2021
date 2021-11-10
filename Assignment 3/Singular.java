class Singular extends Square implements Interface_Singular {

    @Override
    public int is_singular_matrix(int row, int col, float mat[][]){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        if (row==1 && col==1 && compy[0][0]==0){
            return 1;
        }

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        float det = Miscellaneous.determinant(compy);

        if (det==0){
            return 1;
        } else{
            return 0;
        }

    }
    
}
