package com.web.mindtrackproject.service.decorator;

import com.web.mindtrackproject.entity.Note;
import com.web.mindtrackproject.repository.NoteRepository;

public class ColorDecorator extends NoteDecorator {
    private NoteRepository noteRepository;

    public ColorDecorator(NoteInterface noteInterface, NoteRepository noteRepository) {
        super(noteInterface);
        this.noteRepository = noteRepository;
    }

    @Override
    public Note updateNoteColor(Note note) {
        if (noteRepository.existsById(note.getId())) {
            return noteRepository.save(note);
        }
        return super.updateNoteColor(note);
    }

    public void setNoteRepository(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
}
