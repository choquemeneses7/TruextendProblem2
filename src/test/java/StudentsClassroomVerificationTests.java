import models.Classroom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import functions.StudentsClassroomVerification;
import models.Student;

public class StudentsClassroomVerificationTests {

    @Test
    public void testThreeStudentsInClassrooms() {
        List<Student> studentList = new ArrayList<Student>();
        List<Classroom> classroomList = new ArrayList<Classroom>();
        Student johnStudent = new Student("John Wilson", 34.069149, -118.442639);
        Student janeStudent = new Student("Jane Graham", 34.069601, -118.441862);
        Student pamStudent = new Student("Pam Bam", 34.071513, -118.441181);
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        classroomList.add(new Classroom("Principles of computational geo-location analysis", 34.069140, -118.442689));
        classroomList.add(new Classroom("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Classroom("Introductory Psychobiology", 34.069742, -118.441312));
        classroomList.add(new Classroom("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Classroom("Art Hitory", 34.071528, -118.441211));
        List<Student> studentFoundList = StudentsClassroomVerification.studentsInClassroom(studentList, classroomList);
        List<Student> expectedStudentFoundList = new ArrayList<Student>();
        expectedStudentFoundList.add(johnStudent);
        expectedStudentFoundList.add(janeStudent);
        expectedStudentFoundList.add(pamStudent);
        assertEquals(studentFoundList,expectedStudentFoundList);
    }

    @Test
    public void testOneStudentInClassrooms() {
        List<Student> studentList = new ArrayList<Student>();
        List<Classroom> classroomList = new ArrayList<Classroom>();
        Student johnStudent = new Student("John Wilson", 34.069849, -118.443539);
        Student janeStudent = new Student("Jane Graham", 34.069901, -118.441562);
        Student pamStudent = new Student("Pam Bam", 34.071523, -118.441171);
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        classroomList.add(new Classroom("Principles of computational geo-location analysis", 33.05, -118.442689));
        classroomList.add(new Classroom("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Classroom("Introductory Psychobiology", 34.069742, -118.441312));
        classroomList.add(new Classroom("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Classroom("Art Hitory", 34.071528, -118.441211));
        List<Student> studentFoundList = StudentsClassroomVerification.studentsInClassroom(studentList, classroomList);
        List<Student> expectedStudentFoundList = new ArrayList<Student>();
        expectedStudentFoundList.add(pamStudent);
        assertEquals(studentFoundList,expectedStudentFoundList);
    }

    @Test
    public void testStudentsAreNotInClassrooms() {
        List<Student> studentList = new ArrayList<Student>();
        List<Classroom> classroomList = new ArrayList<Classroom>();
        Student johnStudent = new Student("John Wilson", 34.069849, -118.443539);
        Student janeStudent = new Student("Jane Graham", 34.069901, -118.441562);
        Student pamStudent = new Student("Pam Bam", 34.071633, -118.441171);
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        classroomList.add(new Classroom("Principles of computational geo-location analysis", 34.0668, -118.4435));
        classroomList.add(new Classroom("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Classroom("Introductory Psychobiology", 34.069748, -118.441312));
        classroomList.add(new Classroom("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Classroom("Art Hitory", 34.071528, -118.4413));
        List<Student> studentFoundList = StudentsClassroomVerification.studentsInClassroom(studentList, classroomList);
        List<Student> expectedStudentFoundList = new ArrayList<Student>();
        assertEquals(studentFoundList,expectedStudentFoundList);
    }
}
