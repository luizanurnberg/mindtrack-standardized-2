package com.web.mindtrackproject.service.visitor;

import com.web.mindtrackproject.entity.Reminder;
import com.web.mindtrackproject.repository.ReminderRepository;

import java.time.LocalDate;
import java.util.List;

public class DateFilter implements ReminderVisitor {

    private final ReminderRepository reminderRepository;

    public DateFilter(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public void visit(Reminder reminder) {
        System.out.println("Visitado.");
    }
}
