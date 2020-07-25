package functions;

import models.Element;

import java.util.ArrayList;
import java.util.List;

public class StudentsClassroomVerification {

    public List<Element> studentsInClasses(List<Element> studentsList, List<Element> classroomsList){
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

    private boolean isStudentInClass(Element student, Element classroom) {
        double studentLatitude = student.getLatitude();
        double studentLongitude = student.getLongitude();
        double classroomLatitude = classroom.getLatitude();
        double classroomLongitude = classroom.getLongitude();
        final int earthRadius = 6371000;

        double latitudeDistance = Math.toRadians(classroomLatitude - studentLatitude);
        double longitudeDistance = Math.toRadians(classroomLongitude - studentLongitude);
        double a = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2)
                + Math.cos(Math.toRadians(studentLatitude)) * Math.cos(Math.toRadians(classroomLatitude))
                * Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        distance = Math.pow(distance, 2);
        if (distance < Math.sqrt(200)){
            return true;
        }
        else {
            return false;
        }

    }
}
