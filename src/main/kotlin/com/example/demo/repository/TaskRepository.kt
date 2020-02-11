package com.example.demo.repository

import com.example.demo.model.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * タスクテーブルのリポジトリクラス
 */
@Repository
interface TaskRepository : CrudRepository<Task, Long>
