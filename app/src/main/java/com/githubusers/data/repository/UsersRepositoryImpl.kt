package com.githubusers.data.repository

import com.githubusers.data.DataResult
import com.githubusers.data.api.ApiService
import com.githubusers.data.db.AppDatabase
import com.githubusers.data.model.local.UserEntity
import com.githubusers.data.repository.mapper.toUser
import com.githubusers.data.repository.mapper.toUserDetails
import com.githubusers.data.repository.mapper.toUserEntity
import com.githubusers.data.safeApiCall
import com.githubusers.domain.model.User
import com.githubusers.domain.model.UserDetails
import com.githubusers.domain.repository.UsersRepository

class UsersRepositoryImpl(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : UsersRepository {

    override suspend fun fetchUsers(): DataResult<List<User>> = safeApiCall {
        val userEntityList: List<UserEntity>? = appDatabase.userDao().getAllUsers()
        if (!userEntityList.isNullOrEmpty()) {
            DataResult.Success(userEntityList.map { it.toUser() })
        } else {
            val userList: List<User> = apiService.fetchUsers().map { it.toUser() }
            appDatabase.userDao().insertUsers(userList.map { it.toUserEntity() })
            DataResult.Success(userList)
        }
    }

    override suspend fun fetchUserDetails(userLogin: String): DataResult<UserDetails> =
        safeApiCall {
            val userEntity: UserEntity? = appDatabase.userDao().getUserByLogin(userLogin)
            DataResult.Success(
                apiService.fetchUserDetails(userLogin).toUserDetails(userEntity?.isSaved ?: false)
            )
        }

    override suspend fun changeSavedStatus(isSaved: Boolean, userId: Int) {
        appDatabase.userDao().update(isSaved, userId)
    }
}