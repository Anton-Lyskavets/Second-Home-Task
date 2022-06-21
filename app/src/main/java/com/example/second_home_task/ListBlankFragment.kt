package com.example.second_home_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.second_home_task.adapter.AdaptersListener
import com.example.second_home_task.adapter.ItemAdapter
import com.example.second_home_task.data.DataSource
import com.example.second_home_task.databinding.FragmentListBlankBinding
import com.example.second_home_task.model.Element

class ListBlankFragment : Fragment(), AdaptersListener {
    private lateinit var binding: FragmentListBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myDataset = DataSource().loadElement()
        val adapter = ItemAdapter(myDataset)
        val recyclerView = binding.recyclerView
        adapter.setOnClickListener(this)
        recyclerView.apply {
            this.adapter = adapter
            layoutManager = GridLayoutManager(context, 1)
            setHasFixedSize(true)
        }
        postponeEnterTransition()
        recyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListBlankFragment()
    }

    override fun onClickItem(element: Element, holder: ItemAdapter.ItemHolder) {
        val activity = requireActivity() as MainActivity
        val elementFragment = ElementFragment.newInstance(element)
        activity.supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .addSharedElement(holder.itemView.findViewById(R.id.iv_default_drawable), "FinishView")
            .replace(R.id.fl_place_holder, elementFragment)
            .addToBackStack(null)
            .commit()
    }
}