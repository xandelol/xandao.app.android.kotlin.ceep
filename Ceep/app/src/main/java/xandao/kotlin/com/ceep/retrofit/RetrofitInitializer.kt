package xandao.kotlin.com.ceep.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xandao.kotlin.com.ceep.retrofit.service.NoteService

class RetrofitInitializer{
    private val retrofit = Retrofit.Builder()
                .baseUrl("http://172.16.5.122:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    fun noteService() = retrofit.create(NoteService::class.java)

}