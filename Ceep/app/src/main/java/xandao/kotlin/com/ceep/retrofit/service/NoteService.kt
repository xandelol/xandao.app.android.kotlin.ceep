package xandao.kotlin.com.ceep.retrofit.service

import retrofit2.Call
import retrofit2.http.*
import xandao.kotlin.com.ceep.model.Note

interface NoteService {
    @GET("notes")
    fun list(): Call<List<Note>>

    @POST("notes")
    fun insert(@Body note: Note): Call<Note>

    @PUT("notes/{id}")
    fun alter(@Body note:Note, @Path("id") id:Int): Call<Note>

    @DELETE("notes/{id}")
    fun delete(@Path("id") id:Int): Call<Int>
}