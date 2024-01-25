package com.web.mindtrackproject.controller;

import com.web.mindtrackproject.entity.Reminder;
import com.web.mindtrackproject.repository.ReminderRepository;
import com.web.mindtrackproject.service.ReminderService;
import com.web.mindtrackproject.service.visitor.DateFilter;
import com.web.mindtrackproject.service.visitor.ReminderVisitor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reminder")
@AllArgsConstructor
public class ReminderController {
    private final ReminderService reminderService;
    private final ReminderRepository reminderRepository;

    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        Reminder createdReminder = reminderService.createReminder(reminder);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReminder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id) {
        Optional<Reminder> reminder = reminderService.getReminderById(id);
        return reminder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reminder>> getAllRemindersForUser(@PathVariable Long userId) {
        List<Reminder> userNotes = reminderService.getAllRemindersForUser(userId);
        return ResponseEntity.status(200).body(userNotes);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Reminder>> getAllRemindersByDate(
            @PathVariable LocalDate date,
            @RequestParam(name = "filterVisitor", required = false) ReminderVisitor filterVisitor
    ) {
        List<Reminder> reminders = reminderService.getAllRemindersByDate(date, filterVisitor);
        return ResponseEntity.status(200).body(reminders);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Reminder> updateReminderStatus(
            @PathVariable Long id,
            @RequestParam("status") String status
    ) {
        Optional<Reminder> optionalReminder = reminderService.getReminderById(id);

        if (optionalReminder.isPresent()) {
            Reminder reminder = optionalReminder.get();
            reminder.setStatus(status);
            Reminder updatedReminder = reminderService.updateReminderStatus(reminder);
            return ResponseEntity.ok(updatedReminder);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/content/{id}")
    public ResponseEntity<List<Reminder>> getAllRemindersByDate(
            @PathVariable LocalDate date
    ) {
        List<Reminder> reminders = reminderService.getAllRemindersByDate(date, new DateFilter(reminderRepository));
        return ResponseEntity.status(200).body(reminders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        Reminder updatedReminder = reminderService.updateReminder(id, reminder);
        if (updatedReminder != null) {
            return ResponseEntity.ok(updatedReminder);
        }
        return ResponseEntity.notFound().build();
    }
}
