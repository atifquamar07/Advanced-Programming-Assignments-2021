import java.util.ArrayList;

public class Register_Citizen {

    String citizen_name;
    int age;
    long id;
    String vaccine_given;
    int doses_given;
    int next_dose;
    boolean is_partially_Vaccinated;
    boolean is_fully_Vaccinated;

    Register_Citizen(String citizen_name, Integer age, long id) {

        this.citizen_name = citizen_name;
        this.age = age;
        this.id = id;
        this.vaccine_given = null;
        this.doses_given = 0;
        this.next_dose = 0;
        this.is_partially_Vaccinated = false;
        this.is_fully_Vaccinated = false;
            
    }

    static ArrayList<Register_Citizen> records_citizens = new ArrayList<>();

}
