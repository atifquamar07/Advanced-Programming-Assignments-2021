class Single_row_cols extends Rectangular implements Interface_Single_rows_cols {

    @Override
    public int is_row_matrix(int row, int col, float mat[][]) {

        if (row == 1) {
        
            return 1;

        } else {

            return 0;

        }
        
    }

    @Override
    public int is_column_matrix(int row, int col, float mat[][]) {

        if (col == 1) {

            return 1;

        } else {

            return 0;

        }

    }

    
}
