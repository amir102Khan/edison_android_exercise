package jp.speakbuddy.edisonandroidexercise.ui.fact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import jp.speakbuddy.edisonandroidexercise.ui.theme.EdisonAndroidExerciseTheme

@Composable
fun FactScreen(
    viewModel: FactViewModel = hiltViewModel()
) {
    val factResponse = viewModel.response
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterVertically
        )
    ) {

        Text(
            text = "Fact",
            style = MaterialTheme.typography.titleLarge
        )

        if (factResponse.fact.contains("Cats")) {
            Text(
                text = "Multiple cats!!",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Text(
            text = factResponse.fact,
            style = MaterialTheme.typography.bodyLarge
        )

        if (factResponse.length > 100) {
            Text(
                text = "Length ${factResponse.length}",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        val onClick = {
            viewModel.updateFact()
        }

        Button(onClick = onClick) {
            Text(text = "Update fact")
        }
    }
}

@Preview
@Composable
private fun FactScreenPreview() {
    EdisonAndroidExerciseTheme {
        FactScreen(viewModel = hiltViewModel())
    }
}
