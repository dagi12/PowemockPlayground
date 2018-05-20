package pl.edu.amu.wmi.powermockplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (TestStatic.testMsg() != "hello mock") {
            throw RuntimeException()
        }
    }

}
