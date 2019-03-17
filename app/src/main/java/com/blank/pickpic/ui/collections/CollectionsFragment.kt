package com.blank.pickpic.ui.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blank.pickpic.databinding.CollectionsFragmentBinding


class CollectionsFragment : Fragment() {
    private lateinit var binding: CollectionsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        CollectionsFragmentBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

}