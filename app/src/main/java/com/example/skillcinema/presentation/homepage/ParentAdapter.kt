package com.example.skillcinema.presentation.homepage

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.skillcinema.databinding.ActivityMainBinding
import com.example.skillcinema.databinding.ParentItemBinding
import com.example.skillcinema.presentation.entities.ParentItemDataClass

class ParentAdapter(
    private var listParent: List<ParentItemDataClass>
) : RecyclerView.Adapter<ParentHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ParentItemDataClass>) {
        listParent = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentHolder {
        val binding = ParentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentHolder(binding)
    }

    override fun getItemCount(): Int = listParent.size

    override fun onBindViewHolder(holder: ParentHolder, position: Int) {
        with(holder.binding) {
            tvTitle.text = listParent[position].title
            tvAll.visibility = if (listParent[position].allVisible) View.VISIBLE else View.GONE
            recyclerViewChild.adapter = ChildAdapter(listParent[position].list)
        }
    }
}

class ParentHolder(val binding: ParentItemBinding) : ViewHolder(binding.root)