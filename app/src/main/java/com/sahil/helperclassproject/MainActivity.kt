package com.sahil.helperclassproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sahil.helperclassproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPrefHelper: SharedPrefHelper
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefHelper= SharedPrefHelper.getInstance(this)
        binding.apply {
            btnS.setOnClickListener {
                sharedPrefHelper.apply {
                    sharedPrefHelper.isBoolean = !isBoolean
                    sharedPrefHelper.saveString(Keys.STRING_USR_NAME,editText2.text.toString().trim())
                    sharedPrefHelper.saveString(Keys.STRING_EMAIL,editText.text.toString().trim())
                }
            }

            btnGetValue.setOnClickListener {
                sharedPrefHelper.apply {
                    userName.text = getString(Keys.STRING_USR_NAME)
                    userEmailId.text = getString(Keys.STRING_EMAIL)
                    booleanCheck.text = isBoolean.toString()
                }
            }
        }
    }
}