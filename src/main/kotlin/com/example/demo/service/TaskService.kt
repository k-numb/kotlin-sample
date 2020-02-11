package com.example.demo.service

import com.example.demo.controller.form.TaskCreateForm
import com.example.demo.model.Task
import com.example.demo.repository.TaskRepository
import org.springframework.stereotype.Service

/**
 * タスクサービスクラス
 */
@Service
class TaskService(private val taskRepository: TaskRepository) {

    /**
     * タスク一覧を取得します。
     *
     * @return タスク一覧
     */
    fun getTasks(): MutableIterable<Task> = taskRepository.findAll()

    /**
     * タスクを新規作成します。
     */
    fun createTask(taskCreateForm: TaskCreateForm) {
        val newTask = Task(content = taskCreateForm.content)
        taskRepository.save(newTask)
    }
}
