import java.util.*;

public class Register_Hospital{

    String hospital_name;
    int pincode;
    int id;

    Register_Hospital(String hospital_name, int pincode, int id){

        this.hospital_name = hospital_name;
        this.pincode = pincode;
        this.id = id;

    }

    static ArrayList<Register_Hospital> hospital_list = new ArrayList<>();

    public static int generateID() {
        int m = (int) Math.pow(10, 5);
        return m + new Random().nextInt(9 * m);
    }

}
