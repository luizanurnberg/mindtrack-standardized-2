package com.web.mindtrackproject.service;

import com.web.mindtrackproject.entity.Note;
import com.web.mindtrackproject.repository.NoteRepository;
import com.web.mindtrackproject.service.state.CreatedNoteStatus;
import com.web.mindtrackproject.service.state.TrashNoteStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    private CreatedNoteStatus createdNoteStatus;

    private TrashNoteStatus trashNoteStatus;
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note updateNote(Long id, Note note) {
        if (noteRepository.existsById(id)) {
            return noteRepository.save(note);
        }
        return null;
    }

    public Note updateNoteStatusCreated(Note note) {
        if (noteRepository.existsById(note.getId())) {
            createdNoteStatus.updateNoteStatus(note);
            System.out.println(note);
            return noteRepository.save(note);
        }
        return null;
    }

    public Note updateNoteStatusTrash(Note note) {
        if (noteRepository.existsById(note.getId())) {
            trashNoteStatus.updateNoteStatus(note);
            System.out.println(note);
            return noteRepository.save(note);
        }
        return null;
    }

    public Note updateNoteColor(Note note) {
        if (noteRepository.existsById(note.getId())) {
            return noteRepository.save(note);
        }
        return null;
    }

    public Note updateNoteContent(Note note) {
        if (noteRepository.existsById(note.getId())) {
            return noteRepository.save(note);
        }
        return null;
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }


    public List<Note> getAllNotesForUser(Long userId) {
        return noteRepository.getUserNotes(userId);
    }

    public List<Note> getNotesByContent(String content) {
        return noteRepository.getNotesByContent(content);
    }

}
