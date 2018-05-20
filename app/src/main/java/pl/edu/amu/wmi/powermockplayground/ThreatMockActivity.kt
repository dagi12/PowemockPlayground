package pl.edu.amu.wmi.powermockplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author Eryk Mariankowski <eryk.mariankowski></eryk.mariankowski>@247.codes> on 20.05.18.
 */
class ThreatMockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AssertHelper().youKnowWhatToDo()
    }

}
