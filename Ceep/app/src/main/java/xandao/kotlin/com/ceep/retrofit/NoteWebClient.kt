package xandao.kotlin.com.ceep.retrofit

import xandao.kotlin.com.ceep.model.Note

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

    fun alter(note: Note, success: (notes: Note) -> Unit,
              failure: (throwable: Throwable) -> Unit){
        val call = RetrofitInitializer().noteService().alter(note, note.id)

        call.enqueue(callback { response, throwable ->
            response?.body()?.let {
                success(it)
            }
            throwable?.let {
                failure(it)
            }
        })
    }

    fun delete(note: Note, success: (id:Int) -> Unit,
               failure: (throwable: Throwable) -> Unit){
        val call = RetrofitInitializer().noteService().delete(note.id)
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