package pl.app.todoapp.model.event;

import pl.app.todoapp.model.Task;

import java.time.Clock;

public class TaskUndone extends TaskEvent {
     TaskUndone(Task source) {
        super(source.getId(), Clock.systemDefaultZone());
    }
}
