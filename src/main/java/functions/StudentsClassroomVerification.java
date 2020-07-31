package functions;

import models.Classroom;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsClassroomVerification {

    private static final int classroomWidth = 20;
    private static final int classroomHeight = 20;
    private static final int earthRadius = 6371000;
    private static final int formulaDivisor = 2;
    private static final int formulaMultiplier = 2;

    public static List<Student> studentsInClassroom(List<Student> studentsList, List<Classroom> classroomsList){
        List<Student> studentsInClass = new ArrayList<Student>();
        final int centerToEdgeWidth = (classroomWidth/2);
        final int centerToEdgeHeight = (classroomHeight/2);
        final double classroomMaxLength = Math.sqrt((Math.pow(centerToEdgeWidth,2)+Math.pow(centerToEdgeHeight,2)));
        for(Student student : studentsList) {
            for(Classroom classroom : classroomsList) {
                if(isStudentInClassroom(student, classroom, classroomMaxLength)) {
                    studentsInClass.add(student);
                    break;
                }
            }
        }
        return studentsInClass;
    }

    private static boolean isStudentInClassroom(Student student, Classroom classroom, double classroomMaxLength) {
        double studentLatitude = student.getLatitude();
        double studentLongitude = student.getLongitude();
        double classroomLatitude = classroom.getLatitude();
        double classroomLongitude = classroom.getLongitude();

        double latitudeDistance = Math.toRadians(classroomLatitude - studentLatitude);
        double longitudeDistance = Math.toRadians(classroomLongitude - studentLongitude);
        double positionClassroom = Math.sin(latitudeDistance / formulaDivisor) * Math.sin(latitudeDistance / formulaDivisor)
                + Math.cos(Math.toRadians(studentLatitude)) * Math.cos(Math.toRadians(classroomLatitude))
                * Math.sin(longitudeDistance / formulaDivisor) * Math.sin(longitudeDistance / formulaDivisor);
        double positionStudent = formulaMultiplier * Math.atan2(Math.sqrt(positionClassroom), Math.sqrt(1 - positionClassroom));
        double distance = earthRadius * positionStudent;

        return (distance < classroomMaxLength);
    }
}
