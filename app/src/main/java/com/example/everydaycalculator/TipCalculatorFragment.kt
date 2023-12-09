package com.example.everydaycalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal

class TipCalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tip_calculator, container, false)

        val calculateButton = view.findViewById<Button>(R.id.btnCalculateTip)

        calculateButton.setOnClickListener {
            val amount = view.findViewById<EditText>(R.id.etTotalAmount).getText().toString()
            val tipPercent = view.findViewById<EditText>(R.id.etTipPercent).getText().toString()
            val totalAmount = BigDecimal(amount.toDouble() *
                    (tipPercent.toDouble() / 100))
            val finalAmount = view.findViewById<TextView>(R.id.tvTipAmount)
            finalAmount.setText("$" + "%.2f".format(totalAmount))
        }
        return view
    }
}