package com.web.mindtrackproject.service.visitor;

import com.web.mindtrackproject.entity.Reminder;

public interface ReminderVisitor {
    void visit(Reminder reminder);
}

