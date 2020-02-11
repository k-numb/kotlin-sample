package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * タスクテーブルのモデルクラス
 */
@Entity
@Table(name = "tasks")
data class Task(
    /** タスクID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    /** 内容 */
    val content: String,
    /** 進捗 */
    val done: Boolean = false
)
