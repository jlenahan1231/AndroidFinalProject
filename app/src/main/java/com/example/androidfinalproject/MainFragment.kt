package com.example.androidfinalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.ui.NavigationUI
import androidx.navigation.findNavController
import com.example.androidfinalproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.activityButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToActivitiesFragment()
            rootView.findNavController().navigate(action)
        }
        binding.schoolButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSchoolFragment()
            rootView.findNavController().navigate(action)
        }
        binding.journalButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToJournalFragment()
            rootView.findNavController().navigate(action)
        }
        binding.listButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToCheckListFragment()
            rootView.findNavController().navigate(action)
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return NavigationUI.onNavDestinationSelected(menuItem, requireView().findNavController())
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}