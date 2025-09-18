package dev.engripaye.scheduledreportgenerator.repository;

import dev.engripaye.scheduledreportgenerator.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
