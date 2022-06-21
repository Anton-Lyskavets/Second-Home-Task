package com.example.second_home_task.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.second_home_task.R
import com.example.second_home_task.databinding.ElementItemBinding
import com.example.second_home_task.model.Element

class ItemAdapter(
    private val dataset: List<Element>
) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    private var listener: AdaptersListener? = null
    fun setOnClickListener(onClickListener: AdaptersListener) {
        this.listener = onClickListener
    }

    inner class ItemHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ElementItemBinding.bind(item)
        fun bind(element: Element, holder: ItemHolder) = with(binding) {
            ivDefaultDrawable.setImageResource(element.image)
            tvDefaultTitle.text = element.title
            tvDefaultDescription.text = element.description
            initButtonsListeners(element, holder)
            ViewCompat.setTransitionName(
                holder.itemView.findViewById(R.id.iv_default_drawable),
                element.title
            )
        }

        private fun initButtonsListeners(element: Element, holder: ItemHolder) {
            binding.clItemElement.setOnClickListener {
                listener?.onClickItem(element, holder)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemHolder, position: Int) {
        val element: Element = dataset[position]
        holder.bind(element, holder)
    }

    override fun getItemCount(): Int = dataset.size
}