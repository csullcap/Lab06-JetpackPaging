package danp.lab06.jetpackpaging.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import danp.lab06.jetpackpaging.api.ApiService
import danp.lab06.jetpackpaging.model.CEM
import java.lang.Exception
import javax.inject.Inject

class CEMPagingSource @Inject constructor(private val apiService: ApiService): PagingSource<Int, CEM>(){

    override fun getRefreshKey(state: PagingState<Int, CEM>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CEM> {
        return   try{
            val prev = params.key?:0
            val response = apiService.getCEMResponse()
            if(response.isSuccessful){
                val body = response.body()?.data
                LoadResult.Page(
                    data= body!!,
                    prevKey = if(prev==0) null else prev-1,
                    nextKey = if(body.size<params.loadSize) null else prev+1
                )

            }else{
                LoadResult.Error(Exception())
            }


        }catch (e:Exception){
            LoadResult.Error(e)
        }


    }
}