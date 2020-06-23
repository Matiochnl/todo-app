package pl.app.todoapp.model.event;

import pl.app.todoapp.model.Task;

import java.time.Clock;

public class TaskDone extends TaskEvent {
     TaskDone(Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
