import java.util.*;

public class Student_info {

    Scanner sc = new Scanner (System.in);

    static ArrayList<Integer> grades0 = new ArrayList<>();

    static ArrayList<String> submissions0 = new ArrayList<>();

    static ArrayList<String> assessments_condition0 = new ArrayList<>();

    static ArrayList<Integer> grades_by0 = new ArrayList<>();

    static ArrayList<Integer> grades1 = new ArrayList<>();

    static ArrayList<String> submissions1 = new ArrayList<>();

    static ArrayList<String> assessments_condition1 = new ArrayList<>();

    static ArrayList<Integer> grades_by1 = new ArrayList<>();

    static ArrayList<Integer> grades2 = new ArrayList<>();

    static ArrayList<String> submissions2 = new ArrayList<>();

    static ArrayList<String> assessments_condition2 = new ArrayList<>();

    static ArrayList<Integer> grades_by2 = new ArrayList<>();

    private int total = Assessments.assessments_list.size();

    public void student0_submit_assessments(int id) {

        int ch = 0;

        for (int i=0 ; i<Assessments.assessments_list.size() ; i++){

            if(Assessments.assessments_list.get(i)!=null){
                ch=1;
            }
        }

        if (Assessments.assessments_list.size()==0 || ch==0){

            System.out.println();
            System.out.println("No assessment given.");
            System.out.println();
            return;

        }

        System.out.println();

        boolean assessment_there_to_be_solved = true;

        if (!assessments_condition0.contains("not done")){
            assessment_there_to_be_solved = false;
        }

        if (assessment_there_to_be_solved==false){
            System.out.println();
            System.out.println("No pending assignments.");
            System.out.println();
            return;
        }

        System.out.println("Pending assessments");
        System.out.println();

        HashMap<Integer, String> map = new HashMap<>();

        int ctr = 0;

        for (int i = 0 ; i<total ; i++){

            if (Assessments.assessments_list.get(i)!=null && assessments_condition0.get(i).equals("not done") && Assessments.assessments_list.get(i).getIs_assignment()==true){

                System.out.println("ID: " + ctr + ", Assignment: " + Assessments.assessments_list.get(i).getProb_statement() + ", Max Marks: " + Assessments.assessments_list.get(i).getAssign_marks());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            } else if (Assessments.assessments_list.get(i)!=null && assessments_condition0.get(i).equals("not done") && Assessments.assessments_list.get(i).getIs_assignment()==false){

                System.out.println("ID: " + ctr + ", Question: " + Assessments.assessments_list.get(i).getProb_statement());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            }
            
        }

        System.out.println();


        System.out.print("Enter ID of assessment to submit: ");
        int idd = Integer.parseInt(sc.nextLine());
        String ques = map.get(idd);

        for (int ii=0 ; ii<Assessments.assessments_list.size() ; ii++){

            if (Assessments.assessments_list.get(ii)!=null && ques.equals(Assessments.assessments_list.get(ii).getProb_statement()) && Assessments.assessments_list.get(ii).getIs_assignment()==true){

                System.out.print("Enter filename of assignment: ");

                String filename = sc.nextLine();


                int check = 0;

                int len = filename.length();

                if (len<4){
                    System.out.println();
                    System.out.println("Wrong file format.");
                    System.out.println();
                    return;
                }

                String last4 = filename.substring(len-4, len);

                if (last4.equals(".zip")){
                    check = 1;
                }

                if (check==1){

                    assessments_condition0.set(ii, "done");
                    submissions0.set(ii, filename);
                    System.out.println();

                } else {

                    System.out.println("Wrong file format.");

                }
            } else if (Assessments.assessments_list.get(ii)!=null && ques.equals(Assessments.assessments_list.get(ii).getProb_statement()) && Assessments.assessments_list.get(ii).getIs_assignment()==false) {

                System.out.print("Question: " + Assessments.assessments_list.get(ii).getProb_statement());
                System.out.println();
                System.out.print("Enter answer: ");

                String answer = sc.nextLine();

                assessments_condition0.set(ii, "done");
                submissions0.set(ii, answer);
                System.out.println();

                
            }
        }    
    }


