package dev.engripaye.scheduledreportgenerator.task;

import dev.engripaye.scheduledreportgenerator.entity.Note;
import dev.engripaye.scheduledreportgenerator.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReportScheduler {

    private static final Logger log = LoggerFactory.getLogger(ReportScheduler.class);
    private final NoteRepository noteRepository;

    public ReportScheduler(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    /**
     * Runs every 30 seconds for demo purposes
     * Cron format: second, minute, hour, day-of-month, month, day-of-week
     * Example: "0/30 * * * * ?" → every 30 seconds
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void generateDemoReport() {
        List<Note> notes = noteRepository.findAll();

        log.info("=== Demo Report ({}) ===", LocalDateTime.now());
        log.info("Total notes: {}", notes.size());
        notes.forEach(n -> log.info(" - {}", n.getTitle()));

        // Simulate sending email
        log.info("✅ Report sent to users successfully!");
    }
}
