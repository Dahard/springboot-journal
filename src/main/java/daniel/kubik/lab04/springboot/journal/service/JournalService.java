package daniel.kubik.lab04.springboot.journal.service;

import daniel.kubik.lab04.springboot.journal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JournalService {
    private final StudentRepository studentRepository;
}
