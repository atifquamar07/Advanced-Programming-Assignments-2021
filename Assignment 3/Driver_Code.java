import java.util.*;

class Driver_Code {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("--------------------------------------------------");
        System.out.println("          WELCOME TO MATRIX CALCULATOR");
        System.out.println("--------------------------------------------------");

        Matrix_Examples.mat_add();

        while(true) {

            System.out.println();

            System.out.println("1. Input matrices as input and label them with appropriate matrix-types.");
            System.out.println("2. Create matrices of requested matrix-types and label them with appropriate matrix-types. ");
            System.out.println("3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid. ");
            System.out.println("4. Display all the matrix-type labels of a requested matrix. ");
            System.out.println("5. Perform addition, subtraction, multiplication & division. ");
            System.out.println("6. Perform element-wise operations. ");
            System.out.println("7. Transpose matrices. ");
            System.out.println("8. Inverse matrices. ");
            System.out.println("9. Compute means: row-wise mean, column-wise mean, mean of all the elements. ");
            System.out.println("10. Compute determinants. ");
            System.out.println("11. Use singleton matrices as scalars, if requested. ");
            System.out.println("12. Compute A+A(t) for a matrix. ");
            System.out.println("13. Compute Eigen vectors and values. ");
            System.out.println("14. Solve sets of linear equations using matrices. ");
            System.out.println("15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels. ");
            System.out.println("16. Exit");

            System.out.println();

            System.out.print("Enter the operation no which you would like to perform: ");

            int opt = Integer.parseInt(sc.nextLine());

            if (opt==1){

                System.out.print("Enter no. of rows you want: ");
                int row = Integer.parseInt(sc.nextLine());

                System.out.print("Enter no. of columns you want: ");
                int col = Integer.parseInt(sc.nextLine());

                float[][] original_mat = new float[row][col];

                for (int i = 0 ; i<row ; i++){

                    for (int j = 0 ; j<col ; j++){

                        System.out.print("Enter the ("+ (i)+","+ (j)+ ")th element of the matrix: ");
                        int ele = Integer.parseInt(sc.nextLine());
                        original_mat[i][j] = ele;

                    }

                }

                float[][] temp = new float[row][col];

                System.out.println();
                System.out.println("The matrix has been registered in the database.");

                Miscellaneous.copy(original_mat, temp, row, col);
                
                ArrayList<String> types = Miscellaneous.print_matrix_types(temp, row, col);

                Matrix_Storage obj = new Matrix_Storage(original_mat, types, row, col);

                Matrix_Storage.efficient_storage(original_mat, row, col);

                if (types.contains("Null Matrix")){

                    float [][] x = {{0}};

                    if (x.length==2){

                        Zero_or_One obj_null = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_null);

                    } else if (x.length==3){

                        Zero_or_One obj_null = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_null);

                    }
                    

                } else if (types.contains("One's Matrix")){

                    float [][] x = {{1}};

                    if (x.length==2){

                        Zero_or_One obj_null = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_null);

                    } else if (x.length==3) {

                        Zero_or_One obj_null = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_null);

                    }

                } else if (types.contains("Upper Triangular Matrix")){

                    float[][] compy = new float[row][col];
                    Miscellaneous.copy(original_mat, compy, row, col);


                    if (compy.length==2){

                        float [][] x = {{compy[0][0], compy[0][1]}, {compy[1][1]}};

                        Zero_or_One obj_upper = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_upper);

                    } else if (compy.length==3) {

                        float [][] x = {{compy[0][0], compy[0][1], compy[0][2]}, {compy[1][1], compy[1][2]}, {compy[2][2]}};

                        Zero_or_One obj_upper = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_upper);

                    }

                } else if (types.contains("Lower Triangular Matrix")){

                    float[][] compy = new float[row][col];
                    Miscellaneous.copy(original_mat, compy, row, col);


                    if (compy.length==2){

                        float [][] x = {{compy[0][0], compy[1][0]}, {compy[1][1]}};

                        Zero_or_One obj_lower = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_lower);

                    } else if (compy.length==3) {

                        float [][] x = {{compy[0][0]}, {compy[1][0], compy[1][1]}, {compy[2][0], compy[2][1], compy[2][2]}};

                        Zero_or_One obj_lower = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(obj_lower);

                    }

                } else if (types.contains("Symmetric Matrix")){

                    float[][] compy = new float[row][col];
                    Miscellaneous.copy(original_mat, compy, row, col);


                    if (compy.length==2){

                        float [][] x = {{compy[0][0], compy[1][0]}, {compy[1][1]}};

                        Zero_or_One symmetric = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(symmetric);

                    } else if (compy.length==3) {

                        float [][] x = {{compy[0][0]}, {compy[1][0], compy[1][1]}, {compy[2][0], compy[2][1], compy[2][2]}};

                        Zero_or_One symmetric = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(symmetric);

                    }

                } else if (types.contains("Skew Symmetric Matrix")){

                    float[][] compy = new float[row][col];
                    Miscellaneous.copy(original_mat, compy, row, col);


                    if (compy.length==2){

                        float [][] x = {{compy[0][0], compy[1][0]}, {compy[1][1]}};

                        Zero_or_One symmetric = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(symmetric);

                    } else if (compy.length==3) {

                        float [][] x = {{compy[0][0]}, {compy[1][0], compy[1][1]}, {compy[2][0], compy[2][1], compy[2][2]}};

                        Zero_or_One symmetric = new Zero_or_One(x, types, 2, 2);

                        Zero_or_One.store.add(symmetric);

                    }

                }

                Matrix_Storage.store.add(obj);
                

            } else if (opt==2) {

                System.out.print("Enter the matrix type you want: ");
                String s = sc.nextLine();

                if (s.equals("Row Matrix")){

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals("Row Matrix")){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 1, 3);

                        }

                    }

                } else if (s.equals("Column Matrix")){

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals("Column Matrix")){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 3, 1);

                        }

                    }

                } else if (s.equals("Rectangular Matrix")){

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals("Rectangular Matrix")){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 3, 5);

                        }

                    }

                } else {

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals(s)){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 3, 3);

                        }

                    }

                }

            } else if (opt==3) {

                System.out.print("Enter the matrix type you want to change: ");
                String s = sc.nextLine();
                System.out.println();
                System.out.println("This is the matrix: ");

                float[][] temp1 = new float[1][3];
                float[][] temp2 = new float[3][1];
                float[][] temp3 = new float[3][5];
                float[][] temp4 = new float[3][3];

                int check1 = 0;
                int check2 = 0;
                int check3 = 0;
                int check4 = 0;

                if (s.equals("Row Matrix")){

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals("Row Matrix")){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 1, 3);
                            Miscellaneous.copy(Matrix_Examples.matrix_ex.get(i).mat, temp1, 1, 3);
                            check1=1;

                        }

                    }

                } else if (s.equals("Column Matrix")){

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals("Column Matrix")){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 3, 1);
                            Miscellaneous.copy(Matrix_Examples.matrix_ex.get(i).mat, temp2, 3, 1);
                            check2=1;

                        }

                    }

                } else if (s.equals("Rectangular Matrix")){

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals("Rectangular Matrix")){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 3, 5);
                            Miscellaneous.copy(Matrix_Examples.matrix_ex.get(i).mat, temp3, 3, 5);
                            check3=1;

                        }

                    }

                } else {

                    for (int i = 0 ; i<Matrix_Examples.matrix_ex.size() ; i++){

                        if (Matrix_Examples.matrix_ex.get(i).mat_type.equals(s)){

                            Miscellaneous.display(Matrix_Examples.matrix_ex.get(i).mat, 3, 3);
                            Miscellaneous.copy(Matrix_Examples.matrix_ex.get(i).mat, temp4, 3, 3);
                            check4=1;

                        }

                    }

                }

                if (check1==1){

                    System.out.print("Enter the row no of the element you want to change: ");
                    int x = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter the element: ");
                    int ele = Integer.parseInt(sc.nextLine());

                    temp1[1][x] = ele;
                    System.out.println();
                    System.out.println("It was a valid entry and the property of the matrix does not change.");
                    Miscellaneous.display(temp1, 1, 3);

                } else if (check2==1) {

                    System.out.print("Enter the column no of the element you want to change: ");
                    int x = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter the element: ");
                    int ele = Integer.parseInt(sc.nextLine());

                    temp2[3][x] = ele;
                    System.out.println();
                    System.out.println("It was a valid entry and the property of the matrix does not change.");
                    Miscellaneous.display(temp2, 1, 3);
                    
                } else if (check3==1){

                    System.out.print("Enter the row no of the element you want to change: ");
                    int x = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter the column no of the element you want to change: ");
                    int y = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter the element: ");
                    int ele = Integer.parseInt(sc.nextLine());

                    temp3[x][y] = ele;
                    System.out.println();
                    System.out.println("It was a valid entry and the property of the matrix does not change.");
                    Miscellaneous.display(temp3, 1, 3);
                    
                } else if (check4==1){

                    System.out.print("Enter the row no of the element you want to change: ");
                    int x = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter the column no of the element you want to change: ");
                    int y = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter the element: ");
                    int ele = Integer.parseInt(sc.nextLine());

                    temp4[x][y] = ele;

                    ArrayList<String> ll = Miscellaneous.print_matrix_types(temp4, 3, 3);

                    if (ll.contains(s)){

                        System.out.println();
                        System.out.println("It was a valid entry and the property of the matrix does not change.");
                        Miscellaneous.display(temp4, 3, 3);

                    } else {
                        System.out.println();
                        System.out.println("Element changed disrupts the property of the matrix. Hence matrix cannot be changed.");
                        System.out.println();
                    }
                    

                }

            } else if (opt==4) {

                for (int i = 0 ; i<Matrix_Storage.store.size() ; i++){

                    System.out.println("S.no:- " + i);
                    Miscellaneous.display(Matrix_Storage.store.get(i).getMat(), Matrix_Storage.store.get(i).getRow(), Matrix_Storage.store.get(i).getCol());

                }
                System.out.println();

                System.out.print("Enter the matrix id of the matrix whose types you want to know: ");
                int id = Integer.parseInt(sc.nextLine());

                ArrayList<String> ty = Matrix_Storage.store.get(id).getTypes();
                System.out.println();

                System.out.println("The matrix has the following types: ");
                System.out.println();
                

                for (int j = 0 ; j<ty.size() ; j++){

                    System.out.println(ty.get(j));
                }
                

            } else if (opt==5) {

                System.out.print("Enter the operation you want to perform: ");
                System.out.println();
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println();
                System.out.print("Enter option: ");

                int s = Integer.parseInt(sc.nextLine());

                Miscellaneous.display_all_entered_matrices();

                if (s==1){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    float[][] x = Matrix_operations.addition(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, Matrix_Storage.store.get(id2).getMat());

                    System.out.println();
                    Miscellaneous.display(x, row, row);

                } else if (s==2){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    float[][] x = Matrix_operations.subtraction(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, Matrix_Storage.store.get(id2).getMat());

                    System.out.println();
                    Miscellaneous.display(x, row, row);

                } else if (s==3){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    if (Matrix_Storage.store.get(id1).getTypes().contains("Null Matrix") || Matrix_Storage.store.get(id2).getTypes().contains("Null Matrix")){

                        System.out.println();
                        float[][] nul3 = {{0,0,0},{0,0,0},{0,0,0}};
                        float[][] nul2 = {{0,0},{0,0}};

                        if (Matrix_Storage.store.get(id1).getRow()==2){
                            Miscellaneous.display(nul2, 2, 2);
                            System.out.println();
                            continue;
                        }

                        else if (Matrix_Storage.store.get(id1).getRow()==3){
                            Miscellaneous.display(nul3, 3, 3);
                            System.out.println();
                            continue;
                        }

                    }

                    float[][] x = Matrix_operations.multiplication(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, Matrix_Storage.store.get(id2).getMat());

                    System.out.println();
                    Miscellaneous.display(x, row, row);

                } else if (s==4){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    if (Matrix_Storage.store.get(id2).getTypes().contains("Singular Matrix")){

                        System.out.println();
                        System.out.println("You cannot use a singular matrix as a divisor.");
                        System.out.println();
                        continue;

                    } else {

                        float[][] inv = Matrix_operations.invert(Matrix_Storage.store.get(id2).getMat());
                        float[][] div = Matrix_operations.multiplication(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, inv);

                        System.out.println();
                        Miscellaneous.display(div, row, row);

                    }

                }


            } else if (opt==6) {

                System.out.print("Enter the element wise operation you want to perform: ");
                String s = sc.nextLine();

                Miscellaneous.display_all_entered_matrices();

                if (s.equals("Addition")){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    float[][] x = Matrix_operations.addition(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, Matrix_Storage.store.get(id2).getMat());

                    Miscellaneous.display(x, row, row);

                } else if (s.equals("Subtraction")){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    float[][] x = Matrix_operations.subtraction(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, Matrix_Storage.store.get(id2).getMat());

                    Miscellaneous.display(x, row, row);

                } else if (s.equals("Multiplication")){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    if (Matrix_Storage.store.get(id1).getTypes().contains("Null Matrix") || Matrix_Storage.store.get(id2).getTypes().contains("Null Matrix")){

                        System.out.println();
                        float[][] nul3 = {{0,0,0},{0,0,0},{0,0,0}};
                        float[][] nul2 = {{0,0},{0,0}};

                        if (Matrix_Storage.store.get(id1).getRow()==2){
                            Miscellaneous.display(nul2, 2, 2);
                            System.out.println();
                            continue;
                        }

                        else if (Matrix_Storage.store.get(id1).getRow()==3){
                            Miscellaneous.display(nul3, 3, 3);
                            System.out.println();
                            continue;
                        }

                    }

                    float[][] x = Matrix_operations.element_wise_multiplication(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, Matrix_Storage.store.get(id2).getMat());

                    Miscellaneous.display(x, row, row);

                } else if (s.equals("Division")){

                    System.out.print("Enter id 1: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();

                    System.out.print("Enter id 2: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    if (Matrix_Storage.store.get(id1).getTypes().contains("Null Matrix")){

                        System.out.println();
                        float[][] nul3 = {{0,0,0},{0,0,0},{0,0,0}};
                        float[][] nul2 = {{0,0},{0,0}};

                        if (Matrix_Storage.store.get(id1).getRow()==2){
                            Miscellaneous.display(nul2, 2, 2);
                            System.out.println();
                            continue;
                        }

                        else if (Matrix_Storage.store.get(id1).getRow()==3){
                            Miscellaneous.display(nul3, 3, 3);
                            System.out.println();
                            continue;
                        }

                    } else if (Matrix_Storage.store.get(id2).getTypes().contains("Null Matrix")){

                        System.out.println();
                        System.out.println("You cannot use a null matrix as a divisor.");
                        System.out.println();
                        continue;
                    }

                    float[][] x = Matrix_operations.element_wise_division(row, row, Matrix_Storage.store.get(id1).getMat(), row, row, Matrix_Storage.store.get(id2).getMat());

                    Miscellaneous.display(x, row, row);

                }

            } else if (opt==7) {

                Miscellaneous.display_all_entered_matrices();

                System.out.print("Enter id of the matrix to be transposed: ");
                int id = Integer.parseInt(sc.nextLine());

                int row = Matrix_Storage.store.get(id).getRow();

                float[][] x =  Miscellaneous.transpose_matrix(row, row, Matrix_Storage.store.get(id).getMat());

                Miscellaneous.display(x, row, row);

            } else if (opt==8) {

                Miscellaneous.display_all_entered_matrices();

                System.out.print("Enter id of the matrix to be inversed: ");
                int id = Integer.parseInt(sc.nextLine());

                if (Matrix_Storage.store.get(id).getTypes().contains("Singular Matrix")){

                    System.out.println();
                    System.out.println("Inverse cannot be calculated for singular matrices.");
                    System.out.println();
                    continue;

                }

                int row = Matrix_Storage.store.get(id).getRow();

                float[][] x =  Matrix_operations.invert(Matrix_Storage.store.get(id).getMat());

                Miscellaneous.display(x, row, row);

            } else if (opt==9) {

                System.out.println("1. Row-Wise Mean ");
                System.out.println("2. Column-Wise Mean ");
                System.out.println("3. Mean of all elements ");
                System.out.println();

                System.out.print("Enter the id of the computation you want to perform: ");
                int r = Integer.parseInt(sc.nextLine());

                if (r==1){

                    Miscellaneous.display_all_entered_matrices();

                    System.out.print("Enter id of the matrix to compute row wise mean: ");
                    int id = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id).getRow();
                    int col = Matrix_Storage.store.get(id).getCol();

                    float[][] x =  Matrix_operations.row_wise_mean(row, col, Matrix_Storage.store.get(id).getMat());

                    System.out.println();
                    System.out.println("Column vector for mean is:");
                    System.out.println();
                    Miscellaneous.display(x, row, 1);

                } else if (r==2) {

                    Miscellaneous.display_all_entered_matrices();

                    System.out.print("Enter id of the matrix to compute column wise mean: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();
                    int col = Matrix_Storage.store.get(id1).getCol();

                    float[][] x =  Matrix_operations.col_wise_mean(row, col, Matrix_Storage.store.get(id1).getMat());

                    System.out.println();
                    System.out.println("Row vector for mean is:");
                    System.out.println();
                    Miscellaneous.display(x, 1, col);

                } else if (r==3) {

                    Miscellaneous.display_all_entered_matrices();

                    System.out.print("Enter id of the matrix to compute mean of all elements: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id2).getRow();

                    float x =  Matrix_operations.mean_all_elements(row, row, Matrix_Storage.store.get(id2).getMat());

                    System.out.println();
                    System.out.println("Mean of all elements of matrix is: " + x);

                }

               

            } else if (opt==10) {

                Miscellaneous.display_all_entered_matrices();

                System.out.print("Enter id of the matrix for computation of determinant: ");
                int id = Integer.parseInt(sc.nextLine());

                if (Matrix_Storage.store.get(id).getTypes().contains("Null Matrix") || Matrix_Storage.store.get(id).getTypes().contains("One's Matrix")){

                    System.out.println("Determinant of the matrix is: 0");
                    System.out.println();
                    continue;

                }

                else if (Matrix_Storage.store.get(id).getTypes().contains("Singleton Matrix")){

                    System.out.println("Determinant of the matrix is: " + Matrix_Storage.store.get(id).getMat()[0][0]);
                    System.out.println();
                    continue;
                }

                else if (Matrix_Storage.store.get(id).getTypes().contains("Diagonal Matrix")){

                    if (Matrix_Storage.store.get(id).getRow()==2){

                        float det = (Matrix_Storage.store.get(id).getMat()[0][0]) * (Matrix_Storage.store.get(id).getMat()[1][1]);
                        System.out.println("Determinant of the matrix is: " + det);
                        System.out.println();
                        continue;

                    }

                    else if (Matrix_Storage.store.get(id).getRow()==3){

                        float det = (Matrix_Storage.store.get(id).getMat()[0][0]) * (Matrix_Storage.store.get(id).getMat()[1][1]) * (Matrix_Storage.store.get(id).getMat()[2][2]);
                        System.out.println("Determinant of the matrix is: " + det);
                        System.out.println();
                        continue;
                        
                    }
                    
                }

                float x =  Miscellaneous.determinant(Matrix_Storage.store.get(id).getMat());

                System.out.println("Determinant of the matrix is: " + x);


            } else if (opt==11) {

                System.out.println("Do you allow using singleton matrices as a scalar value?");
                String pp = sc.nextLine();

                if (pp.equals("Yes")){

                    Miscellaneous.display_all_entered_matrices();

                    System.out.print("Choose a matrix: ");
                    int id1 = Integer.parseInt(sc.nextLine());

                    System.out.print("Choose a singleton matrix now: ");
                    int id2 = Integer.parseInt(sc.nextLine());

                    int row = Matrix_Storage.store.get(id1).getRow();
                    int col = Matrix_Storage.store.get(id1).getCol();

                    System.out.println("Result after multiplying is: ");

                    float z[][] = Matrix_operations.scalar_multiplication(row, col, Matrix_Storage.store.get(id1).getMat(), Matrix_Storage.store.get(id2).getMat()[0][0]);

                    Miscellaneous.display(z, row, col);

                } else {
                    continue;
                }

                
            } else if (opt==12) {

                Miscellaneous.display_all_entered_matrices();

                System.out.print("Enter id of the matrix to be to compute A + A(t): ");
                int id = Integer.parseInt(sc.nextLine());

                int row = Matrix_Storage.store.get(id).getRow();

                float[][] x =  Matrix_operations.compute_transpose_addition(row, row, Matrix_Storage.store.get(id).getMat());

                Miscellaneous.display(x, row, row);

            } else if (opt==13) {

                Miscellaneous.display_all_entered_matrices();

                System.out.print("Enter id of the matrix to compute eigenvalues and eigenvectors for: ");
                int id = Integer.parseInt(sc.nextLine());

                ArrayList<Float> x =  Matrix_operations.eigenvalues(Matrix_Storage.store.get(id).getMat());

                System.out.println();
                System.out.print("The eigenvalues of the matrix are: ");

                if (x.size()==1){

                    System.out.print(x.get(0));

                } else if (x.size()==2){

                    System.out.println(x.get(0) + ", " + x.get(1));

                }
                System.out.println();

                System.out.println("The eigenvectors of the matrix are: ");
                System.out.println();

                ArrayList<float[][]> ans = Matrix_operations.eigenvectors(Matrix_Storage.store.get(id).getMat());

                if (ans.size()==1){

                    System.out.println("Eigenvector 1: ");
                    System.out.println();
                    Miscellaneous.display(ans.get(0), 2, 1);

                } else if (ans.size()==2){

                    System.out.println("Eigenvector 1: ");
                    System.out.println();
                    Miscellaneous.display(ans.get(0), 2, 1);
                    System.out.println("Eigenvector 2: ");
                    System.out.println();
                    Miscellaneous.display(ans.get(1), 2, 1);

                }

                System.out.println();


            } else if (opt==14) {


                Miscellaneous.display_all_entered_matrices();

                System.out.print("Enter id of the matrix to be to solve system of linear equations: ");
                int id1 = Integer.parseInt(sc.nextLine());

                System.out.println("Enter id of the matrix for B: ");
                int id2 = Integer.parseInt(sc.nextLine());

                int row = Matrix_Storage.store.get(id1).getRow();

                float[][] x =  Matrix_operations.solve_linear_equations(Matrix_Storage.store.get(id1).getMat(), Matrix_Storage.store.get(id2).getMat(), row , row);

                Miscellaneous.display(x, row, row);


            } else if (opt==15){


                System.out.println("All entered matrices are: ");
                System.out.println();
                Miscellaneous.display_all_entered_matrices();


            } else if (opt == 16){

                System.out.println();
                System.out.println("Thank You.");
                System.out.println();
                break;

            }

        }
        
    }

}
