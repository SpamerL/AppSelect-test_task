package com.kryak.appselect_test_task.presenter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.kryak.appselect_test_task.presenter.mainList.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition() { true }
        finish()
        startListActivity()
    }

    private fun startListActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
