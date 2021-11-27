import java.util.*;

class Driver_Code {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        while (true) {

            System.out.println("--------------------------------------------------");
            System.out.println("          WELCOME TO IMAGE GENERATOR");
            System.out.println("--------------------------------------------------");
            System.out.println();

            System.out.println("Operations available.");
            System.out.println();
            System.out.println("1. Input images");
            System.out.println("2. Display images.");
            System.out.println("3. Update images");
            System.out.println("4. Compute negatives. ");
            System.out.println("5. Create images");
            System.out.println("6. Exit");

            System.out.println();
            System.out.print("Enter the option no you want to perform: ");

            int op = Integer.parseInt(sc.nextLine());

            if (op==1) {

                System.out.println("1. RGB Matrix");
                System.out.println("2. Grayscale Matrix");
                System.out.println();

                System.out.print("Enter the type of matrix you want to enter: ");

                int opt = Integer.parseInt(sc.nextLine());
                System.out.println();

                if (opt==1){

                    System.out.println("Enter the matrix for RED colour: ");
                    System.out.println();

                    System.out.print("Enter no of rows: ");

                    int row = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter no of columns: ");

                    int col = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    int [][] mat = new int[row][col];

                    for (int i = 0; i<row ; i++){

                        for (int j = 0 ; j<col ; j++){

                            System.out.print("Enter the (" + i + ", " + j + ") element of the matrix: ");
                            int ele = Integer.parseInt(sc.nextLine());

                            mat[i][j] = ele;

                        }

                    }

                    System.out.println();


                    System.out.println("Enter the matrix for BLUE colour: ");
                    System.out.println();


                    int [][] mat1 = new int[row][col];

                    for (int i = 0; i<row ; i++){

                        for (int j = 0 ; j<col ; j++){

                            System.out.print("Enter the (" + i + ", " + j + ") element of the matrix: ");
                            int ele1 = Integer.parseInt(sc.nextLine());

                            mat1[i][j] = ele1;

                        }

                    }

                    System.out.println();


                    System.out.println("Enter the matrix for GREEN colour: ");
                    System.out.println();

                    int [][] mat2 = new int[row][col];

                    for (int i = 0; i<row ; i++){

                        for (int j = 0 ; j<col ; j++){

                            System.out.print("Enter the (" + i + ", " + j + ") element of the matrix: ");
                            int ele2 = Integer.parseInt(sc.nextLine());

                            mat2[i][j] = ele2;

                        }

                    }

                    System.out.println();
                    
                    Matrix_Storage_RGB obj = new Matrix_Storage_RGB(mat, mat2, mat1, row, col);

                    Matrix_Storage_RGB.store_rgb.add(obj);


                } else if (opt==2) {


                    System.out.println("Enter the grayscale matrix: ");
                    System.out.println();

                    System.out.print("Enter no of rows: ");

                    int row1 = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter no of columns: ");

                    int col1 = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    int [][] x = new int[row1][col1];

                    for (int i = 0; i<row1 ; i++){

                        for (int j = 0 ; j<col1 ; j++){

                            System.out.print("Enter the (" + i + ", " + j + ") element of the matrix: ");
                            int q = Integer.parseInt(sc.nextLine());

                            x[i][j] = q;

                        }

                    }

                    Matrix_Storage_Grayscale objj = new Matrix_Storage_Grayscale(x, row1, col1);

                    Matrix_Storage_Grayscale.store_grayscale.add(objj);


                }

            } else if (op==2) {

                System.out.println();

                System.out.println("Which image type you want to see?");

                System.out.println("1. RGB Image");
                System.out.println("2. Grayscale Image");
                System.out.println();

                System.out.print("Enter option: ");
                int h = Integer.parseInt(sc.nextLine());
                System.out.println();

                if (h==1) {

                    Matrix_functions.display_RGB();

                } else if (h==2) {

                    Matrix_functions.display_grayscale();

                }


            } else if (op==3) {

                System.out.println("Which type of image you want to update?");
                System.out.println();
                System.out.println("1. RGB Image");
                System.out.println("2. Grayscale Image");
                System.out.println();

                System.out.print("Enter option no: ");
                int l = Integer.parseInt(sc.nextLine());
                
                if (l==1) {

                    Matrix_functions.display_RGB();

                    System.out.print("Enter the s.no. of the matrix you want to alter: ");
                    int p = Integer.parseInt(sc.nextLine());

                    System.out.println("1. RED colour");
                    System.out.println("2. GREEN colour");
                    System.out.println("3. BLUE colour");
                    System.out.println();

                    System.out.print("Enter the option no of the colour of the matrix you want to alter: ");
                    int b = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    System.out.println("This is the matrix. ");
                    System.out.println();

                    if (b==1){

                        Matrix_functions.display_mat(Matrix_Storage_RGB.store_rgb.get(p).getMat_red(), Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());
                        int[][] w = new int[Matrix_Storage_RGB.store_rgb.get(p).getRow()][Matrix_Storage_RGB.store_rgb.get(p).getCol()];

                        Matrix_functions.copy(Matrix_Storage_RGB.store_rgb.get(p).getMat_red(), w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.print("Enter row no of the element to be changed: ");
                        int r = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter col no of the element to be changed: ");
                        int c = Integer.parseInt(sc.nextLine());
                        System.out.println();

                        System.out.print("Enter the new element: ");
                        int elee = Integer.parseInt(sc.nextLine());
                        System.out.println();

                        w[r][c] = elee;

                        System.out.println("This is the updated image: ");

                        System.out.println();
                        System.out.println("RED Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.println();
                        System.out.println("GREEN Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(Matrix_Storage_RGB.store_rgb.get(p).getMat_green(), Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.println();
                        System.out.println("BLUE Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(Matrix_Storage_RGB.store_rgb.get(p).getMat_blue(), Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());


                    } else if (b==2) {

                        Matrix_functions.display_mat(Matrix_Storage_RGB.store_rgb.get(p).getMat_green(), Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());
                        int[][] w = new int[Matrix_Storage_RGB.store_rgb.get(p).getRow()][Matrix_Storage_RGB.store_rgb.get(p).getCol()];

                        Matrix_functions.copy(Matrix_Storage_RGB.store_rgb.get(p).getMat_green(), w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.print("Enter row no of the element to be changed: ");
                        int r = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter col no of the element to be changed: ");
                        int c = Integer.parseInt(sc.nextLine());

                        System.out.println();

                        System.out.print("Enter the new element: ");
                        int elee = Integer.parseInt(sc.nextLine());
                        System.out.println();

                        w[r][c] = elee;

                        System.out.println("This is the updated image: ");

                        System.out.println();
                        System.out.println("RED Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.println();
                        System.out.println("GREEN Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.println();
                        System.out.println("BLUE Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(Matrix_Storage_RGB.store_rgb.get(p).getMat_blue(), Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        

                    } else if (b==3) {

                        Matrix_functions.display_mat(Matrix_Storage_RGB.store_rgb.get(p).getMat_blue(), Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());
                        int[][] w = new int[Matrix_Storage_RGB.store_rgb.get(p).getRow()][Matrix_Storage_RGB.store_rgb.get(p).getCol()];

                        Matrix_functions.copy(Matrix_Storage_RGB.store_rgb.get(p).getMat_blue(), w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.print("Enter row no of the element to be changed: ");
                        int r = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter col no of the element to be changed: ");
                        int c = Integer.parseInt(sc.nextLine());

                        System.out.println();
                        System.out.print("Enter the new element: ");
                        int elee = Integer.parseInt(sc.nextLine());
                        System.out.println();

                        w[r][c] = elee;

                        System.out.println("This is the updated image: ");

                        System.out.println();
                        System.out.println("RED Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.println();
                        System.out.println("GREEN Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(Matrix_Storage_RGB.store_rgb.get(p).getMat_green(), Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        System.out.println();
                        System.out.println("BLUE Colour: ");
                        System.out.println();
                        Matrix_functions.display_mat(w, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                        

                    }


                }

            } else if (op == 4) {

                System.out.println("Which type of image you want to compute negative of?");
                System.out.println();
                System.out.println("1. RGB Image");
                System.out.println("2. Grayscale Image");
                System.out.println();

                System.out.print("Enter option no: ");
                int l = Integer.parseInt(sc.nextLine());

                if (l==1) {

                    Matrix_functions.display_RGB();

                    System.out.print("Enter the s.no. of the matrix you want to alter: ");
                    int p = Integer.parseInt(sc.nextLine());

                    int[][] temp_red = new int[Matrix_Storage_RGB.store_rgb.get(p).getRow()][Matrix_Storage_RGB.store_rgb.get(p).getCol()];
                    Matrix_functions.copy(Matrix_Storage_RGB.store_rgb.get(p).getMat_red(), temp_red, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                    int[][] temp_green = new int[Matrix_Storage_RGB.store_rgb.get(p).getRow()][Matrix_Storage_RGB.store_rgb.get(p).getCol()];
                    Matrix_functions.copy(Matrix_Storage_RGB.store_rgb.get(p).getMat_green(), temp_green, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                    int[][] temp_blue = new int[Matrix_Storage_RGB.store_rgb.get(p).getRow()][Matrix_Storage_RGB.store_rgb.get(p).getCol()];
                    Matrix_functions.copy(Matrix_Storage_RGB.store_rgb.get(p).getMat_blue(), temp_blue, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                    int[][] red_n = Matrix_functions.compute_negative(temp_red, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());
                    int[][] green_n = Matrix_functions.compute_negative(temp_green, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());
                    int[][] blue_n = Matrix_functions.compute_negative(temp_blue, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                    System.out.println();
                    System.out.println("These are the negatives of the selected image matrix: ");
                    System.out.println();

                    System.out.println("RED Colour negative.");
                    System.out.println();
                    Matrix_functions.display_mat(red_n, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                    System.out.println("GREEN Colour negative.");
                    System.out.println();
                    Matrix_functions.display_mat(green_n, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());

                    System.out.println("BLUE Colour negative.");
                    System.out.println();
                    Matrix_functions.display_mat(blue_n, Matrix_Storage_RGB.store_rgb.get(p).getRow(), Matrix_Storage_RGB.store_rgb.get(p).getCol());


                } else if (l==2) {

                    Matrix_functions.display_grayscale();

                    System.out.print("Enter the s.no. of the matrix you want to alter: ");
                    int p = Integer.parseInt(sc.nextLine());

                    int[][] temp = new int[Matrix_Storage_Grayscale.store_grayscale.get(p).getRow()][Matrix_Storage_Grayscale.store_grayscale.get(p).getCol()];
                    Matrix_functions.copy(Matrix_Storage_Grayscale.store_grayscale.get(p).getMat(), temp, Matrix_Storage_Grayscale.store_grayscale.get(p).getRow(), Matrix_Storage_Grayscale.store_grayscale.get(p).getCol());

                    int[][] temp_n = Matrix_functions.compute_negative(temp, Matrix_Storage_Grayscale.store_grayscale.get(p).getRow(), Matrix_Storage_Grayscale.store_grayscale.get(p).getCol());

                    System.out.println();
                    System.out.println("This is the negatives of the selected image matrix: ");
                    System.out.println();

                    Matrix_functions.display_mat(temp_n,Matrix_Storage_Grayscale.store_grayscale.get(p).getRow(), Matrix_Storage_Grayscale.store_grayscale.get(p).getCol());


                }


            } else if (op==5) {

                System.out.println("Which type of image you want to generate?");
                System.out.println();
                System.out.println("1. RGB Image");
                System.out.println("2. Grayscale Image");
                System.out.println();

                System.out.print("Enter Image type: ");
                String l = sc.nextLine();


                if (l.equals("RGB")) {

                    System.out.println();
                    System.out.println("The random RGB image generated is: ");
                    Matrix_functions.print_rgb();
                    
                } else if (l.equals("Grayscale")) {

                    System.out.println();
                    System.out.println("The random grayscale image generated is: ");
                    Matrix_functions.print_grayscale();

                }


            } else if (op==6) {

                System.out.println();
                System.out.println("THANK YOU");
                System.out.println();
                break;

            }

        }

    }

}