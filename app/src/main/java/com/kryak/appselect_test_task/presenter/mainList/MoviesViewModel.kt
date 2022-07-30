package com.kryak.appselect_test_task.presenter.mainList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kryak.appselect_test_task.data.dto.Result
import com.kryak.appselect_test_task.domain.ReviewListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.* // ktlint-disable no-wildcard-imports
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: ReviewListUseCase
) : ViewModel() {

    private val _moviesFlow: MutableStateFlow<PagingData<Result>> = MutableStateFlow(PagingData.empty())
    val moviesFlow: StateFlow<PagingData<Result>> get() = _moviesFlow

    init {
        getMoviesList()
    }

    private fun getMoviesList() {
        useCase.execute()
            .onEach { _moviesFlow.value = it }
            .flowOn(Dispatchers.IO)
            .catch { e -> e.printStackTrace() }
            .cachedIn(viewModelScope)
            .distinctUntilChanged()
            .launchIn(viewModelScope)
    }
}
