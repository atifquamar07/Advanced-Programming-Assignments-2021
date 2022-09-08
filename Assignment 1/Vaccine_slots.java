import java.util.*;

public class Vaccine_slots {
    
    int hospital_id;
    int day;
    int quant;
    String vaccine;
    String name_of_hospital;

    Vaccine_slots(int hospital_id, int day, int quant, String vaccine, String name_of_hospital){

        this.hospital_id = hospital_id;
        this.day = day;
        this.quant = quant;
        this.vaccine = vaccine;
        this.name_of_hospital = name_of_hospital;

    }

    static ArrayList<Vaccine_slots> slots_list = new ArrayList<>();

}
