package com.Proyecto.ApiBasica.controller;

import com.Proyecto.ApiBasica.entities.Task;
import com.Proyecto.ApiBasica.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/v1/Task")
public class TaskController {

    @Autowired
    TaskService taskService;
    @GetMapping
    public ArrayList<Task> getTasks(){
        return this.taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task>getTaskById(@PathVariable Long id){
        return this.taskService.getTaskById(id);
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task){
        return this.taskService.saveTask(task);
    }
    @PutMapping("/update/{id}")
    public Task updateTaskById(@RequestBody Task request, @PathVariable Long id){
        return this.taskService.updateById(request,id);
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteTaskById(@PathVariable("id") Long id){
        boolean ok = this.taskService.deleteTask(id);
        if (ok){
            return "Tarea con "+ id + " Eliminada Correctamente";
        }else
            return "No se ha podido eliminar la tarea";
    }


}
