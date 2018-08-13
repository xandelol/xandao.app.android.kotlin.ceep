package xandao.kotlin.com.ceep.dialog

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.form_note.view.*
import xandao.kotlin.com.ceep.retrofit.NoteWebClient
import xandao.kotlin.com.ceep.R
import xandao.kotlin.com.ceep.model.Note

class NoteDialog(private val context:Context,
                 private val viewGroup: ViewGroup){
    private val createdView = createView()
    private val titleField = createdView.form_note_title
    private val descriptionField = createdView.form_note_description

    fun add(created:(createdNote:Note)-> Unit){
        AlertDialog.Builder(context)
                .setTitle("Add note")
                .setView(createdView)
                .setPositiveButton("Save") { _, _ ->
                    val title = titleField.text.toString()
                    val description = descriptionField.text.toString()
                    val note = Note(title = title, description = description)
                    NoteWebClient().insert(note,{
                        created(it)
                    },{
                        Toast.makeText(context, "Falha ao salvar nota", Toast.LENGTH_SHORT).show()
                    })
                }
                .show()
    }

    fun alter(note: Note, altered:(altered:Note)->Unit){
        titleField.setText(note.title)
        descriptionField.setText(note.description)
        AlertDialog.Builder(context)
                .setTitle("Alter note")
                .setView(createdView)
                .setPositiveButton("Alter"){_,_->
                    val title = titleField.text.toString()
                    val description = descriptionField.text.toString()
                    val alteredNote = note.copy(title = title, description = description)
                    NoteWebClient().alter(alteredNote,{
                        altered(it)
                    },{
                        Toast.makeText(context,"Falha ao alterar nota",Toast.LENGTH_SHORT).show()
                    })
                }
                .show()
    }

    fun delete(note: Note, deleted:(id:Int)->Unit){
        titleField.setText(note.title)
        AlertDialog.Builder(context)
                .setTitle("Delete "+titleField.text+" note?")
                .setPositiveButton("Delete"){_,_ ->
                    NoteWebClient().delete(note,{
                        deleted(it)
                    },{
                        Toast.makeText(context,"Falha ao deletar nota", Toast.LENGTH_SHORT).show()
                    })

                }
                .show()
    }

    private fun createView():View{
        return LayoutInflater.from(context).inflate(R.layout.form_note,
                viewGroup, false)
    }
}