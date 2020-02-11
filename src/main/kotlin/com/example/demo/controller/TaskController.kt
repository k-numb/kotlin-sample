package com.example.demo.controller

import com.example.demo.controller.form.TaskCreateForm
import com.example.demo.controller.form.TaskUpdateForm
import com.example.demo.model.Task
import com.example.demo.service.TaskService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    /**
     * タスクの新規作成をします。
     *
     * @return タスク作成結果
     */
    @PostMapping
    fun create(@RequestBody taskCreateForm: TaskCreateForm): Map<String, String> {
        taskService.createTask(taskCreateForm)
        return mapOf("result" to "ok")
    }

    /**
     * タスクの更新をします。
     *
     * @return タスク更新結果
     */
    @PatchMapping("/{id}")
    fun update(@PathVariable("id") taskId: Long, @RequestBody taskUpdateForm: TaskUpdateForm): Map<String, String> {
        taskService.updateTask(taskId, taskUpdateForm)
        return mapOf("result" to "ok")
    }
}
