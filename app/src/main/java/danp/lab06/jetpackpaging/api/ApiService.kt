package danp.lab06.jetpackpaging.api

import danp.lab06.jetpackpaging.model.CEMResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    suspend fun getCEMResponse(
    ):Response<CEMResponse>
}