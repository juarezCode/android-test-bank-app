package com.upax.testbankapp.addcard

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.upax.testbankapp.databinding.FragmentAddCardBinding
import com.upax.testbankapp.models.NewCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCardFragment : Fragment() {

    private var _binding: FragmentAddCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCardBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddCardCancel.setOnClickListener {
            it.findNavController().navigateUp()
        }

        binding.btnAddCardAcept.setOnClickListener {


            val newCard = NewCard(
                number = binding.newCardNumber.text.toString().validateInt(),
                account = binding.newCardAccount.text.toString(),
                issure = binding.newCardIssure.text.toString(),
                name = binding.newCardName.text.toString(),
                brand = binding.newCardBrand.text.toString(),
                status = binding.newCardBrand.text.toString(),
                balance = binding.newCardBalance.text.toString().validateInt(),
                type = binding.newCardAccountType.text.toString()
            )

            showDialog(newCard)
        }


    }

    private fun String?.validateInt(): Int {
        if (this.isNullOrEmpty()) return 0

        return this.toInt()
    }

    private fun showDialog(newCard: NewCard) {
        val jsonCard = Gson().toJson(newCard)

        AlertDialog.Builder(requireContext())
            .setTitle("Datos")
            .setMessage(jsonCard)
            .create()
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}