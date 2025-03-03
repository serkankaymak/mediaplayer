package com.betelgeuse.wallplayer.shared.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FlexCol(
    modifier: Modifier = Modifier,
    gap: Dp = 0.dp,
    verticalArrangement: Arrangement.Vertical = if (gap > 0.dp) Arrangement.spacedBy(gap, Alignment.CenterVertically) else Arrangement.Center,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable () -> Unit
) {
    Column(
        modifier ,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        content()
    }
}

@Preview(name = "FlexCol", showBackground = true)
@Composable
fun PreviewFlexCol() {
    FlexCol(modifier = Modifier.fillMaxWidth().fillMaxHeight(), gap = 15.dp) {
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
