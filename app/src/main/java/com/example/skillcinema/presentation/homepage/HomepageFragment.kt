package com.example.skillcinema.presentation.homepage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skillcinema.R
import com.example.skillcinema.databinding.FragmentHomepageBinding
import com.example.skillcinema.presentation.entities.ChildItemDataClass
import com.example.skillcinema.presentation.entities.ParentItemDataClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Math.floor
import kotlin.random.Random

@AndroidEntryPoint
class HomepageFragment : Fragment() {
    private var _binding: FragmentHomepageBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomepageViewModel by viewModels()
    private val listParentItem = mutableListOf<ParentItemDataClass>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomepageBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewParent.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = ParentAdapter(listParentItem)
        binding.recyclerViewParent.adapter = adapter
        Log.d("Mylog", "OnViewCreated")

        viewModel.apply {
            replenishPremier(getString(R.string.premier))
            replenishCollections(CollectionsType.TOP_POPULAR_ALL ,getString(R.string.popular))
            replenishFilmsFilter()
            replenishCollections(CollectionsType.TOP_250_MOVIES ,getString(R.string.top_250))
            replenishSeries(getString(R.string.series))
        }

            viewModel.listFilms.onEach {
                Log.d("Mylog", "OnViewCreated -> launch -> collect")
                it.forEach { (key, value) ->
                    Log.d("Mylog", "Key: $key")
                    listParentItem.add(
                        ParentItemDataClass(
                            key,
                            false,
                            value
                        )
                    )
                }

                withContext(Dispatchers.Main) {
                    adapter.setList(listParentItem)
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)

//        viewModel.listPopular.onEach {
//            Log.d("Mylog", "Open list popular COLLECT")
//
//            listParentItem.add(
//                ParentItemDataClass(
//                    getString(R.string.popular),
//                    true,
//                    it
//                )
//            )
//            Log.d("Mylog", "list parent item add --- Popular --- = ${it.items[0].nameEn}")
//            withContext(Dispatchers.Main) {
//                adapter.setList(listParentItem)
//            }
//        }.launchIn(viewLifecycleOwner.lifecycleScope)
//
//        viewModel.listFilmsFilter.onEach {
//            listParentItem.add(
//                ParentItemDataClass(
//                     it.items[0].genres[0].genre.replaceFirstChar {char -> char.uppercase() } + " " + it.items[0].countries[0].country,
//                    true,
//                    it
//                )
//            )
//
//            withContext(Dispatchers.Main) {
//                adapter.setList(listParentItem)
//            }
//        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}