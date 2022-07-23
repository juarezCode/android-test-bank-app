package com.upax.testbankapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upax.testbankapp.databinding.FragmentHomeBinding
import com.upax.testbankapp.home.adapters.BalancesAdapter
import com.upax.testbankapp.home.adapters.CardsAdapter
import com.upax.testbankapp.home.adapters.MovementsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val balanceAdapter = BalancesAdapter()
    private val cardsAdapter = CardsAdapter()
    private val movementsAdapter = MovementsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerBalances.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = balanceAdapter
        }
        binding.recyclerCards.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cardsAdapter
        }
        binding.recyclerMovements.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = movementsAdapter
        }

        binding.progressBar.isVisible = true
        viewModel.getAccount()
        viewModel.getBalances()
        viewModel.getCards()
        viewModel.getMovements()

        binding.txtAddCard.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddCardFragment()
            it.findNavController().navigate(action)
        }

        viewModel.account.observe(viewLifecycleOwner) { account ->
            binding.txtName.text = account.name
            binding.txtLastSession.text = "Último inicio ${account.lastSession}"
        }

        viewModel.balances.observe(viewLifecycleOwner) { balances ->
            balanceAdapter.submitList(balances)
        }

        viewModel.cards.observe(viewLifecycleOwner) { cards ->
            cardsAdapter.submitList(cards)
        }

        viewModel.movements.observe(viewLifecycleOwner) { movements ->
            movementsAdapter.submitList(movements)
            binding.progressBar.isVisible = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}