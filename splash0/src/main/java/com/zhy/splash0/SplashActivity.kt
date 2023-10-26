package com.zhy.splash0

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            //do some init things.
            startActivity(Intent(this, MainActivity::class.java))
        }, 3000)
    }
}