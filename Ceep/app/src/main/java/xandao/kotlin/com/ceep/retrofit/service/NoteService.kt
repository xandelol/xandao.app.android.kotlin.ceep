package xandao.kotlin.com.ceep.retrofit.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import xandao.kotlin.com.ceep.model.Note

interface NoteService {
    @GET("notes")
    fun list(): Call<List<Note>>

    @POST("notes")
    fun insert(@Body note: Note): Call<Note>
}