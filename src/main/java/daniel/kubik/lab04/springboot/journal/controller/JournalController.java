package daniel.kubik.lab04.springboot.journal.controller;

import daniel.kubik.lab04.springboot.journal.api.JournalApi;
import daniel.kubik.lab04.springboot.journal.dto.*;
import daniel.kubik.lab04.springboot.journal.mappers.CourseMapper;
import daniel.kubik.lab04.springboot.journal.mappers.GradeMapper;
import daniel.kubik.lab04.springboot.journal.mappers.RatingMapper;
import daniel.kubik.lab04.springboot.journal.mappers.StudentMapper;
import daniel.kubik.lab04.springboot.journal.model.Rating;
import daniel.kubik.lab04.springboot.journal.service.JournalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JournalController implements JournalApi {

    private final JournalService journalService;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;
    private final RatingMapper ratingMapper;
    private final GradeMapper gradeMapper;

    @Override
    public ResponseEntity<StudentData> createStudent(StudentData studentData) {
        return ResponseEntity.ok(studentMapper.map(journalService.createStudent(studentData)));
    }

    @Override
    public ResponseEntity<StudentData> getStudent(int id) {
        return ResponseEntity.ok(studentMapper.map(journalService.getStudent(id)));
    }

    @Override
    public ResponseEntity<Void> deleteStudent(int id) {
        journalService.deleteStudent(id);
        return ResponseEntity.ok(null);
    }

    //TODO CSV
    @Override
    public ResponseEntity<Byte>[] getAllStudentsCsv() {
        return null;
    }

    @Override
    public ResponseEntity<CoursesResponse> getAllCourses() {
        CoursesResponse coursesResponse = new CoursesResponse();
        coursesResponse.setCours(courseMapper.map(journalService.getAllCourses()));
        return ResponseEntity.ok(coursesResponse);
    }

    @Override
    public ResponseEntity<CourseData> createCourse(CourseData courseData) {
        return ResponseEntity.ok(courseMapper.map(journalService.createCourse(courseData)));
    }

    @Override
    public ResponseEntity<StudentData> addStudent(Long courseId, Integer studentPesel) {
        return ResponseEntity.ok(studentMapper.map(journalService.addStudentToCourse(courseId, studentPesel)));
    }

    @Override
    public ResponseEntity<GradeData> grade(Long courseId, GradeData gradeData) {
        return ResponseEntity.ok(gradeMapper.map(journalService.grade(courseId, gradeData)));
    }

    @Override
    public ResponseEntity<List<GradeData>> getStudentGrade(int id) {
        return ResponseEntity.ok(gradeMapper.map(journalService.getStudentGrade(id)));
    }

    @Override
    public ResponseEntity<Void> deleteCourse(Long id) {
        journalService.deleteCourse(id);
        return null;
    }

    @Override
    public ResponseEntity<StudentsResponse> getAllStudentsFromCourse(Long courseId) {
        StudentsResponse studentsResponse = new StudentsResponse();
        studentsResponse.setStudentData(studentMapper.map(journalService.getAllStudentsFromCourse(courseId)));
        return ResponseEntity.ok(studentsResponse);
    }

    @Override
    public ResponseEntity<Integer> getFillPercentage(Long courseId) {
        return ResponseEntity.ok(journalService.getFillPercentage(courseId));
    }

    @Override
    public ResponseEntity<Rating> rateCourse(RatingData ratingData) {
        return ResponseEntity.ok(journalService.rateCourse(ratingData));
    }

    @Override
    public ResponseEntity<RatingResponse> getRating() {
        RatingResponse ratingResponse = new RatingResponse();
        ratingResponse.setRatingData(ratingMapper.map(journalService.getRating()));
        return ResponseEntity.ok(ratingResponse);
    }
}
