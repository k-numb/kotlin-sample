package com.example.demo.service

import com.example.demo.controller.form.TaskCreateForm
import com.example.demo.controller.form.TaskUpdateForm
import com.example.demo.exception.NotFoundException
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

    /**
     * 指定されたタスクを更新します。
     */
    fun updateTask(taskId: Long, taskUpdateForm: TaskUpdateForm) {
        val task = taskRepository.findById(taskId).orElseThrow { NotFoundException("タスクが見つかりませんでした。") }
        val updateTask = task.copy(content = taskUpdateForm.content, done = taskUpdateForm.done)
        taskRepository.save(updateTask)
    }

    /**
     * 指定されたタスクを削除します。
     */
    fun deleteTask(taskId: Long) {
        val task = taskRepository.findById(taskId).orElseThrow { NotFoundException("タスクが見つかりませんでした。") }
        val deleteTask = task.copy()
        taskRepository.delete(deleteTask)
    }

    /**
     * 指定されたタスク詳細を取得します。
     */
    fun detailTask(taskId: Long): Task = taskRepository.findById(taskId).orElseThrow { NotFoundException("タスクが見つかりませんでした。") }
}
