class Matrix_functions {

    static void display_mat(int A[][], int row, int col){

        for (int i = 0; i < A.length; i++){

            for (int j = 0; j < A[i].length; j++){

                System.out.print(A[i][j] + " ");

            }

            System.out.println();

        }
        System.out.println();
    }

    static void display_grayscale() {

        System.out.println("The grayscale matrices entered are: ");
        System.out.println();

        for (int i = 0 ; i<Matrix_Storage_Grayscale.store_grayscale.size() ; i++){

            System.out.println("S.no: " + i);
            System.out.println();

            display_mat(Matrix_Storage_Grayscale.store_grayscale.get(i).getMat(), Matrix_Storage_Grayscale.store_grayscale.get(i).getRow(), Matrix_Storage_Grayscale.store_grayscale.get(i).getCol());

        }

    }

    static void display_RGB() {

        System.out.println("The RGB matrices entered are: ");
        System.out.println();

        for (int j = 0 ; j<Matrix_Storage_RGB.store_rgb.size() ; j++){

            System.out.println("S.no: " + j);
            System.out.println();

            System.out.println("RED colour matrix: ");
            display_mat(Matrix_Storage_RGB.store_rgb.get(j).getMat_red(), Matrix_Storage_RGB.store_rgb.get(j).getRow(), Matrix_Storage_RGB.store_rgb.get(j).getCol());

            System.out.println("GREEN colour matrix: ");
            display_mat(Matrix_Storage_RGB.store_rgb.get(j).getMat_green(), Matrix_Storage_RGB.store_rgb.get(j).getRow(), Matrix_Storage_RGB.store_rgb.get(j).getCol());

            System.out.println("BLUE colour matrix: ");
            display_mat(Matrix_Storage_RGB.store_rgb.get(j).getMat_blue(), Matrix_Storage_RGB.store_rgb.get(j).getRow(), Matrix_Storage_RGB.store_rgb.get(j).getCol());

            System.out.println();
        

        }
    }
    
    static void copy(int mainn[][], int copy[][], int row, int col){

        for (int i = 0; i < row; i++){

            for (int j = 0; j < col; j++){

                copy[i][j] = mainn[i][j];
                    
            }
            
        }
    }

    static int[][] compute_negative(int [][] mat, int row, int col) {

        int [][] temp = new int [row][col];

        copy(mat, temp, row, col);

        for (int i = 0 ; i<row ; i++) {

            for (int j = 0 ; j<col ; j++){

                temp[i][j] = 255-mat[i][j];

            }

        }

        return temp;

    }

    static void print_rgb () {

        int[][] red = {{65,98,45},{214,189,135},{255,2,56}};
        int[][] green = {{32,45,89},{45,29,46},{100,146,5}};
        int[][] blue = {{12,13,8},{89,48,65},{205,178,99}};

        System.out.println("RED Colour: ");
        display_mat(red, 3, 3);

        System.out.println("GREEN Colour: ");
        display_mat(green, 3, 3);

        System.out.println("BLUE Colour: ");
        display_mat(blue, 3, 3);

    }

    static void print_grayscale() {

        int[][] gray = {{8,65,125},{48,254,126},{9,80,110}};

        System.out.println("Image: ");
        display_mat(gray, 3, 3);

    }
}
