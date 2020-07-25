import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import functions.StudentsClassroomVerification;
import models.Element;

public class StudentsClassroomVerificationTests {

    @Test
    public void testCase1() {
        List<Element> studentList = new ArrayList<Element>();
        List<Element> classroomList = new ArrayList<Element>();
        Element johnStudent = new Element("John Wilson", 34.069149, -118.442639);
        Element janeStudent = new Element("Jane Graham", 34.069601, -118.441862);
        Element pamStudent = new Element("Pam Bam", 34.071513, -118.441181);
        classroomList.add(new Element("Principles of computational geo-location analysis", 34.069140, -118.442689));
        classroomList.add(new Element("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Element("Introductory Psychobiology", 34.069742, -118.441312));
        classroomList.add(new Element("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Element("Art Hitory", 34.071528, -118.441211));
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        List<Element> studentFoundList = StudentsClassroomVerification.studentsInClasses(studentList, classroomList);
        List<Element> expectedStudentFoundList = new ArrayList<Element>();
        expectedStudentFoundList.add(johnStudent);
        expectedStudentFoundList.add(janeStudent);
        expectedStudentFoundList.add(pamStudent);
        assertEquals(studentFoundList,expectedStudentFoundList);
    }

    @Test
    public void testCase2() {
        List<Element> studentList = new ArrayList<Element>();
        List<Element> classroomList = new ArrayList<Element>();
        Element johnStudent = new Element("John Wilson", 34.069849, -118.443539);
        Element janeStudent = new Element("Jane Graham", 34.069901, -118.441562);
        Element pamStudent = new Element("Pam Bam", 34.071523, -118.441171);
        classroomList.add(new Element("Principles of computational geo-location analysis", 33.05, -118.442689));
        classroomList.add(new Element("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Element("Introductory Psychobiology", 34.069742, -118.441312));
        classroomList.add(new Element("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Element("Art Hitory", 34.071528, -118.441211));
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        List<Element> studentFoundList = StudentsClassroomVerification.studentsInClasses(studentList, classroomList);
        List<Element> expectedStudentFoundList = new ArrayList<Element>();
        expectedStudentFoundList.add(pamStudent);
        assertEquals(studentFoundList,expectedStudentFoundList);
    }

    @Test
    public void testStudentsAreNotInClasses() {
        List<Element> studentList = new ArrayList<Element>();
        List<Element> classroomList = new ArrayList<Element>();
        Element johnStudent = new Element("John Wilson", 34.069849, -118.443539);
        Element janeStudent = new Element("Jane Graham", 34.069901, -118.441562);
        Element pamStudent = new Element("Pam Bam", 34.071633, -118.441171);
        classroomList.add(new Element("Principles of computational geo-location analysis", 34.0668, -118.4435));
        classroomList.add(new Element("Sedimentary Petrology", 34.069585, -118.441878));
        classroomList.add(new Element("Introductory Psychobiology", 34.069748, -118.441312));
        classroomList.add(new Element("Art of Listening", 34.070223, -118.440193));
        classroomList.add(new Element("Art Hitory", 34.071528, -118.4413));
        studentList.add(johnStudent);
        studentList.add(janeStudent);
        studentList.add(pamStudent);
        List<Element> studentFoundList = StudentsClassroomVerification.studentsInClasses(studentList, classroomList);
        List<Element> expectedStudentFoundList = new ArrayList<Element>();
        assertEquals(studentFoundList,expectedStudentFoundList);
    }
}
