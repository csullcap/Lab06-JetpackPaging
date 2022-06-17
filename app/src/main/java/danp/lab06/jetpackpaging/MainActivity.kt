package danp.lab06.jetpackpaging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import danp.lab06.jetpackpaging.ui.theme.JetpackPagingTheme
import danp.lab06.jetpackpaging.views.CEMList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackPagingTheme {
                    MainView()
            }
        }
    }
}


@Composable
fun MainView(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.error)
            .padding(20.dp)
    ){ CEMList() }

}











