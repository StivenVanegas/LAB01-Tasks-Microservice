package edu.eci.TaskMicroservice.controller;

import edu.eci.TaskMicroservice.data.Task;
import edu.eci.TaskMicroservice.dto.TaskDto;
import edu.eci.TaskMicroservice.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author StivenVanegas
 */
@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping
    public ResponseEntity<List<Task>> all(){
        return new ResponseEntity(taskService.all(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id){
        return new ResponseEntity(taskService.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto taskDto){
        Task task = new Task(taskDto);
        return new ResponseEntity(taskService.create(task),HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDto userDto, @PathVariable String id){
        Task task = new Task(id, userDto);
        return new ResponseEntity(taskService.update(task, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        return new ResponseEntity(taskService.deleteById(id),HttpStatus.OK);
    }
}
