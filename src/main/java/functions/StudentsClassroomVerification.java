package functions;

import models.Classroom;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsClassroomVerification {

    public static List<Student> studentsInClassroom(List<Student> studentsList, List<Classroom> classroomsList){
        List<Student> studentsInClass = new ArrayList<Student>();
        for(Student student : studentsList) {
            for(Classroom classroom : classroomsList) {
                if(isStudentInClassroom(student, classroom)) {
                    studentsInClass.add(student);
                    break;
                }
            }
        }
        return studentsInClass;
    }

    private static boolean isStudentInClassroom(Student student, Classroom classroom) {
        double studentLatitude = student.getLatitude();
        double studentLongitude = student.getLongitude();
        double classroomLatitude = classroom.getLatitude();
        double classroomLongitude = classroom.getLongitude();
        final int earthRadius = 6371000;
        final int centerToEdgeWidth = 10;
        final int centerToEdgeHeight = 10;
        final double classroomMaxLength = Math.sqrt((Math.pow(centerToEdgeWidth,2)+Math.pow(centerToEdgeHeight,2)));

        double latitudeDistance = Math.toRadians(classroomLatitude - studentLatitude);
        double longitudeDistance = Math.toRadians(classroomLongitude - studentLongitude);
        double positionClassroom = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2)
                + Math.cos(Math.toRadians(studentLatitude)) * Math.cos(Math.toRadians(classroomLatitude))
                * Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);
        double positionStudent = 2 * Math.atan2(Math.sqrt(positionClassroom), Math.sqrt(1 - positionClassroom));
        double distance = earthRadius * positionStudent;

        if (distance < classroomMaxLength){
            return true;
        }
        else {
            return false;
        }
    }
}
