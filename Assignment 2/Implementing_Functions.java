import java.util.*;

public class Implementing_Functions implements Functions {

    private String instructor_name1;
    private String instructor_name2;

    Scanner sc = new Scanner(System.in);

    public void add_class_material(int instructor_no) {

        if (instructor_no == 0){
            instructor_name1 = "I0";
        } else {
            instructor_name1 = "I1";
        }
        
        System.out.println("1. Add lecture slide");
        System.out.println("2. Add lecture video");
        System.out.println();

        System.out.print("Enter option: ");

        int opt = Integer.parseInt(sc.nextLine());
       
        System.out.println();

        if (opt==1){

            System.out.print("Enter topic of slides: ");
            String topic = sc.nextLine();

            System.out.print("Enter no of slides: ");
            int no_of_slides = Integer.parseInt(sc.nextLine());

            System.out.println("Enter content of slides");

            ArrayList<String> content_list = new ArrayList<>();
            
            for(int i = 0 ; i<no_of_slides ; i++){

                System.out.print("Enter content of slide " + (i+1) + ": ");
                String content = sc.nextLine();
                content_list.add(content);

            }

            long millis=System.currentTimeMillis();  
            java.util.Date time = new java.util.Date(millis); 

            Class_Material obj = new Class_Material(topic, no_of_slides, content_list, time, instructor_name1);

            Class_Material.lecture_slides.add(obj);

            
            

        } else {

            System.out.print("Enter topic of video: ");
            String topic = sc.nextLine();

            System.out.print("Enter filename of video: ");
            String filename = sc.nextLine();

            long millis=System.currentTimeMillis();  
            java.util.Date time1 = new java.util.Date(millis);

            int check = 0;

            int len = filename.length();

            if (len<4){
                System.out.println();
                System.out.println("Wrong file format.");
                System.out.println();
                return;
            }

            String last4 = filename.substring(len-4, len);

            if (last4.equals(".mp4")){
                check = 1;
            }

            if (check==1){

                Class_Material obj = new Class_Material(topic, filename, time1, instructor_name1);

                Class_Material.lecture_video.add(obj);

            } else {

                System.out.println("Wrong file format.");

            }

        }
        
    }


    public void add_assessments(int instructor_no) {

        if (instructor_no == 0){
            instructor_name2 = "I0";
        } else {
            instructor_name2 = "I1";
        }
        
        System.out.println("1. Add assignment");
        System.out.println("2. Add quiz");

        System.out.println();
        System.out.print("Enter option: ");

        int opt = Integer.parseInt(sc.nextLine());

        if (opt == 1){

            System.out.print("Enter problem statement: ");
            String prob = sc.nextLine();

            System.out.print("Enter max marks: ");
            int marks = Integer.parseInt(sc.nextLine());
           

            Assessments obj = new Assessments(prob, instructor_name2, marks, true);

            Assessments.assessments_list.add(obj);

            Student_info.assessments_condition0.add("not done");
            Student_info.grades0.add(-1);
            Student_info.grades_by0.add(-1);
            Student_info.submissions0.add("-1");

            Student_info.assessments_condition1.add("not done");
            Student_info.grades1.add(-1);
            Student_info.grades_by1.add(-1);
            Student_info.submissions1.add("-1");

            Student_info.assessments_condition2.add("not done");
            Student_info.grades2.add(-1);
            Student_info.grades_by2.add(-1);
            Student_info.submissions2.add("-1");

        } else {

            System.out.print("Enter quiz question: ");
            String ques = sc.nextLine();

            Assessments obj = new Assessments(ques, instructor_name2, 1, false);

            Assessments.assessments_list.add(obj);

            Student_info.assessments_condition0.add("not done");
            Student_info.grades0.add(-1);
            Student_info.grades_by0.add(-1);
            Student_info.submissions0.add("-1");

            Student_info.assessments_condition1.add("not done");
            Student_info.grades1.add(-1);
            Student_info.grades_by1.add(-1);
            Student_info.submissions1.add("-1");

            Student_info.assessments_condition2.add("not done");
            Student_info.grades2.add(-1);
            Student_info.grades_by2.add(-1);
            Student_info.submissions2.add("-1");

        }
        
    }



