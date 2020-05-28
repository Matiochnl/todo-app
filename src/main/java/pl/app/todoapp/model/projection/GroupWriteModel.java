package pl.app.todoapp.model.projection;

import java.util.Set;

public class GroupWriteModel {
    private String decription;
    private Set<GroupWriteModel> tasks;

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Set<GroupWriteModel> getTasks() {
        return tasks;
    }

    public void setTasks(Set<GroupWriteModel> tasks) {
        this.tasks = tasks;
    }
}
