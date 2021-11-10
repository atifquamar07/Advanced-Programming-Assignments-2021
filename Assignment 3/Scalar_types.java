class Scalar_types extends Square implements Interface_Scalar_types{

    @Override
    public int is_scalar_matrix(int row, int col, float mat[][]){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        Rectangular obj = new Rectangular();

        if (row==1 && col==1){
            return 1;
        }
        
        else if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        int check = is_diagonal_matrix(row, col, compy);

        float x = compy[0][0];

        int ctr = 0;

        if (check==1){

            for (int i = 1; i < row; i++){
    
                if (compy[i][i]==x){
                    ctr = 0;
                } else{
                    ctr = 1;
                }
                    
            }

            if (ctr == 0){
                return 1;
            } else {
                return 0;
            }

        } else {
            return 0;
        }

    }

    @Override
    public int is_identity_matrix(int row, int col, float mat[][]){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        Rectangular obj = new Rectangular();

        if (row==1 && col==1 && compy[0][0]==1){
            return 1;
        }

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        

        int check = is_diagonal_matrix(row, col, compy);

        int x = 1;

        int ctr = 0;

        if (check==1){

            for (int i = 1; i < row; i++){
    
                if (compy[i][i]==x){
                    ctr = 0;
                } else{
                    ctr = 1;
                }
                    
            }

            if (ctr == 0){
                return 1;
            } else {
                return 0;
            }

        } else {
            return 0;
        }

    }

    @Override
    public int is_singleton_matrix(int row, int col, float mat[][]){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        Rectangular obj = new Rectangular();

        if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        if (row==1 && col==1){
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public int is_diagonal_matrix(int row, int col, float mat[][]){

        float[][] compy = new float[row][col];
        Miscellaneous.copy(mat, compy, row, col);

        Rectangular obj = new Rectangular();

        if (row==1 && col==1){
            return 1;
        }

        else if (obj.is_rectangular_matrix(row, col, compy)==1){
            return 0;
        }

        int ans = -1;

        Triangular obj1 = new Triangular();

        if (obj1.is_lower_triangular_matrix(compy, row, col)==1 && obj1.is_upper_triangular_matrix(row, col, compy)==1){
            ans=1;
        }

        if (ans==1){
            return 1;
        } else {
            return 0;
        }

    }
}
