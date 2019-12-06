package api

import com.hanseltritama.networking.data.RepoResult
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/repositories")
    fun retrieveRepositories(): Call<RepoResult>

    @GET("/search/repositories?q=language:kotlin&sort=stars&order=desc")
    fun searchRepositories(): Call<RepoResult>
}