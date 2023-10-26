package mhha.sample.mywebtoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mhha.sample.mywebtoon.databinding.FragmentSecondBinding
import mhha.sample.mywebtoon.databinding.FragmentWebviewBinding

class BFragment : Fragment() {
    private lateinit var binding : FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }//override fun onCreateView
} //class BFragment : Fragment()