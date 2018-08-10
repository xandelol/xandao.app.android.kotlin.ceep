package xandao.kotlin.com.ceep.dialog

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.form_note.view.*
import xandao.kotlin.com.ceep.NoteWebClient
import xandao.kotlin.com.ceep.R
import xandao.kotlin.com.ceep.model.Note

class AddNoteDialog(private val context:Context,
                    private val viewGroup: ViewGroup){
    fun show(created:(createdNote:Note)-> Unit){
        val createdView = LayoutInflater.from(context).inflate(R.layout.form_note,
                viewGroup, false)

        AlertDialog.Builder(context)
                .setTitle("Add note")
                .setView(createdView)
                .setPositiveButton("Save") { _, _ ->
                    val title = createdView.form_note_title.text.toString()
                    val description = createdView.form_note_description.text.toString()
                    val note = Note(title, description)
                    NoteWebClient().insert(note,{
                        created(it)
                    },{
                        Toast.makeText(context, "Falha ao salvar nota", Toast.LENGTH_SHORT).show()
                    })
                }
                .show()
    }
}