package pl.app.todoapp.logic;

import org.springframework.stereotype.Service;
import pl.app.todoapp.model.TaskGroup;
import pl.app.todoapp.model.TaskGroupRepository;
import pl.app.todoapp.model.projection.GroupReadModel;
import pl.app.todoapp.model.projection.GroupWriteModel;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskGroupService {
    private TaskGroupRepository repository;

    public TaskGroupService(TaskGroupRepository repository) {
        this.repository = repository;
    }

    public GroupReadModel createGroup(GroupWriteModel source){
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll(){
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }
}
