package com.example.esieaandroid4a.presentation.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.esieaandroid4a.data.remote.entity.Event

class ListAdapter(private val list: List<Event>)
    : RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event: Event = list[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = list.size

}

