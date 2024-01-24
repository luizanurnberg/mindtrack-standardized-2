package com.web.mindtrackproject.service.state;

import com.web.mindtrackproject.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class CreatedNoteStatus implements NoteStatus{
    @Override
    public Note updateNoteStatus(Note note) {
        note.setStatus("Criada");
        return note;
    }
}
