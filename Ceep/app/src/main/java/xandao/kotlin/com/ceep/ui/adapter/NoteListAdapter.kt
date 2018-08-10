package xandao.kotlin.com.ceep.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.note_item.view.*
import xandao.kotlin.com.ceep.R
import xandao.kotlin.com.ceep.model.Note

class NoteListAdapter(private val notes: List<Note>,
                      private val context: Context) : Adapter<NoteListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.bindView(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(note: Note) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description
            title.text = note.title
            description.text = note.description
        }
    }

}