    public void view_lecture_material() {

        System.out.println();

        if (Class_Material.lecture_slides.size()==0 && Class_Material.lecture_video.size()==0){

            System.out.println("No lecture material to show.");
            System.out.println();
            return;

        }

        for (int i = 0 ; i<Class_Material.lecture_slides.size() ; i++){

            System.out.println("Title: " + Class_Material.lecture_slides.get(i).getTopic_slide());

            for (int j = 0 ; j<Class_Material.all_slides.get(i).size() ; j++){
                
                System.out.println("Slide " + (j+1) + ": " + Class_Material.all_slides.get(i).get(j));

            }

            System.out.println("Number of slides: " + Class_Material.all_slides.size());
            System.out.println("Date of upload: " + Class_Material.lecture_slides.get(i).getTime1());
            System.out.println("Uploaded by: " + Class_Material.lecture_slides.get(i).getInstructor_name());

        }

        System.out.println();
        System.out.println();


        for (int i = 0 ; i<Class_Material.lecture_video.size() ; i++){

            System.out.println("Title of video: " + Class_Material.lecture_video.get(i).getTopic_video());
            System.out.println("Video file: " + Class_Material.lecture_video.get(i).getFilename());
            System.out.println("Date of upload: " + Class_Material.lecture_video.get(i).getTime2());
            System.out.println("Uploaded by: " + Class_Material.lecture_video.get(i).getInstructor_name_video());
            System.out.println();
            System.out.println("-------------------------------");

        }
    }



    public void view_assessments() {

        System.out.println();

        int ctr = 0;

        if (Assessments.assessments_list.size()==0){

            System.out.println("No assignments due.");

        } else {

            System.out.println("List of assignments: ");

            for (int i = 0 ; i<Assessments.assessments_list.size() ; i++){

                if (Assessments.assessments_list.get(i)!=null && Assessments.assessments_list.get(i).getIs_assignment()==true ){

                    System.out.println("ID: " + ctr + ", Assignment: " + Assessments.assessments_list.get(i).getProb_statement() + ", Max Marks: " + Assessments.assessments_list.get(i).getAssign_marks());
                    ctr+=1;

                } else if (Assessments.assessments_list.get(i)!=null && Assessments.assessments_list.get(i).getIs_assignment()==false) {

                    System.out.println("ID: " + ctr + ", Question: " + Assessments.assessments_list.get(i).getProb_statement());
                    ctr+=1;

                }
                
            }
        }

        System.out.println();

    }

