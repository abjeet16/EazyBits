package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.MembersRepository;
import com.luv2code.springboot.cruddemo.dao.TaskRepository;
import com.luv2code.springboot.cruddemo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    public void assignTask(Task task) {
        // Save task to the database
        taskRepository.save(task);

        // Access the employee email from the task object
        String email = task.getEmployee().getEmail();  // This will now work because of the @ManyToOne mapping
        String subject = "New Task Assigned: " + task.getTaskDescription();
        String body = "Deal ID: " + task.getDeal().getDealInProcessId() + "\nTask Description: " + task.getTaskDescription();

        // Send email to the employee
        emailSenderService.sendEMail(email, subject, body);

        System.out.println("Task assigned and email sent to employee: " + email);
    }

    // Method to check overdue tasks and send reminder emails
    @Scheduled(cron = "0 0 0 * * *")  // Check daily
    public void checkOverdueTasks() {
        LocalDate today = LocalDate.now();
        List<Task> pendingTasks = taskRepository.findByStatus("Pending");

        for (Task task : pendingTasks) {
            if (task.getDeadline().isBefore(today)) {
                // Send reminder email to the employee
                String email = task.getEmployee().getEmail();
                String subject = "Task Deadline Passed for Deal ID: " + task.getDeal().getDealInProcessId();
                String body = "The deadline for the following task has passed:\nTask: " + task.getTaskDescription() +
                        "\nDeal ID: " + task.getDeal().getDealInProcessId() + "\nPlease take necessary action.";
                emailSenderService.sendEMail(email, subject, body);

                System.out.println("Reminder email sent for overdue task: " + task.getTaskDescription());
            }
        }
    }
}


