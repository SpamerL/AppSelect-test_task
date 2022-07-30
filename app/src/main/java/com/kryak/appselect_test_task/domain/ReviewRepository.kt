package com.kryak.appselect_test_task.domain

import androidx.paging.PagingData
import com.kryak.appselect_test_task.data.dto.Result
import kotlinx.coroutines.flow.Flow

interface ReviewRepository {

    fun getReviewList(): Flow<PagingData<Result>>
}