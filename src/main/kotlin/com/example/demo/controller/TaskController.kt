package com.example.demo.controller

import com.example.demo.controller.form.TaskCreateForm
import com.example.demo.controller.form.TaskUpdateForm
import com.example.demo.model.Task
import com.example.demo.service.TaskService
import org.springframework.web.bind.annotation.DeleteMapping
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
     * タスクを新規作成します。
     *
     * @return タスク作成結果
     */
    @PostMapping
    fun create(@RequestBody taskCreateForm: TaskCreateForm): Map<String, String> {
        taskService.createTask(taskCreateForm)
        return mapOf("result" to "ok")
    }

    /**
     * 指定されたタスクを更新します。
     *
     * @return タスク更新結果
     */
    @PatchMapping("/{id}")
    fun update(@PathVariable("id") taskId: Long, @RequestBody taskUpdateForm: TaskUpdateForm): Map<String, String> {
        taskService.updateTask(taskId, taskUpdateForm)
        return mapOf("result" to "ok")
    }

    /**
     * 指定されたタスクを削除します。
     *
     * @return タスク削除結果
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") taskId: Long): Map<String, String> {
        taskService.deleteTask(taskId)
        return mapOf("result" to "ok")
    }

    /**
     * 指定されたタスク詳細を取得します。
     *
     * @return タスク詳細
     */
    @GetMapping("/{id}")
    fun detail(@PathVariable("id") taskId: Long): Task = taskService.detailTask(taskId)
}
