package com.example.second_home_task

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.example.second_home_task.databinding.FragmentElementBinding
import com.example.second_home_task.model.Element

class ElementFragment : Fragment() {
    private lateinit var binding: FragmentElementBinding
    private var element: Element? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater.from(requireContext())
                .inflateTransition(android.R.transition.move)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentElementBinding.inflate(inflater)
        val arg = arguments
        if (arg != null) {
            element = arg.getParcelable("element")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            tvOurElementDescription.text = element?.description ?: "no info"
            tvOurElementTitle.text = element?.title ?: "no info"
            element?.let { ivOurElementDrawable.setImageResource(it.image) }
            toolbar.setNavigationOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }
            buttonExit.setOnClickListener {
                requireActivity().finish()
            }
            ViewCompat.setTransitionName(ivOurElementDrawable, "FinishView")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(element: Element): ElementFragment {
            val fragment = ElementFragment()
            val args = Bundle()
            args.putParcelable("element", element)
            fragment.arguments = args
            return fragment
        }
    }
}