package com.example.mydiffadapter.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mydiffadapter.R
import com.example.mydiffadapter.databinding.FragmentHomeBinding
import com.example.mydiffadapter.ui.main.activity.MainActivity
import com.example.mydiffadapter.utils.extension.setUpLanguage
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomeFragment : Fragment() {
    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSelect.setOnClickListener {
            val newIntent = Intent(requireContext(), MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("HOME_FRG", "GO_TO_LANGUAGE_FRG")
            newIntent.putExtras(bundle)
            newIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(newIntent)
        }
    }

    override fun onResume() {
        super.onResume()
//        binding.btnSelect.text = requireContext().setUpLanguage().getString(R.string.select_language)

    }


}