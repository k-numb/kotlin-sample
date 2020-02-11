package com.example.demo.controller

import com.example.demo.model.Task
import com.example.demo.service.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * タスクコントローラクラス
 */
@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    /**
     * タスク一覧を取得します。
     *
     * @return タスク一覧
     */
    @GetMapping
    fun index(): MutableIterable<Task> = taskService.getTasks()
}
