package com.example.myapplication.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.R
import org.koin.android.viewmodel.ext.android.viewModel

class SettingsFragment : Fragment() {

    val settingsViewModel : SettingsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        settingsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}