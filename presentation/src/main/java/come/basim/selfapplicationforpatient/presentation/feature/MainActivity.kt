package come.basim.selfapplicationforpatient.presentation.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import come.basim.selfapplicationforpatient.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}