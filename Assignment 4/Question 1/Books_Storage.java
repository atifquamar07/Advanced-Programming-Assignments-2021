import java.util.*;

class Books_Storage {

    private final String title;

    private final int isb;

    private final int barcode;

    static ArrayList<Books_Storage> store = new ArrayList<>();

    Books_Storage (String title, int isb, int barcode) {

        this.title = title;
        this.isb = isb;
        this.barcode = barcode;

    }

    public String getTitle() {
        return this.title;
    }

    public int getIsb() {
        return this.isb;
    }

    public int getBarcode() {
        return this.barcode;
    }


    @Override
    public String toString(){
         
        return getTitle()+" "+getIsb()+" "+getBarcode();

    } 


    public static Comparator<Books_Storage> titleComparator = new Comparator<Books_Storage>() {

        public int compare(Books_Storage b1, Books_Storage b2) {

            String title1 = b1.getTitle().toUpperCase();
            String title2 = b2.getTitle().toUpperCase();

            return title1.compareTo(title2);

        }

    };

    
    public static Comparator<Books_Storage> isbnComparator = new Comparator<Books_Storage>() {

        public int compare(Books_Storage b1, Books_Storage b2) {

            int isbn1 = b1.getIsb();
            int isbn2 = b2.getIsb();

            return  (isbn1 - isbn2);

        }
        
    };

    public static Comparator<Books_Storage> barComparator = new Comparator<Books_Storage>() {

        public int compare(Books_Storage b1, Books_Storage b2) {

            int bar1 = b1.getBarcode();
            int bar2 = b2.getBarcode();

            return  (bar1 - bar2);

        }
        
    };


    
}