    public void grade_assessments(int instructor_no) {

        if (Assessments.assessments_list.size()==0){

            System.out.println();
            System.out.println("No assessment given.");
            System.out.println();
            return;

        }

        System.out.println("List of assessments");
        System.out.println();

        HashMap<Integer, String> map = new HashMap<>();

        int ctr = 0;

        for (int i = 0 ; i<Assessments.assessments_list.size() ; i++){

            if (Assessments.assessments_list.get(i)!=null && Assessments.assessments_list.get(i).getIs_assignment()==true){

                System.out.println("ID: " + ctr + ", Assignment: " + Assessments.assessments_list.get(i).getProb_statement() + " Max Marks: " + Assessments.assessments_list.get(i).getAssign_marks());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            } else if(Assessments.assessments_list.get(i)!=null && Assessments.assessments_list.get(i).getIs_assignment()==false) {

                System.out.println("ID: " + ctr + ", Question: " + Assessments.assessments_list.get(i).getProb_statement());
                map.put(ctr, Assessments.assessments_list.get(i).getProb_statement());
                ctr+=1;

            }
        }

        System.out.println();
        System.out.print("Enter ID of assessment to view submission: ");
        int id = Integer.parseInt(sc.nextLine());


        String to_grade = map.get(id);

        int idx = -1;

        for (int i = 0; i<Assessments.assessments_list.size() ; i++){

            if (Assessments.assessments_list.get(i)!=null && to_grade.equals(Assessments.assessments_list.get(i).getProb_statement())){
                
                idx = i;

            }
        }

        int counter = 0;

        int ctrr1 = 0;
        int ctrr2 = 0;
        int ctrr3 = 0;

        int print  = 0;

        if (Student_info.assessments_condition0.size()==0){
            ctrr1 = 1;
        }
        if (Student_info.assessments_condition1.size()==0){
            ctrr2 = 1;
        }
        if (Student_info.assessments_condition2.size()==0){
            ctrr3 = 1;
        }

        if (ctrr1==1 && ctrr2==1 && ctrr3==1){
            System.out.println();
            System.out.println("No submissions yet!");
            System.out.println();
            return;
        }

        if (ctrr1==0 && Student_info.assessments_condition0.get(idx).equals("done")){

            System.out.println(counter + ". S0");
            print=1;
            counter+=1;
        }

        if (ctrr2==0 && Student_info.assessments_condition1.get(idx).equals("done")){

            System.out.println(counter + ". S1");
            print=1;
            counter+=1;
        }

        if (ctrr3==0 && Student_info.assessments_condition2.get(idx).equals("done")){

            System.out.println(counter + ". S2");
            print=1;
            counter+=1;
        }

        if (print==0){
            System.out.println();
            System.out.println("No submission yet!");
            System.out.println();
            return;
        }

        System.out.println();
        System.out.print("Enter option: ");
        int st = Integer.parseInt(sc.nextLine());
        

        if (st==0){

            int mkss = 0;

            for (int i = 0; i<Assessments.assessments_list.size() ; i++){

                if (Assessments.assessments_list.get(i)!=null && to_grade.equals(Assessments.assessments_list.get(i).getProb_statement())){
                    
                    mkss = Assessments.assessments_list.get(i).getAssign_marks();
    
                }
            }

            System.out.println("Submission: " + Student_info.submissions0.get(idx));
            System.out.println("Max marks: " + mkss);
            System.out.print("Enter marks you want to give: ");
            int mks = Integer.parseInt(sc.nextLine());
            

            Student_info.grades0.set(idx, mks);
            Student_info.grades_by0.set(idx, instructor_no);


        } else if (st==1){

            int mkss = 0;

            for (int i = 0; i<Assessments.assessments_list.size() ; i++){

                if (Assessments.assessments_list.get(i)!=null && to_grade.equals(Assessments.assessments_list.get(i).getProb_statement())){
                    
                    mkss = Assessments.assessments_list.get(i).getAssign_marks();
    
                }
            }

            System.out.println("Submission: " + Student_info.submissions1.get(idx));
            System.out.println("Max marks: " + mkss);
            System.out.print("Enter marks you want to give: ");
            int mks = Integer.parseInt(sc.nextLine());
            

            Student_info.grades1.set(idx, mks);
            Student_info.grades_by1.set(idx, instructor_no);


        } else {

            int mkss = 0;

            for (int i = 0; i<Assessments.assessments_list.size() ; i++){

                if (Assessments.assessments_list.get(i)!=null && to_grade.equals(Assessments.assessments_list.get(i).getProb_statement())){
                    
                    mkss = Assessments.assessments_list.get(i).getAssign_marks();
    
                }
            }

            System.out.println("Submission: " + Student_info.submissions2.get(idx));
            System.out.println("Max marks: " + mkss);
            System.out.print("Enter marks you want to give: ");
            int mks = Integer.parseInt(sc.nextLine());
            

            Student_info.grades2.set(idx, mks);
            Student_info.grades_by2.set(idx, instructor_no);


        }

    }



    public void close_assessments() {

        if (Assessments.assessments_list.size()==0){

            System.out.println();
            System.out.println("No assessment given.");
            System.out.println();
            return;

        }

        HashMap<Integer, String> map = new HashMap<>();

        if (Assessments.assessments_list.size()==0){

            System.out.println("No assessments to close.");

        } else {

            System.out.println("List of open assignments");
            System.out.println();

            int ctr1 = 0;
            for (int i = 0 ; i<Assessments.assessments_list.size() ; i++){

                if (Assessments.assessments_list.get(i)!=null && Assessments.assessments_list.get(i).getIs_assignment()==true){
    
                    System.out.println("ID: " + ctr1 + ", Assignment: " + Assessments.assessments_list.get(i).getProb_statement() + ", Max Marks: " + Assessments.assessments_list.get(i).getAssign_marks());
                    map.put(ctr1, Assessments.assessments_list.get(i).getProb_statement());
                    ctr1+=1;
    
                } else if(Assessments.assessments_list.get(i)!=null && Assessments.assessments_list.get(i).getIs_assignment()==false) {
    
                    System.out.println("ID: " + ctr1 + ", Question: " + Assessments.assessments_list.get(i).getProb_statement());
                    map.put(ctr1, Assessments.assessments_list.get(i).getProb_statement());
                    ctr1+=1;
    
                }
            }

        }

        System.out.println();
        System.out.print("Enter ID of assignment to close: ");
        int id = Integer.parseInt(sc.nextLine());
     

        String to_close = map.get(id);

        for (int z = 0 ; z<Assessments.assessments_list.size() ; z++){

            if (Assessments.assessments_list.get(z)!=null && to_close.equals(Assessments.assessments_list.get(z).getProb_statement())){

                if (Student_info.assessments_condition0.size()>0){

                    Student_info.assessments_condition0.set(z, "deleted");
                    Student_info.assessments_condition1.set(z, "deleted");
                    Student_info.assessments_condition2.set(z, "deleted");
                    Assessments.assessments_list.set(z, null);

                }
                
            } 

        }

        System.out.println();


    }

