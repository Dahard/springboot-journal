package daniel.kubik.lab04.springboot.journal.api;

import daniel.kubik.lab04.springboot.journal.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface JournalApi {

    @PostMapping("/student")
    ResponseEntity<StudentData> createStudent(@RequestBody StudentData studentData);

    @GetMapping("/student/{id}")
    ResponseEntity<StudentData> getStudent(@PathVariable("id") int id);

    @DeleteMapping("/student/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable("id") int id);

    @GetMapping("/student/{id}/grade")
    ResponseEntity<Grade> getStudentGrade(@PathVariable("id") int id);

    @GetMapping("/student/csv")
    ResponseEntity<Byte> [] getAllStudentsCsv();

    @GetMapping("/course")
    ResponseEntity<CoursesResponse> getAllCourses();

    @PostMapping("/course")
    ResponseEntity<Course> createCourse();

    @DeleteMapping("/course/{id}")
    ResponseEntity<Void> deleteCourse(@PathVariable("id") Long id);

    @GetMapping("/course/{id}")
    ResponseEntity<StudentsResponse> getAllStudentsFromCourse(@PathVariable("id") Long courseId);

    @GetMapping("/course/{id}/fill")
    ResponseEntity<Integer> getFillPercentage(@PathVariable("id") Long courseId);

    @PostMapping("/rating")
    ResponseEntity<String> rateCourse();

}
