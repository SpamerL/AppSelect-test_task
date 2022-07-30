package com.kryak.appselect_test_task.data.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kryak.appselect_test_task.data.dto.Result
import com.kryak.appselect_test_task.data.remote.api.NYTApi
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ReviewsPagingSource @Inject constructor(
    private val api: NYTApi
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPos = state.closestPageToPosition(anchorPosition)
            anchorPos?.prevKey?.plus(1) ?: anchorPos?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val offset = params.key ?: 0
            val response = api.getReviews(offset)
            LoadResult.Page(
                data = response.body()!!.results,
                nextKey = if (response.body()!!.hasMore) offset + 20 else null,
                prevKey = if (offset >= 20) offset - 20 else null
            )
        } catch (e: IOException) {
            // IOException for network failures.
            LoadResult.Error(e)
        } catch (e: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            LoadResult.Error(e)
        }
    }
}
