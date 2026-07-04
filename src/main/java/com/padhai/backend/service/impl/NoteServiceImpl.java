package com.padhai.backend.service.impl;

import com.padhai.backend.dto.NoteRequest;
import com.padhai.backend.dto.NoteResponse;
import com.padhai.backend.entity.Course;
import com.padhai.backend.entity.Note;
import com.padhai.backend.repository.CourseRepository;
import com.padhai.backend.repository.NoteRepository;
import com.padhai.backend.service.FileStorageService;
import com.padhai.backend.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final CourseRepository courseRepository;
    private final FileStorageService fileStorageService;
    public NoteServiceImpl(NoteRepository noteRepository,
                           CourseRepository courseRepository,
                           FileStorageService fileStorageService) {

        this.noteRepository = noteRepository;
        this.courseRepository = courseRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public NoteResponse uploadNote(NoteRequest request) {

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Note note = new Note();

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setCourse(course);

        Note saved = noteRepository.save(note);

        return mapToResponse(saved);
    }

    @Override
    public List<NoteResponse> getAllNotes() {

        return noteRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<NoteResponse> getNotesByCourse(Long courseId) {

        return noteRepository.findByCourseId(courseId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());

    }

    @Override
    public NoteResponse getNoteById(Long id) {

        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        return mapToResponse(note);

    }

    @Override
    public void deleteNote(Long id) {

        noteRepository.deleteById(id);

    }

    private NoteResponse mapToResponse(Note note) {

        NoteResponse response = new NoteResponse();

        response.setId(note.getId());
        response.setTitle(note.getTitle());
        response.setDescription(note.getDescription());
        response.setFileName(note.getFileName());
        response.setFileUrl(note.getFileUrl());

        return response;

    }

}