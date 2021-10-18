interface Functions {
    
    void add_class_material(int instructor_no);
    void add_assessments(int instructor_no);
    void view_lecture_material();
    void view_assessments();
    void grade_assessments(int instructor_no);
    void view_grades(int student_no);
    void close_assessments();
    void view_comments();
    void add_comments_student(int id);
    void add_comments_instructor(int id);
    void logout();

}
