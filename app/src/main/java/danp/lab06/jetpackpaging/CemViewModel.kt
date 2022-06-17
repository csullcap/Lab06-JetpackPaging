package danp.lab06.jetpackpaging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import danp.lab06.jetpackpaging.api.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import danp.lab06.jetpackpaging.paging.CEMPagingSource
import javax.inject.Inject

@HiltViewModel
class CemViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    val pager = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 5),
        pagingSourceFactory = { CEMPagingSource(apiService = apiService) }
    ).flow.cachedIn(viewModelScope)


}