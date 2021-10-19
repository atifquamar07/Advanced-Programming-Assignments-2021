import java.util.*;

public class Driver_Code {

    private static ArrayList <String> instructor_list = new ArrayList<>();

    private static ArrayList <String> student_list = new ArrayList<>();
    

    public static void main(String[] args) {

        instructor_list.add("I0");
        instructor_list.add("I1");

        student_list.add("S0");
        student_list.add("S1");
        student_list.add("S2");

        while (true){
            
            System.out.println("-----------------------------------");
            System.out.println("       Welcome to Backpack");
            System.out.println("-----------------------------------");
            
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Enter as instructor\n2. Enter as student \n3. Exit");
            System.out.println();
            System.out.print("Enter option: ");

            int op = Integer.parseInt(sc.nextLine());
            System.out.println();

            if (op==1) {

                System.out.println("Instructors");
                    
                for (int i = 0 ; i<instructor_list.size() ; i++){
                    System.out.println(i + ". I" + i);
                }

                System.out.print("Choose ID: ");
                int l = Integer.parseInt(sc.nextLine());

                while (true) {
            
                    System.out.println("-------------------------------");

                    if (l==0){
                        System.out.println("          Welcome I0");
                        System.out.println("-------------------------------");
                    }
                    else{
                        System.out.println("          Welcome I1");
                        System.out.println("-------------------------------");
                    }

                    System.out.println("1. Add class material\n2. Add assessments \n3. View lecture materials \n4. View assessments");
                    System.out.println("5. Grade assessments \n6. Close assessment \n7. View comments");
                    System.out.println("8. Add comments \n9. Logout");

                    System.out.println("-------------------------");

                    Implementing_Functions obj = new Implementing_Functions();

                    System.out.print("Enter the option no you want to select: ");
                    int option = Integer.parseInt(sc.nextLine());

                    System.out.println();
                    

                    if (option==1){

                        obj.add_class_material(l);

                    } else if (option==2){

                        obj.add_assessments(l);

                    } else if (option==3){

                        obj.view_lecture_material();

                    } else if (option==4){

                        obj.view_assessments();

                    } else if (option==5){

                        obj.grade_assessments(l);

                    } else if (option==6){

                        obj.close_assessments();

                    } else if (option==7){

                        obj.view_comments();

                    } else if (option==8){

                        obj.add_comments_instructor(l);

                    } else if (option==9){

                        obj.logout();
                        break;

                    }   

                }

            } else if (op==2) {

                System.out.println("------------------------");
                System.out.println("Students: ");
                System.out.println("------------------------");
                System.out.println("0 - S0 \n1 - S1 \n2 - S2");
                System.out.println();
                System.out.print("Choose ID: ");

                int stud = Integer.parseInt(sc.nextLine());
            

                while (true) {

                    System.out.println("-------------------------------");

                    if (stud==0){
                        System.out.println("          Welcome S0");
                        System.out.println("-------------------------------");
                    }
                    else if (stud==1){
                        System.out.println("          Welcome S1");
                        System.out.println("-------------------------------");
                    } else {
                        System.out.println("          Welcome S2");
                        System.out.println("-------------------------------");
                    }

                    System.out.println("1. View lecture materials\n2. View assessments \n3. Submit assessment \n4. View grades");
                    System.out.println("5. View comments \n6. Add comments \n7. Logout");

                    System.out.println("-------------------------");

                    System.out.print("Enter the option no you want to select: ");
                    int option = Integer.parseInt(sc.nextLine());
                    

                    Implementing_Functions obj = new Implementing_Functions();

                    if (option==1){

                        obj.view_lecture_material();

                    } else if (option==2){

                        obj.view_assessments();

                    } else if (option==3){

                        Student_info obj1 = new Student_info();

                        if (stud==0){
                            obj1.student0_submit_assessments(stud);
                        } else if (stud==1) {
                            obj1.student1_submit_assessments(stud);
                        } else if (stud==2) {
                            obj1.student2_submit_assessments(stud);
                        }

                    } else if (option==4){

                        obj.view_grades(stud);

                    } else if (option==5){

                        obj.view_comments();

                    } else if (option==6){

                        obj.add_comments_student(stud);

                    } else if (option==7){

                        obj.logout();
                        break;

                    }
            
                }

            } else {

                break;

            }

        }

    }
    
}
