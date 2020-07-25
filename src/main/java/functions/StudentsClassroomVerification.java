package functions;

import models.Element;

import java.util.ArrayList;
import java.util.List;

public class StudentsClassroomVerification {

    public static List<Element> studentsInClasses(List<Element> studentsList, List<Element> classroomsList){
        List<Element> studentInClass = new ArrayList<Element>();
        for(Element student : studentsList) {
            for(Element classroom : classroomsList) {
                if(isStudentInClass(student, classroom)) {
                    studentInClass.add(student);
                    break;
                }
            }
        }
        return studentInClass;
    }

    private static boolean isStudentInClass(Element student, Element classroom) {
        double studentLatitude = student.getLatitude();
        double studentLongitude = student.getLongitude();
        double classroomLatitude = classroom.getLatitude();
        double classroomLongitude = classroom.getLongitude();
        final int earthRadius = 6371000;

        double latDistance = Math.toRadians(classroomLatitude - studentLatitude);
        double lonDistance = Math.toRadians(classroomLongitude - studentLongitude);
        double positionClassroom = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(studentLatitude)) * Math.cos(Math.toRadians(classroomLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double positionStudent = 2 * Math.atan2(Math.sqrt(positionClassroom), Math.sqrt(1 - positionClassroom));
        double distance = earthRadius * positionStudent;

        if (distance < Math.sqrt(200)){
            return true;
        }
        else {
            return false;
        }

    }
}
