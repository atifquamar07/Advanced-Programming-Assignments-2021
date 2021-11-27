import java.util.*;

class Driver_Code {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        System.out.println("--------------------------------------------------");
        System.out.println("          WELCOME TO LIBRARY");
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.print("Enter number of books you want to keep in the library: ");

        int n = Integer.parseInt(sc.nextLine());
        System.out.println();

        System.out.print("Enter number of racks you want to have in the library: ");

        int k = Integer.parseInt(sc.nextLine());
        System.out.println();

        for (int i = 0 ; i<n ; i++){

            System.out.print("Enter title of the book: ");
            String s = sc.nextLine();

            System.out.print("Enter ISBN of the book: ");
            int isbn = Integer.parseInt(sc.nextLine());

            System.out.print("Enter barcode of the book: ");
            int bar = Integer.parseInt(sc.nextLine());

            System.out.println();

            Books_Storage obj = new Books_Storage(s, isbn, bar);

            Books_Storage.store.add(obj);

        }

        

        Collections.sort(Books_Storage.store, Books_Storage.titleComparator);

        int ctr = 0;

        ArrayList<Books_Storage> temp = new ArrayList<>();
        ArrayList<Books_Storage> final_temp = new ArrayList<>();

        while (ctr<Books_Storage.store.size()) {

            String x = Books_Storage.store.get(ctr).getTitle();

            int start = ctr;

            while (ctr<Books_Storage.store.size() && Books_Storage.store.get(ctr).getTitle().equals(x)){

                ctr+=1;
                temp.add(Books_Storage.store.get(ctr-1));
                
            }

            if (temp.size()!=0){

                Collections.sort(temp, Books_Storage.isbnComparator);

                int q = 0;

                for (int j = start ; j<ctr ; j++) {

                    Books_Storage.store.set(j, temp.get(q));    
                    q++;    

                }

                temp.clear();

            } else {

                continue;

            }
            

        }

        int ctr2 = 0;

        while (ctr2<Books_Storage.store.size()) {

            String xx = Books_Storage.store.get(ctr2).getTitle();
            int yy = Books_Storage.store.get(ctr2).getIsb();

            int start2 = ctr2;

            while (ctr2<Books_Storage.store.size() && Books_Storage.store.get(ctr2).getTitle().equals(xx) && Books_Storage.store.get(ctr2).getIsb()==yy ){

                ctr2+=1;
                final_temp.add(Books_Storage.store.get(ctr2-1));
                
            }

            if (final_temp.size()!=0){

                Collections.sort(final_temp, Books_Storage.barComparator);

                int t = 0;

                for (int j = start2 ; j<ctr2 ; j++) {

                    Books_Storage.store.set(j, final_temp.get(t));
                    t++;

                }

                final_temp.clear();

            } else {

                continue;

            }
            

        }

        int books_in_each_rack = n/k;

        int counter = 0;

        System.out.println("-------------------------------------------------");
        System.out.println("THE BOOKS ARE SORTED IN THE FOLLOWING MANNER.");
        System.out.println("-------------------------------------------------");

        for (int i = 0 ; i<k ; i++){

            System.out.println();

            System.out.println("Books in rack no " + i + ": ");
            System.out.println();

            for (int j = 0 ; j<books_in_each_rack ; j++){

                System.out.println("S.no. " + counter + "       " + "Title: " + Books_Storage.store.get(counter).getTitle() + "       " + "ISBN Code: " + Books_Storage.store.get(counter).getIsb() + "       " + "Barcode: " + Books_Storage.store.get(counter).getBarcode());
                counter+=1;

            }    


        }

        System.out.println();
        System.out.println("THANK YOU");
        System.out.println();
        

       

    }
}
