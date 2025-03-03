package com.betelgeuse.wallplayer.shared.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FlexRow(
    modifier: Modifier = Modifier,
    gap: Dp = 0.dp,
    horizontalArrangement: Arrangement.Horizontal = if (gap > 0.dp) Arrangement.spacedBy(gap) else Arrangement.Center,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        content()
    }
}

@Preview(name = "FlexRow", showBackground = true)
@Composable
fun PreviewFlexRow() {
    FlexRow(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        gap = 5.dp,
    ) {
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