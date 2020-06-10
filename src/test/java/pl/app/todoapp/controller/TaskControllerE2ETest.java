package pl.app.todoapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import pl.app.todoapp.model.Task;
import pl.app.todoapp.model.TaskRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    TaskRepository repo;

    @Test
    void httpGet_returnsAllTasks(){
    repo.save(new Task("foo", LocalDateTime.now()));
    repo.save(new Task("bar", LocalDateTime.now()));

    Task[] result = restTemplate.getForObject("http://localhost:" + port + "/tasks", Task[].class);

    assertThat(result).hasSize(2);
    }

}