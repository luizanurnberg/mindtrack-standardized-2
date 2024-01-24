package com.web.mindtrackproject.service.state;

import com.web.mindtrackproject.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class TrashNoteStatus implements NoteStatus{
    @Override
    public Note updateNoteStatus(Note note) {
        note.setStatus("Lixeira");
        return note;
    }
}
