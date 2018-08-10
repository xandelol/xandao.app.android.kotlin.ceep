package xandao.kotlin.com.ceep.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_list.*
import xandao.kotlin.com.ceep.NoteWebClient
import xandao.kotlin.com.ceep.R
import xandao.kotlin.com.ceep.dialog.AddNoteDialog
import xandao.kotlin.com.ceep.model.Note
import xandao.kotlin.com.ceep.ui.adapter.NoteListAdapter

class NoteListActivity : AppCompatActivity() {

    private val notes : MutableList<Note> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        NoteWebClient().list({
            notes.addAll(it)
            configureList()
        },{
            Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_SHORT).show()
        })

        fab_add_note.setOnClickListener {
            AddNoteDialog(this,
                    window.decorView as ViewGroup)
                    .show {
                        notes.add(it)
                        configureList()
                    }
        }
    }

    private fun configureList() {
        val recyclerView = note_list_recyclerview
        recyclerView.adapter = NoteListAdapter(notes, this)
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}
