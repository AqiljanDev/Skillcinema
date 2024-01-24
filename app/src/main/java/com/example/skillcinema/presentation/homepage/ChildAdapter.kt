package com.example.skillcinema.presentation.homepage

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.skillcinema.databinding.ChildItemBinding
import com.example.skillcinema.domain.entities.CollectionsFilms
import com.example.skillcinema.presentation.entities.ChildItemDataClass

class ChildAdapter(
    private val listChild: CollectionsFilms
) : RecyclerView.Adapter<ChildHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildHolder {
        val binding = ChildItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildHolder(binding)
    }

    override fun getItemCount(): Int = listChild.items.size

    override fun onBindViewHolder(holder: ChildHolder, position: Int) {
        val grade = listChild.items[position].ratingKinopoisk
        with(holder.binding) {
            tvName.text = listChild.items[position].nameRu
            tvGenres.text = listChild.items[position].genres.joinToString(", ") { it -> it.genre }
            tvGrade.text = grade?.toString() ?: "7.0"

            Glide.with(frameLayoutChild.context)
                .load(listChild.items[position].posterUrlPreview)
                .into(object :
                    CustomTarget<Drawable>() {
                    override fun onLoadCleared(placeholder: Drawable?) {
                        TODO("Not yet implemented")
                    }

                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        frameLayoutChild.background=resource
                    }

                })
        }

    }
}

class ChildHolder(val binding: ChildItemBinding) : ViewHolder(binding.root)