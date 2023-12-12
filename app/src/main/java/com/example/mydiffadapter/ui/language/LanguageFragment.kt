package com.example.mydiffadapter.ui.language

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiffadapter.data.DataManager
import com.example.mydiffadapter.databinding.FragmentLanguageBinding
import com.example.mydiffadapter.model.NationUI
import com.example.mydiffadapter.ui.main.activity.MainActivity
import com.example.mydiffadapter.ui.main.adapter.NationAdapter
import com.example.mydiffadapter.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class LanguageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    @Inject
    lateinit var dataManager: DataManager
    private lateinit var listNation: MutableList<NationUI>

    private val nationAdapter: NationAdapter by lazy { NationAdapter {} }
    private lateinit var binding: FragmentLanguageBinding

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
        binding = FragmentLanguageBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listNation = Utils.getListNation(requireContext())
        setupRecyclerView()
        binding.btnBack.setOnClickListener {
//            requireActivity().finish()
            val newIntent = Intent(requireContext(), MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("LANGUAGE_FRG", "GO_TO_HOME_FRG")
            newIntent.putExtras(bundle)
            newIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(newIntent)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LanguageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setupRecyclerView() {
        nationAdapter.setData(listNation)
        binding.rvUser.run {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = nationAdapter
        }
        nationAdapter.onClickItem = { nationUI ->
            val index = listNation.indexOf(nationUI)
            for (i in 0 until listNation.size) {
                if (listNation[i].isCheck == true) {
                    listNation[i].isCheck = false
                    nationAdapter.notifyItemChanged(i)
                    break
                }
            }
            listNation[index].isCheck = true
            nationAdapter.notifyItemChanged(index)
            listNation[index].code.let { dataManager.saveNationCode(it) }
        }
    }
}