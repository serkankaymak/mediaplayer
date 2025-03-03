package com.betelgeuse.wallplayer.shared.ui
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FlexRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start, // Varsayılan olarak baştan hizalama
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement, // Düzeltildi
        verticalAlignment = verticalAlignment
    ) {
        content()
    }
}


@Preview(name = "FlexRow", showBackground = true)
@Composable
fun PreviewFlexRow() {
    FlexRow() {
        Button(onClick = {}) {
            Text(text = "Button 1")
        }
        Button(onClick = {}) {
            Text(text = "Button 2")
        }
        Button(onClick = {}) {
            Text(text = "Button 3")
        }
    }
}
