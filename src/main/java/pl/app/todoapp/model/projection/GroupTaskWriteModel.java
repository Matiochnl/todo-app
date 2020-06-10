package pl.app.todoapp.model.projection;

import pl.app.todoapp.model.Task;
import pl.app.todoapp.model.TaskGroup;

import java.time.LocalDateTime;

public class GroupTaskWriteModel {
    private String description;
    private LocalDateTime deadline;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Task toTask(){
        return new Task(description, deadline);
    }

     Task toTask(final TaskGroup group) {
        return new Task(description, deadline, group);
    }
}
