package daniel.kubik.lab04.springboot.journal.service;

import daniel.kubik.lab04.springboot.journal.model.Course;
import daniel.kubik.lab04.springboot.journal.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class CsvProducer {
    private static final String[] CSV_STUDENTS_HEADERS = {"pesel", "name", "lastName", "birthYear", "pointsCount", "condition", "course"};

    public String produceCsvForStudents(List<Student> students) {
        StringWriter sw = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(sw, CSVFormat.DEFAULT.builder().setHeader(CSV_STUDENTS_HEADERS).build())) {
            students.forEach(student -> {
                try {
                    printer.printRecord(
                            student.getPesel(),
                            student.getName(),
                            student.getLastName(),
                            student.getBirthYear(),
                            student.getPointsCount(),
                            student.getState(),
                            Optional.ofNullable(student.getCourse()).map(Course::getName).orElse("Course not found"));
                } catch (IOException e) {
                    log.error("Cannot produce csv for students...", e);
                }
            });
        } catch (IOException ioException) {
            throw new CsvProducerException("CSV cannot be produced for request - please contact with our technical support");
        }
        return sw.toString();
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public static class CsvProducerException extends RuntimeException {
        public CsvProducerException(String message) {
            super(message);
        }
    }
}
