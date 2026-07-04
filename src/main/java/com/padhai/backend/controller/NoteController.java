package com.padhai.backend.controller;

import com.padhai.backend.dto.NoteRequest;
import com.padhai.backend.dto.NoteResponse;
import com.padhai.backend.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // ================= CREATE NOTE =================

    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @PostMapping
    public ResponseEntity<NoteResponse> createNote(
            @RequestBody NoteRequest request
    ) {

        return ResponseEntity.ok(
                noteService.uploadNote(request)
        );

    }

    // ================= GET ALL NOTES =================

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getAllNotes() {

        return ResponseEntity.ok(
                noteService.getAllNotes()
        );

    }

    // ================= GET NOTE BY ID =================

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> getNoteById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                noteService.getNoteById(id)
        );

    }

    // ================= GET NOTES BY COURSE =================

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<NoteResponse>> getNotesByCourse(
            @PathVariable Long courseId
    ) {

        return ResponseEntity.ok(
                noteService.getNotesByCourse(courseId)
        );

    }

    // ================= DELETE NOTE =================

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(
            @PathVariable Long id
    ) {

        noteService.deleteNote(id);

        return ResponseEntity.ok("Note Deleted Successfully");

    }

}