    public void add_comments_student(int id) {

        System.out.print("Enter comment: ");
        String comment = sc.nextLine();

        long millis=System.currentTimeMillis();  
        java.util.Date time = new java.util.Date(millis); 

        Comments.getCom().add(comment);
        Comments.getDate().add(time);
        
        if (id==0){
            Comments.getWho_wrote_com().add("S0");
        } else if (id==1) {
            Comments.getWho_wrote_com().add("S1");
        } else {
            Comments.getWho_wrote_com().add("S2");
        }

    }

    public void view_comments() {

        if (Comments.getCom().size()==0){

            System.out.println();
            System.out.println("No comments added yet.");
            System.out.println();
            return;

        }

        System.out.println();

        for (int i = 0 ; i<Comments.getCom().size() ; i++){

            System.out.println(Comments.getCom().get(i) + " - " + Comments.getWho_wrote_com().get(i));
            System.out.println(Comments.getDate().get(i));
            System.out.println();

        }

    }

    public void add_comments_instructor(int id) {

        System.out.println("Enter comment: ");
        String comment = sc.nextLine();

        long millis=System.currentTimeMillis();  
        java.util.Date time = new java.util.Date(millis); 

        Comments.getCom().add(comment);
        Comments.getDate().add(time);
        
        if (id==0){
            Comments.getWho_wrote_com().add("I0");
        } else {
            Comments.getWho_wrote_com().add("I1");
        }

    }

    public void logout() {

        System.out.println();
        System.out.println("Thank you!");
        System.out.println();

    }


    public void view_grades(int student_no) {

        if (Assessments.assessments_list.size()==0){

            System.out.println();
            System.out.println("No assessment given.");
            System.out.println();
            return;

        }

        if (student_no==0){

            System.out.println("----------------------------");
            System.out.println("Graded Assignments");
            System.out.println("----------------------------");

            for (int i = 0 ; i<Student_info.grades0.size() ; i++){

                if (Student_info.grades0.get(i)!=(-1)){

                    System.out.println("Submission: " + Student_info.submissions0.get(i));
                    System.out.println("Marks scored: " + Student_info.grades0.get(i));
                    System.out.println("Graded by: " + "I" + Student_info.grades_by0.get(i));
                    System.out.println();

                } 

            }

            System.out.println("----------------------------");
            System.out.println("Ungraded Assignments");
            System.out.println("----------------------------");

            for (int i = 0 ; i<Student_info.grades0.size() ; i++){

                if (Student_info.grades0.get(i)==(-1) && Student_info.assessments_condition0.get(i).equals("done")){

                    System.out.println("Submission: " + Student_info.submissions0.get(i));

                } 

            }

         
            System.out.println("-----------------------------");


        } else if (student_no==1){

            System.out.println("Graded Assignment");

            for (int i = 0 ; i<Student_info.grades1.size() ; i++){

                if (Student_info.grades1.get(i)!=(-1)){

                    System.out.println("Submission: " + Student_info.submissions1.get(i));
                    System.out.println("Marks scored: " + Student_info.grades1.get(i));
                    System.out.println("Graded by: " + "I" + Student_info.grades_by1.get(i));
                    System.out.println();

                } 

            }

            System.out.println("----------------------------");
            System.out.println("Ungraded Assignments");
            System.out.println("----------------------------");

            for (int i = 0 ; i<Student_info.grades1.size() ; i++){

                if (Student_info.grades1.get(i)==(-1) && Student_info.assessments_condition1.get(i).equals("done")){

                    System.out.println("Submission: " + Student_info.submissions1.get(i));

                } 

            }

            System.out.println("-----------------------------");

        } else {

            System.out.println("Graded Assignment");

            for (int i = 0 ; i<Student_info.grades2.size() ; i++){

                if (Student_info.grades2.get(i)!=(-1)){

                    System.out.println("Submission: " + Student_info.submissions2.get(i));
                    System.out.println("Marks scored: " + Student_info.grades2.get(i));
                    System.out.println("Graded by: " + "I" + Student_info.grades_by2.get(i));
                    System.out.println();

                }

            }

            System.out.println("----------------------------");
            System.out.println("Ungraded Assignments");
            System.out.println();

            for (int i = 0 ; i<Student_info.grades2.size() ; i++){

                if (Student_info.grades2.get(i)==(-1) && Student_info.assessments_condition2.get(i).equals("done")){

                    System.out.println("Submission: " + Student_info.submissions2.get(i));

                } 

            }
            System.out.println("-----------------------------");

        }
    }
}
