package com.CRM.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRM.entity.Task;
import com.CRM.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    
    public Task createTask(Task task) {  return taskRepository.save(task);
    }
    
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

    	
    

