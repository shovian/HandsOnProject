package com.example.handsonproject


import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.handsonproject.databinding.ActivityMainBinding
import com.example.handsonproject.databinding.ActivityMainBinding.inflate

enum class Operation{
    PLUS,MINUS,MULTIPLY,DIVIDE,MAIN_STATUS
}
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var operation : Operation = Operation.MAIN_STATUS

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        with(binding){
            stash.text=""
            input.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable){}
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(input.text.toString().length>20) {
                        input.setText("")
                        AlertDialog
                            .Builder(this@MainActivity)
                            .setTitle(getString(R.string.error_title))
                            .setMessage(getString(R.string.error_message_too_long))
                            .show()
                    }
                }
            })
        }
    }


    @SuppressLint("SetTextI18n")
    fun onTapB1(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) {
            input.setText(input.text.toString() + "1") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB2(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "2") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB3(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "3") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB4(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "4") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB5(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "5") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB6(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "6") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB7(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "7") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB8(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "8") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB9(@Suppress("UNUSED_PARAMETER") view: View){
        with(binding) { input.setText(input.text.toString() + "9") }
    }

    @SuppressLint("SetTextI18n")
    fun onTapB0(@Suppress("UNUSED_PARAMETER")view: View){
        with(binding) { input.setText(input.text.toString() + "0") }
    }
    fun formattingDecimal(num: Double) : String{
        return if(num%1==0.0) num.toInt().toString()
        else num.toString()
    }
    fun onTapBEqual(@Suppress("UNUSED_PARAMETER") view: View){
        with(binding){
            if (input.text.toString().isNotEmpty() && stash.text.toString().isNotEmpty()){
                var res = 0.0
                when (operation) {
                    Operation.PLUS -> {
                        res =
                            input.text.toString().toDouble() + stash.text.toString().toDouble()
                    }
                    Operation.MINUS -> {
                        res =
                            stash.text.toString().toDouble() - input.text.toString().toDouble()
                    }
                    Operation.MULTIPLY -> {
                        res =
                            input.text.toString().toDouble() * stash.text.toString().toDouble()
                    }
                    Operation.DIVIDE -> {
                        val divisor = input.text.toString().toDouble()

                        if (divisor != 0.0) {
                            res = stash.text.toString().toDouble() / divisor
                        } else {
                            AlertDialog
                                .Builder(this@MainActivity)
                                .setTitle(getString(R.string.error_title))
                                .setMessage(getString(R.string.error_message))
                                .show()
                        }
                    }
                    Operation.MAIN_STATUS -> {
                      // do nothing
                    }
                }
                input.setText(formattingDecimal(res))
                stash.text = ""
            }
            operation=Operation.MAIN_STATUS
        }
    }
    fun onTapBPlus(view: View){
        with(binding) {
            if (operation==Operation.MAIN_STATUS) {
                if(input.text.toString().isNotEmpty()) stash.text = input.text.toString()
                operation = Operation.PLUS
            }
            else {
                onTapBEqual(view)
                onTapBPlus(view)
            }
            input.setText("")
        }
    }
    fun onTapBMinus(view: View){
        with(binding) {
            if (operation==Operation.MAIN_STATUS) {
                if(input.text.toString().isNotEmpty()) stash.text = input.text.toString()
                operation=Operation.MINUS
            }
            else {
                onTapBEqual(view)
                onTapBMinus(view)
            }
            input.setText("")
        }
    }
    fun onTapBMultiply(view: View){
        with(binding) {
            if (operation==Operation.MAIN_STATUS) {
                if(input.text.toString().isNotEmpty()) stash.text = input.text.toString()
                operation=Operation.MULTIPLY
            }
            else {
                onTapBEqual(view)
                onTapBMultiply(view)
            }
            input.setText("")
        }
    }
    fun onTapBDivide(view: View){
        with(binding) {
            if (operation==Operation.MAIN_STATUS) {
                if(input.text.toString().isNotEmpty()) stash.text = input.text.toString()
                operation=Operation.DIVIDE
            }
            else {
                onTapBEqual(view)
                onTapBDivide(view)
            }
            input.setText("")
        }
    }
    fun onTapBClear(@Suppress("UNUSED_PARAMETER") view: View){
        with(binding) {
            stash.text = ""
            operation=Operation.MAIN_STATUS
            input.setText("")
        }
    }
}