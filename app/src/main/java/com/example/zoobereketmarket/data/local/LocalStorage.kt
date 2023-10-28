package com.example.zoobereketmarket.data.local

import android.content.Context
import com.example.zoobereketmarket.utils.BooleanPreference
import com.example.zoobereketmarket.utils.StringPreference
import com.example.zoobereketmarket.app.App

class LocalStorage {

    companion object {
        val pref =
            App.instance.getSharedPreferences("GitHubSharedPref", Context.MODE_PRIVATE)
    }

    var token by StringPreference(pref)

    var isLogin by BooleanPreference(pref, false)

    var username by StringPreference(pref)

    var password by StringPreference(pref)

    var phone by StringPreference(pref)
}