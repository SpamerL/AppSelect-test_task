package com.kryak.appselect_test_task.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kryak.appselect_test_task.data.dto.Result
import com.kryak.appselect_test_task.data.pagination.ReviewsPagingSource
import com.kryak.appselect_test_task.data.remote.api.NYTApi
import com.kryak.appselect_test_task.domain.ReviewRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: NYTApi
) : ReviewRepository {
    override fun getReviewList(): Flow<PagingData<Result>> {
        return Pager(
            PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = { ReviewsPagingSource(api) }
        ).flow
    }
}
