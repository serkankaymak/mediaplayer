package com.betelgeuse.wallplayer

import FileItem
import FileListView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

enum class FileCategory {
    Music, Video, Image, Explorer
}

class FileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FileScreen()
        }
    }
}

@Composable
fun FileScreen() {
    // Seçilen kategori state'i
    var selectedCategory by remember { mutableStateOf(FileCategory.Video) }

    // Kategoriye göre örnek veri listesi oluşturuluyor
    val fileList = when (selectedCategory) {
        FileCategory.Music -> List(10) { index ->
            FileItem(id = index, name = "Music $index", description = "Description $index")
        }
        FileCategory.Video -> List(10) { index ->
            FileItem(id = index, name = "Video $index", description = "Description $index")
        }
        FileCategory.Image -> List(10) { index ->
            FileItem(id = index, name = "Image $index", description = "Description $index")
        }
        FileCategory.Explorer -> List(10) { index ->
            FileItem(id = index, name = "Explorer $index", description = "Description $index")
        }
    }
    // Örneğin resim kategorisi grid olarak gösterilsin, diğerleri liste şeklinde.
    val isGrid = selectedCategory == FileCategory.Image

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedCategory == FileCategory.Music,
                    onClick = { selectedCategory = FileCategory.Music },
                    icon = { Icon(imageVector = Icons.Filled.MusicNote, contentDescription = "Music") },
                    label = { Text("Music") }
                )
                NavigationBarItem(
                    selected = selectedCategory == FileCategory.Video,
                    onClick = { selectedCategory = FileCategory.Video },
                    icon = { Icon(imageVector = Icons.Filled.VideoLibrary, contentDescription = "Video") },
                    label = { Text("Video") }
                )
                NavigationBarItem(
                    selected = selectedCategory == FileCategory.Image,
                    onClick = { selectedCategory = FileCategory.Image },
                    icon = { Icon(imageVector = Icons.Filled.Image, contentDescription = "Image") },
                    label = { Text("Image") }
                )
                NavigationBarItem(
                    selected = selectedCategory == FileCategory.Explorer,
                    onClick = { selectedCategory = FileCategory.Explorer },
                    icon = { Icon(imageVector = Icons.Filled.Folder, contentDescription = "Explorer") },
                    label = { Text("Explorer") }
                )
            }
        }
    ) { innerPadding ->
        // İçerik alanında FileListView çağrılıyor; gerekli padding uygulanıyor.
        FileListView(
            files = fileList,
            isGrid = isGrid,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FileScreenPreview() {
    FileScreen()
}
