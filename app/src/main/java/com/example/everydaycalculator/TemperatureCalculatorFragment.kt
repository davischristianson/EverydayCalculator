package com.example.everydaycalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.findFragment

class TemperatureCalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_temperature_calculator, container, false)
        val calculateButton = view.findViewById<Button>(R.id.btnCalculateTemperature)
        val spinnerOne = view.findViewById<Spinner>(R.id.spnTemperatureOne)
        val spinnerTwo = view.findViewById<Spinner>(R.id.spnTemperatureTwo)

        calculateButton.setOnClickListener {
            val selectedSpinnerOne = spinnerOne.selectedItem.toString()
            val selectedSpinnerTwo = spinnerTwo.selectedItem.toString()

            val tempToConvert = view.findViewById<EditText>(R.id.etTemperatureOne).getText().toString()
            var finalTemperature : Double
            val convertedTemperature = view.findViewById<TextView>(R.id.tvFinalTemperature)

            // Fahrenheit conversions
            if(selectedSpinnerOne == "Fahrenheit" && selectedSpinnerTwo == "Celsius") {
                finalTemperature = (tempToConvert.toDouble() - 32) * (5 / 9.0)
                convertedTemperature.setText("%.2f".format(finalTemperature))
            }
            if(selectedSpinnerOne == "Fahrenheit" && selectedSpinnerTwo == "Fahrenheit") {
                convertedTemperature.setText(tempToConvert)
            }
            if(selectedSpinnerOne == "Fahrenheit" && selectedSpinnerTwo == "Kelvin") {
                finalTemperature = (tempToConvert.toDouble() - 32) * (5 / 9.0) + 273.15
                convertedTemperature.setText("%.2f".format(finalTemperature))
            }

            // Celsius conversions
            if(selectedSpinnerOne == "Celsius" && selectedSpinnerTwo == "Fahrenheit") {
                finalTemperature = (tempToConvert.toDouble() * (9.0 / 5)) + 32
                convertedTemperature.setText("%.2f".format(finalTemperature))
            }
            if(selectedSpinnerOne == "Celsius" && selectedSpinnerTwo == "Celsius") {
                convertedTemperature.setText(tempToConvert)
            }
            if(selectedSpinnerOne == "Celsius" && selectedSpinnerTwo == "Kelvin") {
                finalTemperature = tempToConvert.toDouble() + 273.15
                convertedTemperature.setText("%.2f".format(finalTemperature))
            }

            // Kelvin conversions
            if(selectedSpinnerOne == "Kelvin" && selectedSpinnerTwo == "Fahrenheit") {
                finalTemperature = (tempToConvert.toDouble() - 273.15) * 9.0 / 5 + 32
                convertedTemperature.setText("%.2f".format(finalTemperature))
            }
            if(selectedSpinnerOne == "Kelvin" && selectedSpinnerTwo == "Celsius") {
                finalTemperature = tempToConvert.toDouble() - 273.15
                convertedTemperature.setText("%.2f".format(finalTemperature))
            }
            if(selectedSpinnerOne == "Kelvin" && selectedSpinnerTwo == "Kelvin") {
                convertedTemperature.setText(tempToConvert)
            }
        }

        return view
    }
}