package com.githubusers.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.githubusers.data.model.local.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<UserEntity>?

    @Query("SELECT * FROM user WHERE login = :userLogin")
    suspend fun getUserByLogin(userLogin: String): UserEntity?

    @Query("UPDATE user SET name = :name, location = :location WHERE id = :userId")
    suspend fun update(name: String, location: String, userId: Int)

    @Query("UPDATE user SET isSaved = :isSaved WHERE id = :userId")
    suspend fun update(isSaved: Boolean, userId: Int)

    @Insert
    suspend fun insertUsers(users: List<UserEntity>)

    @Insert
    suspend fun insertUser(user: UserEntity)
}