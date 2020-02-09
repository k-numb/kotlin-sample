package com.example.demo.service

import com.example.demo.model.Task
import com.example.demo.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {
    fun getTasks(): MutableIterable<Task> = taskRepository.findAll()
}