    public void student1_submit_assessments(int id) {

        if (Assessments.assessments_list.size()==0){

            System.out.println();
            System.out.println("No assessment given.");
            System.out.println();
            return;

        }

        System.out.println();

        boolean assessment_there_to_be_solved = true;

        if (!assessments_condition1.contains("not done")){
            assessment_there_to_be_solved = false;
        }

        if (assessment_there_to_be_solved==false){
            System.out.println();
            System.out.println("No pending assignments.");
            System.out.println();
            return;
        }

        System.out.println("Pending assessments");
        System.out.println();

        HashMap<Integer, String> map = new HashMap<>();

        int ctr = 0;

        for (int i = 0 ; i<total ; i++){

            if (Assessments.assessments_list.get(i)!=null && assessments_condition1.get(i).equals("not done") && Assessments.assessments_list.get(i).getIs_assignment()==true){

                System.out.println("ID: " + ctr + ", Assignment: " + Assessments.assessments_list.get(i).getProb_statement() + ", Max Marks: " + Assessments.assessments_list.get(i).getAssign_marks());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            } else if (Assessments.assessments_list.get(i)!=null && assessments_condition1.get(i).equals("not done") && Assessments.assessments_list.get(i).getIs_assignment()==false){

                System.out.println("ID: " + ctr + ", Question: " + Assessments.assessments_list.get(i).getProb_statement());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            }
            
        }

        System.out.println();


        System.out.print("Enter ID of assessment to submit: ");
        int idd = Integer.parseInt(sc.nextLine());
        String ques = map.get(idd);

        for (int i=0 ; i<Assessments.assessments_list.size() ; i++){

            if (Assessments.assessments_list.get(i)!=null && ques.equals(Assessments.assessments_list.get(i).getProb_statement()) && Assessments.assessments_list.get(i).getIs_assignment()==true){

                System.out.print("Enter filename of assignment: ");

                String filename = sc.nextLine();


                int check = 0;

                int len = filename.length();

                if (len<4){
                    System.out.println();
                    System.out.println("Wrong file format.");
                    System.out.println();
                    return;
                }

                String last4 = filename.substring(len-4, len);

                if (last4.equals(".zip")){
                    check = 1;
                }

                if (check==1){

                    assessments_condition1.set(i, "done");
                    submissions1.set(i, filename);
                    System.out.println();

                } else {

                    System.out.println("Wrong file format.");

                }
            } else if (Assessments.assessments_list.get(i)!=null && ques.equals(Assessments.assessments_list.get(i).getProb_statement()) && Assessments.assessments_list.get(i).getIs_assignment()==false) {

                System.out.print("Question: " + Assessments.assessments_list.get(i).getProb_statement());
                System.out.println();
                System.out.print("Enter answer: ");

                String answer = sc.nextLine();

                assessments_condition1.set(i, "done");
                submissions1.set(i, answer);
                System.out.println();

                
            }
        }    
    }


    public void student2_submit_assessments(int id) {

        if (Assessments.assessments_list.size()==0){

            System.out.println();
            System.out.println("No assessment given.");
            System.out.println();
            return;

        }

        System.out.println();

        boolean assessment_there_to_be_solved = true;

        if (!assessments_condition2.contains("not done")){
            assessment_there_to_be_solved = false;
        }

        if (assessment_there_to_be_solved==false){
            System.out.println();
            System.out.println("No pending assignments.");
            System.out.println();
            return;
        }

        System.out.println("Pending assessments");
        System.out.println();

        HashMap<Integer, String> map = new HashMap<>();

        int ctr = 0;

        for (int i = 0 ; i<total ; i++){

            if (Assessments.assessments_list.get(i)!=null && assessments_condition2.get(i).equals("not done") && Assessments.assessments_list.get(i).getIs_assignment()==true){

                System.out.println("ID: " + ctr + ", Assignment: " + Assessments.assessments_list.get(i).getProb_statement() + ", Max Marks: " + Assessments.assessments_list.get(i).getAssign_marks());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            } else if (Assessments.assessments_list.get(i)!=null && assessments_condition2.get(i).equals("not done") && Assessments.assessments_list.get(i).getIs_assignment()==false){

                System.out.println("ID: " + ctr + ", Question: " + Assessments.assessments_list.get(i).getProb_statement());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            }
            
        }

        System.out.println();


        System.out.print("Enter ID of assessment to submit: ");
        int idd = Integer.parseInt(sc.nextLine());
        String ques = map.get(idd);

        for (int i=0 ; i<Assessments.assessments_list.size() ; i++){

            if (Assessments.assessments_list.get(i)!=null && ques.equals(Assessments.assessments_list.get(i).getProb_statement()) && Assessments.assessments_list.get(i).getIs_assignment()==true){

                System.out.print("Enter filename of assignment: ");

                String filename = sc.nextLine();


                int check = 0;

                int len = filename.length();

                if (len<4){
                    System.out.println();
                    System.out.println("Wrong file format.");
                    System.out.println();
                    return;
                }

                String last4 = filename.substring(len-4, len);

                if (last4.equals(".zip")){
                    check = 1;
                }

                if (check==1){

                    assessments_condition2.set(i, "done");
                    submissions2.set(i, filename);
                    System.out.println();

                } else {

                    System.out.println("Wrong file format.");

                }
            } else if (Assessments.assessments_list.get(i)!=null && ques.equals(Assessments.assessments_list.get(i).getProb_statement()) && Assessments.assessments_list.get(i).getIs_assignment()==false) {

                System.out.print("Question: " + Assessments.assessments_list.get(i).getProb_statement());
                System.out.println();
                System.out.print("Enter answer: ");

                String answer = sc.nextLine();

                assessments_condition2.set(i, "done");
                submissions2.set(i, answer);
                System.out.println();

                
            }
        }    
    }
}
