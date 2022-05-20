package daniel.kubik.lab04.springboot.journal.api;

import daniel.kubik.lab04.springboot.journal.dto.*;
import daniel.kubik.lab04.springboot.journal.model.Rating;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public interface JournalApi {

    @PostMapping("/student")
    ResponseEntity<StudentData> createStudent(@RequestBody StudentData studentData);

    @GetMapping("/student/{id}")
    ResponseEntity<StudentData> getStudent(@PathVariable("id") int id);

    @DeleteMapping("/student/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable("id") int id);

    @GetMapping("/student/{id}/grade")
    ResponseEntity<List<GradeData>> getStudentGrade(@PathVariable("id") int id);

    @GetMapping("/student/csv")
    ResponseEntity<byte[]> getAllStudentsCsv();

    @GetMapping("/course")
    ResponseEntity<CoursesResponse> getAllCourses();

    @PostMapping("/course")
    ResponseEntity<CourseData> createCourse(@RequestBody CourseData courseData);

    @PostMapping("/course/{id}/addStudent")
    ResponseEntity<CourseData> addStudent(@PathVariable("id") Long courseId, @RequestBody StudentPesel studentPesel);

    @PostMapping("/course/{id}/grade")
    ResponseEntity<GradeData> grade(@PathVariable("id") Long courseId, @RequestBody GradeData gradeData);

    @DeleteMapping("/course/{id}")
    ResponseEntity<Void> deleteCourse(@PathVariable("id") Long id);

    @GetMapping("/course/{id}")
    ResponseEntity<StudentsResponse> getAllStudentsFromCourse(@PathVariable("id") Long courseId);

    @GetMapping("/course/{id}/fill")
    ResponseEntity<Integer> getFillPercentage(@PathVariable("id") Long courseId);

    @PostMapping("/rating")
    ResponseEntity<Rating> rateCourse(@RequestBody RatingData ratingData);

    @GetMapping("/rating")
    ResponseEntity<RatingResponse> getRating();

}
