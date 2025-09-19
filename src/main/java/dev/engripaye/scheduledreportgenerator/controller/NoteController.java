package dev.engripaye.scheduledreportgenerator.controller;

import dev.engripaye.scheduledreportgenerator.entity.Note;
import dev.engripaye.scheduledreportgenerator.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        return "index"; // Thymeleaf template
    }

    @PostMapping("/add")
    public String addNote(@RequestParam String title, @RequestParam String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.saveNote(note);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/";
    }
}
