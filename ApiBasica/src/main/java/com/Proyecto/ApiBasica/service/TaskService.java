package com.Proyecto.ApiBasica.service;

import com.Proyecto.ApiBasica.entities.Task;
import com.Proyecto.ApiBasica.repository.ITaskRepository;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Getter
@Data
@Service
public class TaskService {
    @Autowired
    ITaskRepository taskRepository;

    public ArrayList<Task> getTasks(){
        return (ArrayList<Task>) taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task>getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task updateById(@NonNull Task request, Long id){
        Task task = taskRepository.findById(id).orElseThrow();

        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());

        return task;
    }
    public boolean deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
