package com.example.demo.controller

import com.example.demo.model.Task
import com.example.demo.service.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun index(): MutableIterable<Task> = taskService.getTasks()
}
