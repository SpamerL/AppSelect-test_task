package com.kryak.appselect_test_task.domain

import androidx.paging.PagingData
import com.kryak.appselect_test_task.data.dto.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReviewListUseCase @Inject constructor(
    private val repo: ReviewRepository
) {
    fun execute(): Flow<PagingData<Result>> = repo.getReviewList()
}