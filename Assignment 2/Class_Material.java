import java.util.*;

public class Class_Material {
    
    private String topic_slide;
    private int no_of_slides;
    private Date time1;
    private String instructor_name;

    
    static ArrayList<ArrayList<String>> all_slides = new ArrayList<>();

    Class_Material (String topic_slide, int no_of_slides, ArrayList<String> slides, Date time1, String instructor_name ){

        this.topic_slide = topic_slide;
        this.no_of_slides = no_of_slides;
        this.time1 = time1;
        this.instructor_name = instructor_name;
        all_slides.add(slides);

    }

    static ArrayList<Class_Material> lecture_slides = new ArrayList<>(); 

    
    private String topic_video;
    private String filename;
    private Date time2;
    private String instructor_name_video;

    


    Class_Material (String topic_video, String file_name, Date time2, String instructor_name_video ){

        this.topic_video = topic_video;
        this.filename = file_name;
        this.time2 = time2;
        this.instructor_name_video = instructor_name_video;

    }

    static ArrayList<Class_Material> lecture_video = new ArrayList<>();

    public String getTopic_slide() {
        return this.topic_slide;
    }

    public int getNo_of_slides() {
        return this.no_of_slides;
    }

    public Date getTime1() {
        return this.time1;
    }

    public String getInstructor_name() {
        return this.instructor_name;
    }

    public String getInstructor_name_video() {
        return this.instructor_name_video;
    }

    public String getTopic_video() {
        return this.topic_video;
    }

    public String getFilename() {
        return this.filename;
    }

    public Date getTime2() {
        return this.time2;
    }

}
