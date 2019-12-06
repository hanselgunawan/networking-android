package api

import com.hanseltritama.networking.data.RepoResult
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {
    private val service: GithubService

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    init {
        val retrofit = Retrofit.Builder() // Creates a Retrofit object
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(GithubService::class.java)// an implementation of the GithubService interface using the Retrofit object
    }

    fun getRepositories(callback: Callback<RepoResult>) {
        val call = service.searchRepositories()
        call.enqueue(callback)// enqueue a network call. It will perform off the main thread
    }
}