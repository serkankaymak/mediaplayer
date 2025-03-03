package com.betelgeuse.wallplayer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.betelgeuse.wallplayer.R
import com.betelgeuse.wallplayer.shared.ui.FlexCol
import com.betelgeuse.wallplayer.shared.ui.FlexRow

@Composable
fun FileItemView(
    modifier: Modifier = Modifier,
    isSelectingState: Boolean = false,
    isGrid: Boolean,
    onClick: () -> Unit = {},
    onOptionClick: () -> Unit = {}
) {
    if (!isGrid) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clickable(onClick = onClick)
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            FlexRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FlexRow {
                    Image(
                        painter = painterResource(id = R.drawable.video_file),
                        contentDescription = "Video",
                        modifier = Modifier.size(120.dp)
                    )
                    FlexCol(gap = 10.dp) {
                        Text("Video Name")
                        Text("Description")
                    }
                }
                Box(modifier = Modifier.wrapContentSize()) {
                    if (isSelectingState) {
                        Checkbox(
                            checked = true,
                            onCheckedChange = {},
                            modifier = Modifier,
                            enabled = true,
                            colors = CheckboxDefaults.colors()
                        )
                    }
                    if (!isSelectingState) {
                        IconButton(onClick = onOptionClick) {
                            Image(
                                painter = painterResource(id = R.drawable.more_vert_24),
                                contentDescription = "Video"
                            )
                        }
                    }
                }
            }
        }
    } else {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            FlexCol {
                FlexRow(
                    modifier = Modifier.fillMaxWidth(),
                    gap = 0.dp,
                    horizontalArrangement = Arrangement.Center
                ) {
                    FlexCol(gap = 15.dp) {
                        Box(modifier = Modifier.wrapContentSize()) {
                            Image(
                                painter = painterResource(id = R.drawable.video_file),
                                contentDescription = "Video",
                                modifier = Modifier.size(120.dp)
                            )
                            if (!isSelectingState) {
                                IconButton(
                                    onClick = onOptionClick,
                                    modifier = Modifier.align(Alignment.TopEnd)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.more_vert_24),
                                        contentDescription = "Video"
                                    )
                                }
                            }
                            if (isSelectingState) {
                                Checkbox(
                                    modifier = Modifier.align(Alignment.TopEnd),
                                    checked = true,
                                    onCheckedChange = {},
                                    enabled = true,
                                    colors = CheckboxDefaults.colors()
                                )
                            }
                        }
                        FlexCol(gap = 5.dp) {
                            Text("Video Name")
                            Text("Description")
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "VideoView - Grid", showBackground = true)
@Composable
private fun PreviewVideoViewGrid() {
    FileItemView(isGrid = false, onClick = { /* onClick action */ })
}

@Preview(name = "VideoView - List", showBackground = true)
@Composable
private fun PreviewVideoViewList() {
    FileItemView(isGrid = true, onClick = { /* onClick action */ })
}
