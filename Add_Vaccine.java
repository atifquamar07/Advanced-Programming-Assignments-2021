import java.util.ArrayList;

public class Add_Vaccine {
    
    String vaccine_name;
    int no_of_doses;
    int gap;

    Add_Vaccine(String vaccine_name, int no_of_doses, int gap){

        this.vaccine_name = vaccine_name;
        this.no_of_doses = no_of_doses;
        this.gap = gap;

    }

    static ArrayList<Add_Vaccine> vaccines_list = new ArrayList<>();

}
