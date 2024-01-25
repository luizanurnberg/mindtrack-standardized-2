package com.web.mindtrackproject.service.decorator;

import com.web.mindtrackproject.entity.Note;

import java.util.Optional;

public abstract class NoteDecorator implements NoteInterface{
    protected NoteInterface noteInterface;

    public NoteDecorator(NoteInterface noteInterface) {
        this.noteInterface = noteInterface;
    }

    @Override
    public Note updateNoteColor(Note note) {
        return noteInterface.updateNoteColor(note);
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteInterface.getNoteById(id);
    }
}
