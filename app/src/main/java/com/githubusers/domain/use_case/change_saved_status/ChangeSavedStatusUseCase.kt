package com.githubusers.domain.use_case.change_saved_status

interface ChangeSavedStatusUseCase {

    suspend operator fun invoke(isSaved: Boolean, userId: Int)
}