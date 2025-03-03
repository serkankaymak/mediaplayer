import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.betelgeuse.wallplayer.ui.components.FileItemView
import androidx.compose.ui.tooling.preview.Preview

// Veri modeli
data class FileItem(
    val id: Int,
    val name: String,
    val description: String
)

@Composable
fun FileListView(
    files: List<FileItem>,
    isGrid: Boolean,
    isSelectingState: Boolean = false
) {
    if (isGrid) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
            items(files) {
                FileItemView(
                    isGrid = true,
                    isSelectingState = isSelectingState
                )
            }
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(files) {
                FileItemView(
                    isGrid = false,
                    isSelectingState = isSelectingState
                )
            }
        }
    }
}

// Örnek veri listesi
private val previewFileList = List(10) { index ->
    FileItem(id = index, name = "Video $index", description = "Description $index")
}

// Liste görünümü için önizleme
@Preview(name = "File List - List View", showBackground = true)
@Composable
fun PreviewFileListViewList() {
    FileListView(files = previewFileList, isGrid = false)
}

// Grid görünümü için önizleme
@Preview(name = "File List - Grid View", showBackground = true)
@Composable
fun PreviewFileListViewGrid() {
    FileListView(files = previewFileList, isGrid = true)
}
