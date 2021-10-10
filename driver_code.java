import java.util.*;

public class driver_code {

    public static void main(String[] args) {

        System.out.println("CoWin Portal initialized....");
        System.out.println("-----------------------------");

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add Vaccine\n2. Register Hospital \n3. Register Citizen \n4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination \n6. List all slots for a hospital \n7. Check Vaccination Status");
            System.out.println("8. Exit");

            System.out.println("-------------------------");

            

            System.out.print("Enter the option no you want to select: ");
            int option = sc.nextInt();

            

            if (option == 1) {

                System.out.print("Enter Vaccine Name: ");
                String vac = sc.next();

                System.out.print("Enter no of doses: ");
                int doses = sc.nextInt();

                if (doses == 0){

                    System.out.println("Doses of a vaccine cannot be zero. ");
                    continue;

                } else if (doses == 1){

                    Add_Vaccine obj = new Add_Vaccine(vac, doses, 0);

                    Add_Vaccine.vaccines_list.add(obj);

                    System.out.println();
                    System.out.println();

                    System.out.println("Vaccine Name: " + obj.vaccine_name);
                    System.out.println("Number of Doses: " + obj.no_of_doses);
                    System.out.println("Gap Between Doses: " + obj.gap);
                    System.out.println("-----------------------");

                } else {

                    System.out.print("Enter gap between doses: ");
                    int gap = sc.nextInt();

                    Add_Vaccine obj = new Add_Vaccine(vac, doses, gap);

                    Add_Vaccine.vaccines_list.add(obj);

                    System.out.println();
                    System.out.println();

                    System.out.println("Vaccine Name: " + obj.vaccine_name);
                    System.out.println("Number of Doses: " + obj.no_of_doses);
                    System.out.println("Gap Between Doses: " + obj.gap);
                    System.out.println("-----------------------");

                }


            } else if (option == 2) {

                System.out.print("Enter Hospital Name: ");
                String hos_name = sc.next();

                System.out.print("Enter pincode: ");
                int pincode = sc.nextInt();

                int id = Register_Hospital.generateID();

                Register_Hospital obj = new Register_Hospital(hos_name, pincode, id);
                Register_Hospital.hospital_list.add(obj);

                System.out.println();
                System.out.println();

                System.out.println("Hospital Name: " + obj.hospital_name);
                System.out.println("Pincode: " + obj.pincode);
                System.out.println("Unique ID: " + obj.id);
                System.out.println("--------------------------");

            }

            else if (option == 3) {

                System.out.print("Enter Citizen Name: ");
                String name = sc.next();

                System.out.print("Enter age: ");
                int age = sc.nextInt();

                System.out.print("Enter Unique ID: ");
                long id = sc.nextLong();

                System.out.println();

                Register_Citizen obj = new Register_Citizen(name, age, id);

                if (age >= 18) {

                    Register_Citizen.records_citizens.add(obj);
                    System.out.println("Citizen Name: " + obj.citizen_name);
                    System.out.println("Age: " + obj.age);
                    System.out.println("Unique ID: " + obj.id);
                    System.out.println("-----------------------");

                } else {

                    System.out.println("Citizen Name: " + obj.citizen_name);
                    System.out.println("Age: " + obj.age);
                    System.out.println("Unique ID: " + obj.id);
                    System.out.println();
                    System.out.println("Only above age of 18 years are allowed.");
                    System.out.println("-----------------------");

                }

            }

            else if (option == 4) {

                System.out.print("Enter Hospital ID: ");
                int idx = sc.nextInt();

                boolean nn = false;
                for (int z = 0 ; z<Register_Hospital.hospital_list.size() ; z++){

                    if (Register_Hospital.hospital_list.get(z).id == idx){
                        nn = true;
                    }
                }

                if (nn==false){

                    System.out.println("Entered Hospital ID does not exist in our database.");
                    continue;

                }
                String namee = "";

                for (int ll = 0; ll < Register_Hospital.hospital_list.size(); ll++) {

                    if (idx == Register_Hospital.hospital_list.get(ll).id) {
                        namee = Register_Hospital.hospital_list.get(ll).hospital_name;
                    }
                }

                System.out.print("Enter no of slots to be added: ");
                int slots = sc.nextInt();

                for (int i = 0; i < slots; i++) {

                    System.out.print("Enter Day No: ");
                    int day_no = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.println();

                    System.out.println("Select Vaccine");
                    int len = Add_Vaccine.vaccines_list.size();

                    for (int j = 0; j < len; j++) {
                        System.out.println(j + ". " + Add_Vaccine.vaccines_list.get(j).vaccine_name);
                    }

                    System.out.print("Select option no: ");
                    int opt = sc.nextInt();
                    System.out.println();

                    String vac = Add_Vaccine.vaccines_list.get(opt).vaccine_name;

                    Vaccine_slots slot = new Vaccine_slots(idx, day_no, quantity, vac, namee);

                    Vaccine_slots.slots_list.add(slot);

                    System.out.println("Slot added by Hospital " + idx + " for Day: " + day_no + " Available Quantity: "
                            + quantity + " of Vaccine " + vac);

                    System.out.println();
                
                }

            }

            else if (option == 5) {

                System.out.print("Enter patient unique ID: ");
                long id_booking = sc.nextLong();

                boolean nn = false;
                for (int z = 0 ; z<Register_Citizen.records_citizens.size() ; z++){

                    if (Register_Citizen.records_citizens.get(z).id == id_booking){
                        nn = true;
                    }
                }

                if (nn==false){

                    System.out.println("Entered Unique ID does not exist in our database.");
                    continue;

                }

                int checker = 0;

                for (int i = 0 ; i<Register_Citizen.records_citizens.size() ; i++){

                    if (id_booking == Register_Citizen.records_citizens.get(i).id && Register_Citizen.records_citizens.get(i).is_fully_Vaccinated){

                        System.out.println();
                        System.out.println("Citizen with unique ID: " + id_booking + ", is already fully vaccinated.");
                        System.out.println();
                        checker = 1;

                    }

                }

                if (checker==1){
                    continue;
                }

                System.out.println();

                System.out.println("1. Search by area");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.println("---------------");

                System.out.print("Enter option: ");

                int o = sc.nextInt();

                if (o == 1) {

                    System.out.print("Enter pincode: ");
                    int pin = sc.nextInt();
                    System.out.println();

                    int xx = 0;

                    for (int i = 0; i < Register_Hospital.hospital_list.size(); i++) {

                        if (Register_Hospital.hospital_list.get(i).pincode == pin) {

                            System.out.println(Register_Hospital.hospital_list.get(i).id + " " + Register_Hospital.hospital_list.get(i).hospital_name);
                            xx = 1;

                        }

                    }

                    System.out.println();

                    if (xx == 0) {

                        System.out.println("There is no nearby hospitals with that pincode.");
                        System.out.println();
                    }

                    System.out.println("Enter Hospital ID: ");
                    int idd = sc.nextInt();

                    boolean nnn = false;
                    for (int z = 0 ; z<Register_Hospital.hospital_list.size() ; z++){

                        if (Register_Hospital.hospital_list.get(z).id == idd){
                            nnn = true;
                        }

                    }

                    if (nnn==false){

                        System.out.println();
                        System.out.println("Entered Hospital ID does not exist in our database.");
                        System.out.println();
                        continue;

                    }

                    System.out.println();

                    int ctr = 0;

                    HashMap<Integer, Integer> map = new HashMap<>();

                    int yyy = -1;

                    for (int j = 0; j < Register_Citizen.records_citizens.size(); j++) {

                        if (Register_Citizen.records_citizens.get(j).id == id_booking && Register_Citizen.records_citizens.get(j).next_dose != 0) {
                            
                            yyy = Register_Citizen.records_citizens.get(j).next_dose;

                        }

                    }

                    for (int i = 0; i < Vaccine_slots.slots_list.size(); i++) {

                        if (idd == Vaccine_slots.slots_list.get(i).hospital_id && yyy != (-1)) {

                            if (Vaccine_slots.slots_list.get(i).day == yyy) {

                                System.out.println(ctr + " --> Day: " + Vaccine_slots.slots_list.get(i).day+ " , Available Quantity: " + Vaccine_slots.slots_list.get(i).quant + " , Vaccine: " + Vaccine_slots.slots_list.get(i).vaccine);
                                map.put(ctr, i);
                                ctr += 1;

                            }

                            } else if (idd == Vaccine_slots.slots_list.get(i).hospital_id && yyy == (-1)) {

                                System.out.println(ctr + " --> Day: " + Vaccine_slots.slots_list.get(i).day + " , Available Quantity: " + Vaccine_slots.slots_list.get(i).quant + " , Vaccine: " + Vaccine_slots.slots_list.get(i).vaccine);
                                map.put(ctr, i);
                                ctr += 1;

                            }

                    }

                    if (ctr == 0) {
                        System.out.println();
                        System.out.println("No slots available.");
                        System.out.println();
                        continue;
                    }

                    System.out.println();

                    System.out.print("Choose slot: ");
                    int op = sc.nextInt();
                    System.out.println();

                    Integer itr = map.get(op);

                    String vac_given = Vaccine_slots.slots_list.get(itr).vaccine;
                    int day_vac_given = Vaccine_slots.slots_list.get(itr).day;

                    for (int i = 0 ; i<Register_Citizen.records_citizens.size() ; i++){

                        if (id_booking == Register_Citizen.records_citizens.get(i).id && Register_Citizen.records_citizens.get(i).is_partially_Vaccinated && !vac_given.equals(Register_Citizen.records_citizens.get(i).vaccine_given)){

                            System.out.println();
                            System.out.println("The person is already vaccinated once with " + Register_Citizen.records_citizens.get(i).vaccine_given + ". He cannot be vaccinated with " + vac_given);
                            System.out.println();
                            continue;

                        }

                    }

                    Vaccine_slots.slots_list.get(itr).quant -= 1;

                    for (int l = 0; l < Add_Vaccine.vaccines_list.size(); l++) {

                        if (vac_given == Add_Vaccine.vaccines_list.get(l).vaccine_name) {

                            day_vac_given += Add_Vaccine.vaccines_list.get(l).gap;

                        }

                    }

                    String namm = "";

                    int check = 0;

                    for(int p = 0 ; p<Add_Vaccine.vaccines_list.size() ; p++){

                        if (vac_given.equals(Add_Vaccine.vaccines_list.get(p).vaccine_name)){

                            if (Add_Vaccine.vaccines_list.get(p).no_of_doses>0){

                                check=1;

                            }

                        }

                    }

                    int dosimeter = 0;

                    for (int k = 0; k < Register_Citizen.records_citizens.size(); k++) {

                        if ((Register_Citizen.records_citizens.get(k).id == id_booking) && Register_Citizen.records_citizens.get(k).is_fully_Vaccinated == false) {

                            Register_Citizen.records_citizens.get(k).vaccine_given = vac_given;
                            Register_Citizen.records_citizens.get(k).doses_given += 1;
                            dosimeter = Register_Citizen.records_citizens.get(k).doses_given;

                            if (check==1){
                                Register_Citizen.records_citizens.get(k).next_dose = day_vac_given;
                            }
                            
                            namm = Register_Citizen.records_citizens.get(k).citizen_name;
                            Register_Citizen.records_citizens.get(k).is_partially_Vaccinated = true;

                        }

                    }
                    
                    boolean jod = false;

                    for (int l = 0 ; l<Add_Vaccine.vaccines_list.size() ; l++){

                        if (vac_given.equals(Add_Vaccine.vaccines_list.get(l).vaccine_name) && dosimeter == Add_Vaccine.vaccines_list.get(l).no_of_doses) {

                            jod = true;

                        }
                    
                    }

                    for (int ll = 0 ; ll<Register_Citizen.records_citizens.size() ; ll++){

                        if (id_booking == Register_Citizen.records_citizens.get(ll).id && jod) {

                            Register_Citizen.records_citizens.get(ll).is_fully_Vaccinated = true;

                        }
                    
                    }

                    System.out.println(namm + " vaccinated with " + vac_given);
                    System.out.println("---------------------------");


                } else if (o == 2) {

                    System.out.print("Enter Vaccine Name: ");
                    String vvv = sc.next();
                    System.out.println();

                    for (int m = 0; m < Vaccine_slots.slots_list.size(); m++) {

                        if (vvv.equals(Vaccine_slots.slots_list.get(m).vaccine) && Vaccine_slots.slots_list.get(m).quant > 0) {

                            System.out.println(Vaccine_slots.slots_list.get(m).hospital_id + " " + Vaccine_slots.slots_list.get(m).name_of_hospital);

                        }

                    }

                    System.out.println();

                    System.out.print("Enter Hospital ID: ");
                    int hos_id = sc.nextInt();

                    System.out.println();

                    HashMap<Integer, Integer> map = new HashMap<>();

                    int yyy = -1;
                    int ctr = 0;

                    for (int j = 0; j < Register_Citizen.records_citizens.size(); j++) {

                        if (Register_Citizen.records_citizens.get(j).id == id_booking && Register_Citizen.records_citizens.get(j).next_dose != 0) {
                            
                            yyy = Register_Citizen.records_citizens.get(j).next_dose;

                        }

                    }

                    for (int i = 0; i < Vaccine_slots.slots_list.size(); i++) {

                        if (hos_id == Vaccine_slots.slots_list.get(i).hospital_id && vvv.equals(Vaccine_slots.slots_list.get(i).vaccine) && yyy != (-1)) {

                            if (Vaccine_slots.slots_list.get(i).day == yyy) {

                                System.out.println(ctr + " --> Day: " + Vaccine_slots.slots_list.get(i).day+ " , Available Quantity: " + Vaccine_slots.slots_list.get(i).quant + " , Vaccine: " + Vaccine_slots.slots_list.get(i).vaccine);
                                map.put(ctr, i);
                                ctr += 1;

                            }

                            } else if (hos_id == Vaccine_slots.slots_list.get(i).hospital_id && vvv.equals(Vaccine_slots.slots_list.get(i).vaccine) && yyy == (-1)) {

                                System.out.println(ctr + " --> Day: " + Vaccine_slots.slots_list.get(i).day + " , Available Quantity: " + Vaccine_slots.slots_list.get(i).quant + " , Vaccine: " + Vaccine_slots.slots_list.get(i).vaccine);
                                map.put(ctr, i);
                                ctr += 1;

                            }

                    }

                    if (ctr == 0) {
                    
                        System.out.println("No slots available.");
                        System.out.println();
                        continue;
                    }

                    System.out.print("Choose slot: ");
                    int op = sc.nextInt();
                    System.out.println();

                    Integer itr = map.get(op);

                    String vac_given = Vaccine_slots.slots_list.get(itr).vaccine;
                    int day_vac_given = Vaccine_slots.slots_list.get(itr).day;

                    for (int i = 0 ; i<Register_Citizen.records_citizens.size() ; i++){

                        if (id_booking == Register_Citizen.records_citizens.get(i).id && Register_Citizen.records_citizens.get(i).is_partially_Vaccinated && !vac_given.equals(Register_Citizen.records_citizens.get(i).vaccine_given)){

                            System.out.println("The person is already vaccinated once with " + Register_Citizen.records_citizens.get(i).vaccine_given + ". He cannot be vaccinated with " + vac_given);
                            continue;
                            
                        }

                    }

                    Vaccine_slots.slots_list.get(itr).quant -= 1;

                    for (int l = 0; l < Add_Vaccine.vaccines_list.size(); l++) {

                        if (vac_given.equals(Add_Vaccine.vaccines_list.get(l).vaccine_name)) {

                            day_vac_given += Add_Vaccine.vaccines_list.get(l).gap;

                        }

                    }

                    String nam = "";

                    int check = 0;

                    for(int p = 0 ; p<Add_Vaccine.vaccines_list.size() ; p++){

                        if (vac_given.equals(Add_Vaccine.vaccines_list.get(p).vaccine_name)){

                            if (Add_Vaccine.vaccines_list.get(p).no_of_doses>0){

                                check=1;

                            }

                        }

                    }

                    int dosimeter = 0;

                    for (int k = 0; k < Register_Citizen.records_citizens.size(); k++) {

                        if ((Register_Citizen.records_citizens.get(k).id == id_booking) && Register_Citizen.records_citizens.get(k).is_fully_Vaccinated == false) {

                            Register_Citizen.records_citizens.get(k).vaccine_given = vac_given;
                            Register_Citizen.records_citizens.get(k).doses_given += 1;
                            dosimeter = Register_Citizen.records_citizens.get(k).doses_given;

                            if (check==1){
                                Register_Citizen.records_citizens.get(k).next_dose = day_vac_given;
                            }
                            
                            nam = Register_Citizen.records_citizens.get(k).citizen_name;
                            Register_Citizen.records_citizens.get(k).is_partially_Vaccinated = true;

                        }

                    }
                    
                    boolean jod = false;

                    for (int l = 0 ; l<Add_Vaccine.vaccines_list.size() ; l++){

                        if (vac_given.equals(Add_Vaccine.vaccines_list.get(l).vaccine_name) && dosimeter == Add_Vaccine.vaccines_list.get(l).no_of_doses) {

                            jod = true;

                        }
                    
                    }

                    for (int ll = 0 ; ll<Register_Citizen.records_citizens.size() ; ll++){

                        if (id_booking == Register_Citizen.records_citizens.get(ll).id && jod) {

                            Register_Citizen.records_citizens.get(ll).is_fully_Vaccinated = true;

                        }
                    
                    }

                    System.out.println(nam + " vaccinated with " + vac_given);
                    System.out.println("---------------------------");

                } else if ( o==3 ){

                    continue;

                }

            }

            else if (option == 6) {

                System.out.print("Enter Hospital ID: ");
                int iddd = sc.nextInt();

                boolean nn = false;
                for (int z = 0 ; z<Register_Hospital.hospital_list.size() ; z++){

                    if (Register_Hospital.hospital_list.get(z).id == iddd){
                        nn = true;
                    }
                }

                if (nn==false){

                    System.out.println("Entered Hospital ID does not exist in our database.");
                    continue;

                }

                System.out.println();

                for (int m = 0; m < Vaccine_slots.slots_list.size(); m++) {

                    if (iddd == Vaccine_slots.slots_list.get(m).hospital_id) {

                        System.out.println("Day: " + Vaccine_slots.slots_list.get(m).day + ", Vaccine: "
                                + Vaccine_slots.slots_list.get(m).vaccine + " Available, Quantity: "
                                + Vaccine_slots.slots_list.get(m).quant);

                    }

                }

                System.out.println("---------------------------");

            }

            else if (option == 7) {

                System.out.print("Enter Patient ID: ");
                long pat_id = sc.nextLong();

                boolean nn = false;
                for (int z = 0 ; z<Register_Citizen.records_citizens.size() ; z++){

                    if (Register_Citizen.records_citizens.get(z).id == pat_id){
                        nn = true;
                    }
                }

                if (nn==false){

                    System.out.println("Entered Unique ID does not exist in our database.");
                    continue;

                }
                System.out.println();

                for (int i = 0; i < Register_Citizen.records_citizens.size(); i++) {

                    if (Register_Citizen.records_citizens.get(i).id == pat_id) {

                        if (Register_Citizen.records_citizens.get(i).is_fully_Vaccinated) {

                            System.out.println("FULLY VACCINATED.");
                            System.out.println("Vaccine given: " + Register_Citizen.records_citizens.get(i).vaccine_given);
                            System.out.println("No of doses given: " + Register_Citizen.records_citizens.get(i).doses_given);
                            System.err.println();
                            System.out.println("------------------------");

                        } else if (Register_Citizen.records_citizens.get(i).is_partially_Vaccinated) {

                            System.out.println("PARTIALLY VACCINATED.");
                            System.out.println("Vaccine given: " + Register_Citizen.records_citizens.get(i).vaccine_given);
                            System.out.println("No of doses given: " + Register_Citizen.records_citizens.get(i).doses_given);
                            System.out.println("Next dose due date: " + Register_Citizen.records_citizens.get(i).next_dose);
                            System.err.println();
                            System.out.println("------------------------");

                        } else if (!Register_Citizen.records_citizens.get(i).is_fully_Vaccinated && !Register_Citizen.records_citizens.get(i).is_partially_Vaccinated) {

                            System.out.println("CITIZEN REGISTERED");
                            System.err.println();
                            System.out.println("------------------------");

                        }

                    }

                }

            }

            else if (option == 8) {

                System.out.println("------------------------------");
                System.out.println("Thank You, Please visit again");
                System.out.println("------------------------------");

                break;
            }

        }
        sc.close();
    }
}