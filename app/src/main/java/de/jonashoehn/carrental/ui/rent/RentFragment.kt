package de.jonashoehn.carrental.ui.rent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import de.jonashoehn.carrental.databinding.FragmentRentBinding

class RentFragment : Fragment() {

    private lateinit var homeViewModel: RentViewModel
    private var _binding: FragmentRentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(RentViewModel::class.java)

        _binding = FragmentRentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRent
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}