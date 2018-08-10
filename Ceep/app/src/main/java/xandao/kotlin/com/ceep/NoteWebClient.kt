package xandao.kotlin.com.ceep

import xandao.kotlin.com.ceep.model.Note
import xandao.kotlin.com.ceep.retrofit.RetrofitInitializer
import xandao.kotlin.com.ceep.retrofit.callback

class NoteWebClient{
    fun list(success: (notes: List<Note>) -> Unit,
             failure: (throwable: Throwable) -> Unit){
        val call = RetrofitInitializer().noteService().list()
        call.enqueue(callback { response, throwable ->
            response?.body()?.let {
                success(it)
            }
            throwable?.let {
                failure(it)
            }
        })
    }

    fun insert(note: Note, success:(notes:Note) -> Unit,
               failure: (throwable: Throwable) -> Unit){
        val call = RetrofitInitializer().noteService().insert(note)
        call.enqueue(callback { response, throwable ->
            response?.body()?.let {
                success(it)
            }
            throwable?.let {
                failure(it)
            }
        })
    }
}