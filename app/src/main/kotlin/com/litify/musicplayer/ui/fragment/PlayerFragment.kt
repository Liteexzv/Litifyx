package com.litify.musicplayer.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.litify.musicplayer.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {

    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPlayControls()
        setupSpeedControls()
    }

    private fun setupPlayControls() {
        binding.btnPlay.setOnClickListener { }
    }

    private fun setupSpeedControls() {
        binding.btnSpeed05.setOnClickListener { }
        binding.btnSpeed075.setOnClickListener { }
        binding.btnSpeed10.setOnClickListener { }
        binding.btnSpeed125.setOnClickListener { }
        binding.btnSpeed15.setOnClickListener { }
        binding.btnSpeed20.setOnClickListener { }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}