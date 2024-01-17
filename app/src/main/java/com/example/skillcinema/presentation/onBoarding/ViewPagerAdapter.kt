package com.example.skillcinema.presentation.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.skillcinema.R
import com.example.skillcinema.databinding.SliderScreenBinding

class ViewPagerAdapter : RecyclerView.Adapter<SliderScreenHolder> () {

    private val listImage = listOf(R.drawable.know_screen, R.drawable.create_screen, R.drawable.share_screen)
    private val listDescription = listOf(
        R.string.know_screen_description,
        R.string.create_screen_description,
        R.string.share_screen_description
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderScreenHolder {
        val binding = SliderScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderScreenHolder(binding)
    }

    override fun getItemCount(): Int = listImage.size

    override fun onBindViewHolder(holder: SliderScreenHolder, position: Int) {

        with(holder.binding) {
            imageScreen.setImageResource(listImage[position])
            tvDescription.text = tvDescription.resources.getString(listDescription[position])
        }

    }
}

class SliderScreenHolder(val binding: SliderScreenBinding) : ViewHolder(binding.root)