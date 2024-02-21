package com.sahil.helperclassproject

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper private constructor(context: Context) {


    companion object {
        private var instance: SharedPrefHelper? = null

        fun getInstance(context: Context): SharedPrefHelper {
            return instance ?: synchronized(this) {
                instance ?: SharedPrefHelper(context).also { instance = it }
            }
        }
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("SharedPrefHelper", Context.MODE_PRIVATE)

    // Save email to shared preferences
    fun saveString(key: String = Keys.STRING_KEY, str: String) {
        sharedPreferences.edit().putString(key, str).apply()
    }

    // Retrieve email from shared preferences
    fun getString(key: String = Keys.STRING_KEY): String? {
        return sharedPreferences.getString(key, null)
    }

    fun clearString(key: String = Keys.STRING_KEY) {
        sharedPreferences.edit().remove(key).apply()
    }


    var isBoolean: Boolean
        get() = sharedPreferences.getBoolean(Keys.IS_CHECK, false)
        set(newValue) {
            sharedPreferences.edit().putBoolean(Keys.IS_CHECK, newValue).apply()
        }
}
