package com.blank.pickpic.ui.newup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blank.pickpic.databinding.NewUpFragmentBinding


class NewUpFragment : Fragment() {

    private lateinit var binding: NewUpFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        NewUpFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

}