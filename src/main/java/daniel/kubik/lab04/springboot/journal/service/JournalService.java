package daniel.kubik.lab04.springboot.journal.service;
import daniel.kubik.lab04.springboot.journal.dto.Course;
import daniel.kubik.lab04.springboot.journal.dto.CoursesResponse;

import daniel.kubik.lab04.springboot.journal.dto.Grade;
import daniel.kubik.lab04.springboot.journal.exception.StudentNotFound;
import daniel.kubik.lab04.springboot.journal.mappers.StudentMapper;
import daniel.kubik.lab04.springboot.journal.model.StudentCondition;

import daniel.kubik.lab04.springboot.journal.dto.StudentData;
import daniel.kubik.lab04.springboot.journal.exception.StudentAlreadyExist;
import daniel.kubik.lab04.springboot.journal.model.Student;
import daniel.kubik.lab04.springboot.journal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JournalService {
    private final StudentRepository studentRepository;

    void throwException(Student student) {
        log.error("{} student already exist", student.getPesel());
    }

    Student createAndSaveStudent(StudentData studentData) {
        Student student = new Student();
        student.setPesel(studentData.getPesel());
        student.setName(studentData.getName());
        student.setLastName(studentData.getLastName());
        student.setState(studentData.getState());
        student.setBirthYear(studentData.getBirthYear());
        return studentRepository.save(student);
    }

    public Student createStudent(StudentData studentData) {

        Optional<Student> byPesel = studentRepository.findByPesel(studentData.getPesel());
        if (byPesel.isPresent()) {
            throwException(byPesel.get());
        }
        return createAndSaveStudent(studentData);
    }

    public Student getStudent(int pesel) {
       return studentRepository.findByPesel(pesel).orElseThrow(StudentNotFound::new);
    }

    public void deleteStudent(int pesel) {
        studentRepository.deleteByPesel(pesel);
    }

//    public Grade getStudentGrade(int pesel) {
//    }

    public ResponseEntity<Byte>[] getAllStudentsCsv() {
        return new ResponseEntity[]{(ResponseEntity<Byte>) ResponseEntity.ok()};
    }

    public ResponseEntity<CoursesResponse> getAllCourses() {
        return null;
    }

    public ResponseEntity<Course> createCourse() {
        return null;
    }

    public ResponseEntity<Void> deleteCourse(Long id) {

        return null;
    }

//    public ResponseEntity<> getAllStudentsFromCourse(Long courseId) {
//        return null;
//    }

    public ResponseEntity<Integer> getFillPercentage(Long courseId) {
        return (ResponseEntity<Integer>) ResponseEntity.ok();
    }

    public ResponseEntity<String> rateCourse() {
        return null;
    }
}
