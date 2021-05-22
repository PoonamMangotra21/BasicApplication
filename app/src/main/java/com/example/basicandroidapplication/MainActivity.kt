package com.example.basicandroidapplication

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.addTextChangedListener {
            if (toggleButton.isChecked)
                textView.text = it.toString()
        }

        boldCB.setOnCheckedChangeListener { _, isChecked ->
            when(isChecked){
                true -> { textView.typeface = Typeface.DEFAULT_BOLD}
                false -> {textView.typeface = Typeface.DEFAULT}
            }
        }

        italicCB.setOnCheckedChangeListener { _, isChecked ->
            when(isChecked){
                true -> { textView.setTypeface(null, Typeface.ITALIC) }
                false -> {textView.setTypeface(null, Typeface.NORMAL) }
            }
        }

        serifRD.setOnCheckedChangeListener { _, isChecked ->
            when(isChecked){
                true -> { textView.typeface = Typeface.SERIF}
            }
        }

        sansRD.setOnCheckedChangeListener { buttonView, isChecked ->
            when(isChecked){
                true -> { textView.typeface = Typeface.SANS_SERIF}
            }
        }
        
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                textView.textSize = seekBar?.progress?.toFloat() ?: 10F
            }

        })

    }
}