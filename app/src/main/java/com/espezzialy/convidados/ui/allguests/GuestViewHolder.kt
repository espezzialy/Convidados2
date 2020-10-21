package com.espezzialy.convidados.ui.allguests

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.espezzialy.convidados.R
import com.espezzialy.convidados.service.model.GuestModel
import com.espezzialy.convidados.ui.listener.GuestListener

class GuestViewHolder(itemView: View, val listener: GuestListener) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val nameLayout = itemView.findViewById<LinearLayout>(R.id.name_layout)
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name

        val textPresence = itemView.findViewById<TextView>(R.id.text_presence)
        if (guest.presence) {
            textPresence.text = "Presente"
        } else {
            textPresence.text = "Ausente"
        }

        nameLayout.setOnClickListener {
            listener.onClick(guest.id)
        }

        nameLayout.setOnLongClickListener {
            var message = it.context.getString(R.string.deseja_remover, textName.text.toString())
            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(message)
                .setPositiveButton(R.string.remover) { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNeutralButton(R.string.cancelar, null)
                .show()

            true
        }
    }
}