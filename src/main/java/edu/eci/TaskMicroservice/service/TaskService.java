package edu.eci.TaskMicroservice.service;

import edu.eci.TaskMicroservice.data.Task;
import java.util.List;

/**
 *
 * @author StivenVanegas
 */
public interface TaskService {

    Task create(Task task);

    Task findById(String id);

    List<Task> all();

    Boolean deleteById(String id);

    Task update(Task task, String id);
}
