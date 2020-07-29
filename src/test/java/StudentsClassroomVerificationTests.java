import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import functions.StudentsClassroomVerification;
import models.Student;

public class StudentsClassroomVerificationTests {

    @Test
    public void testCase1() {
        List<Student> studentList = new ArrayList<Student>();
        List<Student> classroomList = new ArrayList<Student>();
        Student johnStudent = new Student("John Wilson", 34.069149, -118.442639);
        Student janeStudent = new Student("Jane Graham", 34.069601, -118.441862);
        Student pamStudent = new Student("Pam Bam", 34.071513, -118.441181);
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        classroomList.add(new Student("Principles of computational geo-location analysis", 34.069140, -118.442689));
        classroomList.add(new Student("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Student("Introductory Psychobiology", 34.069742, -118.441312));
        classroomList.add(new Student("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Student("Art Hitory", 34.071528, -118.441211));
        List<Student> studentFoundList = StudentsClassroomVerification.studentsInClasses(studentList, classroomList);
        List<Student> expectedStudentFoundList = new ArrayList<Student>();
        expectedStudentFoundList.add(johnStudent);
        expectedStudentFoundList.add(janeStudent);
        expectedStudentFoundList.add(pamStudent);
        assertEquals(studentFoundList,expectedStudentFoundList);
    }

    @Test
    public void testCase2() {
        List<Student> studentList = new ArrayList<Student>();
        List<Student> classroomList = new ArrayList<Student>();
        Student johnStudent = new Student("John Wilson", 34.069849, -118.443539);
        Student janeStudent = new Student("Jane Graham", 34.069901, -118.441562);
        Student pamStudent = new Student("Pam Bam", 34.071523, -118.441171);
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        classroomList.add(new Student("Principles of computational geo-location analysis", 33.05, -118.442689));
        classroomList.add(new Student("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Student("Introductory Psychobiology", 34.069742, -118.441312));
        classroomList.add(new Student("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Student("Art Hitory", 34.071528, -118.441211));
        List<Student> studentFoundList = StudentsClassroomVerification.studentsInClasses(studentList, classroomList);
        List<Student> expectedStudentFoundList = new ArrayList<Student>();
        expectedStudentFoundList.add(pamStudent);
        assertEquals(studentFoundList,expectedStudentFoundList);
    }

    @Test
    public void testStudentsAreNotInClasses() {
        List<Student> studentList = new ArrayList<Student>();
        List<Student> classroomList = new ArrayList<Student>();
        Student johnStudent = new Student("John Wilson", 34.069849, -118.443539);
        Student janeStudent = new Student("Jane Graham", 34.069901, -118.441562);
        Student pamStudent = new Student("Pam Bam", 34.071633, -118.441171);
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        classroomList.add(new Student("Principles of computational geo-location analysis", 34.0668, -118.4435));
        classroomList.add(new Student("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Student("Introductory Psychobiology", 34.069748, -118.441312));
        classroomList.add(new Student("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Student("Art Hitory", 34.071528, -118.4413));
        List<Student> studentFoundList = StudentsClassroomVerification.studentsInClasses(studentList, classroomList);
        List<Student> expectedStudentFoundList = new ArrayList<Student>();
        assertEquals(studentFoundList,expectedStudentFoundList);
    }
}
