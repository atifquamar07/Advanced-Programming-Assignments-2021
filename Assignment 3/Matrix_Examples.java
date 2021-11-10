import java.util.ArrayList;

class Matrix_Examples {

    static ArrayList<Matrix_Examples> matrix_ex = new ArrayList<>();

    float[][] mat = new float[3][3];
    String mat_type;

    Matrix_Examples(float[][] mat, String mat_type){

        this.mat = mat;
        this.mat_type = mat_type;

    }

    static void mat_add(){

        float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        String mat_type1 = "Square Matrix";
        Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        matrix_ex.add(obj1);

        float[][] mat2 = {{8,5,6}};
        String mat_type2 = "Row Matrix";
        Matrix_Examples obj2 = new Matrix_Examples(mat2, mat_type2);
        matrix_ex.add(obj2);

        float[][] mat3 = {{1},{3},{6}};
        String mat_type3 = "Column Matrix";
        Matrix_Examples obj3 = new Matrix_Examples(mat3, mat_type3);
        matrix_ex.add(obj3);

        float[][] mat4 = {{1,2,3,5,6},{3,4,5,9,3},{6,7,3,6,8}};
        String mat_type4 = "Rectangular Matrix";
        Matrix_Examples obj4 = new Matrix_Examples(mat4, mat_type4);
        matrix_ex.add(obj4);

        float[][] mat5 = {{1,2,3},{2,4,5},{3,5,8}};
        String mat_type5 = "Symmetric Matrix";
        Matrix_Examples obj5 = new Matrix_Examples(mat5, mat_type5);
        matrix_ex.add(obj5);

        float[][] mat6 = {{0,3,-2},{-3,0,4},{2,-4,0}};
        String mat_type6 = "Skew Symmetric Matrix";
        Matrix_Examples obj6 = new Matrix_Examples(mat6, mat_type6);
        matrix_ex.add(obj6);

        float[][] mat7 = {{1,2,3},{0,4,5},{0,0,8}};
        String mat_type7 = "Upper Triangular Matrix";
        Matrix_Examples obj7 = new Matrix_Examples(mat7, mat_type7);
        matrix_ex.add(obj7);

        float[][] mat8 = {{1,0,0},{3,4,0},{6,7,8}};
        String mat_type8 = "Lower Square Matrix";
        Matrix_Examples obj8 = new Matrix_Examples(mat8, mat_type8);
        matrix_ex.add(obj8);

        float[][] mat9 = {{3,8,1},{-4,1,1},{-4,1,1}};
        String mat_type9 = "Singular Matrix";
        Matrix_Examples obj9 = new Matrix_Examples(mat9, mat_type9);
        matrix_ex.add(obj9);

        float[][] mat10 = {{5,0,0},{0,4,0},{0,0,8}};
        String mat_type10 = "Diagonal Matrix";
        Matrix_Examples obj10 = new Matrix_Examples(mat10, mat_type10);
        matrix_ex.add(obj10);

        float[][] mat11 = {{8,0,0},{0,8,0},{0,0,8}};
        String mat_type11 = "Scalar Matrix";
        Matrix_Examples obj11 = new Matrix_Examples(mat11, mat_type11);
        matrix_ex.add(obj11);

        float[][] mat12 = {{1,0,0},{0,1,0},{0,0,1}};
        String mat_type12 = "Identity Matrix";
        Matrix_Examples obj12 = new Matrix_Examples(mat12, mat_type12);
        matrix_ex.add(obj12);

        float[][] mat13 = {{9}};
        String mat_type13 = "Singleton Matrix";
        Matrix_Examples obj13 = new Matrix_Examples(mat13, mat_type13);
        matrix_ex.add(obj13);

        float[][] mat14 = {{1,1,1},{1,1,1},{1,1,1}};
        String mat_type14 = "One's Matrix";
        Matrix_Examples obj14 = new Matrix_Examples(mat14, mat_type14);
        matrix_ex.add(obj14);

        float[][] mat15 = {{0,0,0},{0,0,0},{0,0,0}};
        String mat_type15 = "Null Matrix";
        Matrix_Examples obj15 = new Matrix_Examples(mat15, mat_type15);
        matrix_ex.add(obj15);

        // float[][] mat16 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type16 = "Square Matrix";
        // Matrix_Examples obj16 = new Matrix_Examples(mat16, mat_type16);
        // matrix_ex.add(obj16);

        // float[][] mat17 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type17 = "Square Matrix";
        // Matrix_Examples obj17 = new Matrix_Examples(mat17, mat_type17);
        // matrix_ex.add(obj17);

        // float[][] mat18 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type18 = "Square Matrix";
        // Matrix_Examples obj18 = new Matrix_Examples(mat18, mat_type18);
        // matrix_ex.add(obj18);

        // float[][] mat19 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type19 = "Square Matrix";
        // Matrix_Examples obj19 = new Matrix_Examples(mat19, mat_type19);
        // matrix_ex.add(obj19);

        // float[][] mat20 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type20 = "Square Matrix";
        // Matrix_Examples obj20 = new Matrix_Examples(mat20, mat_type20);
        // matrix_ex.add(obj20);

        // float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type1 = "Square Matrix";
        // Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        // matrix_ex.add(obj1);

        // float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type1 = "Square Matrix";
        // Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        // matrix_ex.add(obj1);

        // float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type1 = "Square Matrix";
        // Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        // matrix_ex.add(obj1);

        // float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type1 = "Square Matrix";
        // Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        // matrix_ex.add(obj1);

        // float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type1 = "Square Matrix";
        // Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        // matrix_ex.add(obj1);

        // float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type1 = "Square Matrix";
        // Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        // matrix_ex.add(obj1);

        // float[][] mat1 = {{1,2,3},{3,4,5},{6,7,8}};
        // String mat_type1 = "Square Matrix";
        // Matrix_Examples obj1 = new Matrix_Examples(mat1, mat_type1);
        // matrix_ex.add(obj1);

    }
    

    
}
