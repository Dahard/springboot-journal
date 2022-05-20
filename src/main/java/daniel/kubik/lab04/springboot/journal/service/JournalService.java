package daniel.kubik.lab04.springboot.journal.service;

import daniel.kubik.lab04.springboot.journal.dto.*;
import daniel.kubik.lab04.springboot.journal.exception.GradesNotFound;
import daniel.kubik.lab04.springboot.journal.exception.NotFound;
import daniel.kubik.lab04.springboot.journal.exception.AlreadyExist;
import daniel.kubik.lab04.springboot.journal.mappers.StudentMapper;
import daniel.kubik.lab04.springboot.journal.mappers.GradeMapper;
import daniel.kubik.lab04.springboot.journal.model.Course;
import daniel.kubik.lab04.springboot.journal.model.Grade;
import daniel.kubik.lab04.springboot.journal.model.Rating;
import daniel.kubik.lab04.springboot.journal.model.Student;
import daniel.kubik.lab04.springboot.journal.repository.CourseRepository;
import daniel.kubik.lab04.springboot.journal.repository.GradeRepository;
import daniel.kubik.lab04.springboot.journal.repository.RatingRepository;
import daniel.kubik.lab04.springboot.journal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JournalService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final RatingRepository ratingRepository;
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;
    private final StudentMapper studentMapper;
    private final CsvProducer csvProducer;

    void checkStudentIsNotRegistered(int pesel) {
        if (studentRepository.existsByPesel(pesel)) {
            log.error("Student is already registered for pesel:{}", pesel);
            throw new AlreadyExist("Student already Exist");
        }
    }

    void checkCourseIsNameAvailable(String name){
        if (courseRepository.existsByName(name)) {
            log.error("Course name already in use");
            throw new AlreadyExist("Course already exist");
        }
    }

    void throwCourseException(Course course) {
        log.error("{} course already exist", course.getName());
    }

    private Course createAndSaveCourse(CourseData courseData) {
        Course course = new Course();
        course.setName(courseData.getName());
        course.setMaxStudentCount(courseData.getMaxStudentCount());
        return courseRepository.save(course);
    }

    private Rating createAndSaveRate(RatingData ratingData, String courseName) {
        Rating rating = new Rating();
        rating.setRate(ratingData.getRate());
        rating.setCourseId(ratingData.getCourseId());
        rating.setCourseName(courseName);
        return ratingRepository.save(rating);
    }

    private Grade createAndSaveGrade(GradeData gradeData) {
        Grade grade = new Grade();
        grade.setStudentPesel(gradeData.getStudentPesel());
        grade.setGrade(gradeData.getGrade());
        grade.setExerciseTitle(gradeData.getExerciseTitle());
        return gradeRepository.save(grade);
    }

    public Student createStudent(StudentData studentData) {
        checkStudentIsNotRegistered(studentData.getPesel());
        Student student = studentMapper.mapWithoutCourse(studentData);
        return studentRepository.save(student);
    }

    public Student getStudent(int pesel) {
        return studentRepository.findByPesel(pesel).orElseThrow(() -> new NotFound("Student not found for pesel " + pesel));
    }

    @Transactional
    public void deleteStudent(int pesel) {
        studentRepository.deleteStudentByPesel(pesel);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(CourseData courseData) {
        checkCourseIsNameAvailable(courseData.getName());
        return createAndSaveCourse(courseData);
    }

    public Course addStudentToCourse(Long id, int studentPesel) {
        Student student = studentRepository.getById(studentPesel);
        Course byId = courseRepository.getById(id);
        byId.addStudent(student);
        return courseRepository.save(byId);
    }

    @Transactional
    public void deleteCourse(Long id) {
        courseRepository.deleteCourseById(id);
    }

    public List<Student> getAllStudentsFromCourse(Long courseId) {
        List<Student> students = courseRepository.findById(courseId).get().getStudents();
        if (students.isEmpty()) {
            throw new NotFound("no one enjoys these course");
        } else {
            return students;
        }
    }

    public Fill getFillPercentage(Long courseId) {
        int maxStudentCount = courseRepository.findById(courseId).get().getMaxStudentCount();
        int size = courseRepository.findById(courseId).get().getStudents().size();
        return new Fill(size * 100 / maxStudentCount);
    }

    public Rating rateCourse(RatingData ratingData) {
        Course course = courseRepository.findById(ratingData.getCourseId()).get();
        course.setRate(ratingData.getRate());
        return createAndSaveRate(ratingData, course.getName());
    }

    public List<Rating> getRating() {
        return ratingRepository.findAll();
    }

    public List<Grade> getStudentGrade(int pesel) {
        List<Grade> allByStudentPesel = gradeRepository.findAllByStudentPesel(pesel);
        if (allByStudentPesel.isEmpty()) {
            throw new GradesNotFound();
        } else {
            return allByStudentPesel;
        }
    }

    public Grade grade(Long courseId, GradeData gradeData) {
        createAndSaveGrade(gradeData);
        Grade grade = gradeMapper.map(gradeData);
        courseRepository.findById(courseId).get()
                .getGradeData()
                .add(grade);
        return grade;
    }

    public String getAllStudentsCsv() {
        return csvProducer.produceCsvForStudents(studentRepository.findAll());
    }

}
