package com.padhai.backend.service;

import com.padhai.backend.dto.NoteRequest;
import com.padhai.backend.dto.NoteResponse;

import java.util.List;

public interface NoteService {

    NoteResponse uploadNote(NoteRequest request);

    List<NoteResponse> getAllNotes();

    List<NoteResponse> getNotesByCourse(Long courseId);

    NoteResponse getNoteById(Long id);

    void deleteNote(Long id);

}