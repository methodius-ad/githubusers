package com.githubusers.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val name: String? = null,
    val location: String? = null,
    val isSaved: Boolean
)