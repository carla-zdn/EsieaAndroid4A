package com.example.esieaandroid4a.presentation.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esieaandroid4a.R
import com.example.esieaandroid4a.data.remote.entity.Event

class EventViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.row_layout, parent, false)) {
    private var txtArtistName: TextView? = null
    private var txtVenueName: TextView? = null
    private var txtDate: TextView? = null


    init {
        txtArtistName = itemView.findViewById(R.id.artistName)
        txtVenueName = itemView.findViewById(R.id.venue)
        txtDate = itemView.findViewById(R.id.date)
    }

    fun bind(event: Event) {
        var artistName: String = event.performance.get(0).displayName
        if (artistName.length > 27) {
            artistName = artistName.substring(27)
        }
        txtArtistName?.text = artistName

        var displayName: String = event.venue.displayName
        if (displayName.length > 45) {
            displayName = displayName.substring(0, 45)
        }
        txtVenueName?.text = displayName

        txtDate?.text = event.start.date
    }

}