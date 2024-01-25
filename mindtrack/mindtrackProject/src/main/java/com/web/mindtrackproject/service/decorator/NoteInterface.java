package com.web.mindtrackproject.service.decorator;

import com.web.mindtrackproject.entity.Note;

import java.util.Optional;

    public interface NoteInterface {
        Note updateNoteColor(Note note);
        Optional<Note> getNoteById(Long id);
}
