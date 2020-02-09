package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tasks")
data class Task(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                val id: Long,
                val content: String,
                val done: Boolean)
