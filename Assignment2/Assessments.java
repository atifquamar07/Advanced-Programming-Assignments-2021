import java.util.*;

public class Assessments {
    
    private String prob_statement;
    private int assign_marks;
    private String instructor_name_assig;
    private boolean is_assignment;

    Assessments(String prob_statement, String instructor_name_assig, int assign_marks, boolean is_assignment){

        this.prob_statement = prob_statement;
        this.instructor_name_assig = instructor_name_assig;
        this.assign_marks = assign_marks;
        this.is_assignment = is_assignment;

    }

    static ArrayList<Assessments> assessments_list = new ArrayList<>(); 

    public String getProb_statement() {
        return this.prob_statement;
    }

    public int getAssign_marks() {
        return this.assign_marks;
    }

    public String getInstructor_name_assign() {
        return this.instructor_name_assig;
    }

    public boolean getIs_assignment() {
        return this.is_assignment;
    }

}
