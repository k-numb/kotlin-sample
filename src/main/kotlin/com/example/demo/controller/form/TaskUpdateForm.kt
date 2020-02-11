package com.example.demo.controller.form

/**
 * タスクの更新フォームクラス
 */
data class TaskUpdateForm(
    /** 内容 */
    val content: String,
    /** 進捗 */
    val done: Boolean
)
