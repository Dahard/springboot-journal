package daniel.kubik.lab04.springboot.journal.service;
import daniel.kubik.lab04.springboot.journal.dto.*;

import daniel.kubik.lab04.springboot.journal.exception.StudentNotFound;

import daniel.kubik.lab04.springboot.journal.model.Course;
import daniel.kubik.lab04.springboot.journal.model.Rating;
import daniel.kubik.lab04.springboot.journal.model.Student;
import daniel.kubik.lab04.springboot.journal.repository.CourseRepository;
import daniel.kubik.lab04.springboot.journal.repository.RatingRepository;
import daniel.kubik.lab04.springboot.journal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class JournalService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final RatingRepository ratingRepository;

    void throwStudentException(Student student) {
        log.error("{} student already exist", student.getPesel());
    }

    void throwCourseException(Course course) {
        log.error("{} course already exist", course.getName());
    }

    private Student createAndSaveStudent(StudentData studentData) {
        Student student = new Student();
        student.setPesel(studentData.getPesel());
        student.setName(studentData.getName());
        student.setLastName(studentData.getLastName());
        student.setState(studentData.getState());
        student.setBirthYear(studentData.getBirthYear());
        return studentRepository.save(student);
    }

    private Course createAndSaveCourse(CourseData courseData) {
        Course course = new Course();
        course.setName(courseData.getName());
        course.setMaxStudentCount(courseData.getMaxStudentCount());
        course.setStudents(courseData.getStudents());
        return courseRepository.save(course);
    }

    private Rating createAndSaveRate(RatingData ratingData, String courseName) {
        Rating rating = new Rating();
        rating.setRate(ratingData.getRate());
        rating.setCourseId(ratingData.getCourseId());
        rating.setCourseName(courseName);
        return ratingRepository.save(rating);
    }

    public Student createStudent(StudentData studentData) {

        Optional<Student> byPesel = studentRepository.findByPesel(studentData.getPesel());
        if (byPesel.isPresent()) {
            throwStudentException(byPesel.get());
        }
        return createAndSaveStudent(studentData);
    }

    public Student getStudent(int pesel) {
       return studentRepository.findByPesel(pesel).orElseThrow(StudentNotFound::new);
    }

    @Transactional
    public void deleteStudent(int pesel) {
        studentRepository.deleteStudentByPesel(pesel);
    }

    public Grade getStudentGrade(int pesel) {
        return null;
    }

    public ResponseEntity<Byte>[] getAllStudentsCsv() {
        return new ResponseEntity[]{(ResponseEntity<Byte>) ResponseEntity.ok()};
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(CourseData courseData) {
        Optional<Course> byId = courseRepository.findById(courseData.getId());
        if (byId.isPresent()) {
            throwCourseException(byId.get());
        }
        return createAndSaveCourse(courseData);
    }

    @Transactional
    public void deleteCourse(Long id) {
        courseRepository.deleteCourseById(id);
    }

    public List<Student> getAllStudentsFromCourse(Long courseId) {
        List<Student> students = courseRepository.findById(courseId).get().getStudents();
        if (students.isEmpty()) {
            throw new StudentNotFound();
        } else {
            return students;
        }
    }

    public int getFillPercentage(Long courseId) {
        int maxStudentCount = courseRepository.findById(courseId).get().getMaxStudentCount();
        int size = courseRepository.findById(courseId).get().getStudents().size();
        return size * 100 / maxStudentCount;
    }

    public Rating rateCourse(RatingData ratingData) {
        Course course = courseRepository.findById(ratingData.getCourseId()).get();
        course.setRate(ratingData.getRate());
        return createAndSaveRate(ratingData, course.getName());
    }

    public List<Rating> getRating() {
        return ratingRepository.findAll();
    }
}
