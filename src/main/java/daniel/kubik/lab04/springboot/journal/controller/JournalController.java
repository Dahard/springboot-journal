package daniel.kubik.lab04.springboot.journal.controller;

import daniel.kubik.lab04.springboot.journal.api.JournalApi;
import daniel.kubik.lab04.springboot.journal.dto.*;
import daniel.kubik.lab04.springboot.journal.mappers.StudentMapper;
import daniel.kubik.lab04.springboot.journal.service.JournalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JournalController implements JournalApi {

    private final JournalService journalService;
    private final StudentMapper studentMapper;

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

    @Override
    public ResponseEntity<Grade> getStudentGrade(int id) {
        return null;
    }

    @Override
    public ResponseEntity<Byte>[] getAllStudentsCsv() {
        return new ResponseEntity[]{(ResponseEntity<Byte>) ResponseEntity.ok()};
    }

    @Override
    public ResponseEntity<CoursesResponse> getAllCourses() {
        return null;
    }

    @Override
    public ResponseEntity<Course> createCourse() {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCourse(Long id) {

        return null;
    }

    @Override
    public ResponseEntity<StudentsResponse> getAllStudentsFromCourse(Long courseId) {
        return null;
    }

    @Override
    public ResponseEntity<Integer> getFillPercentage(Long courseId) {
        return (ResponseEntity<Integer>) ResponseEntity.ok();
    }

    @Override
    public ResponseEntity<String> rateCourse() {
        return null;
    }
}
