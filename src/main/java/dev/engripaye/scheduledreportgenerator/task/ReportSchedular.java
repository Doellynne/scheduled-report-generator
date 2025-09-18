package dev.engripaye.scheduledreportgenerator.task;

import dev.engripaye.scheduledreportgenerator.entity.Note;
import dev.engripaye.scheduledreportgenerator.repository.NoteRepository;
import org.hibernate.annotations.Comment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReportSchedular {

    private final NoteRepository noteRepository;

    public ReportSchedular(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }


    /*
    * Runs every day at 8AM
    * cron format: second, minute, hour, day-of-month, month, day-of-week
    */

    @Scheduled(cron = "0 0 8 * * ?")
    public void generateDailyReport(){
        List<Note> notes = noteRepository.findAll();
        System.out.println("=== Daily Report (" + LocalDateTime.now() + ") ===");
        System.out.println("Total notes: " + notes.size());
        notes.forEach(n -> System.out.println(" - " + n.getTitle()));


        // simulate sending email
        System.out.println("✅ Report sent to users successfully!");
    }

}
