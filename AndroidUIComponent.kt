package com.example.cse2251

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.forEach
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cse2251.ui.theme.CSE2251Theme

class AndroidUIComponent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           UiComponent()
        }
    }
}
data class Technology(val name: String,val icon: Int)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiComponent() {
    val items = listOf("CSE","ECE","ME","CE")
    val colorsList = listOf(Color.Red,Color.Green,Color.Blue,Color.Black)
    var expanded by remember {mutableStateOf(false)}
    var selectedItem by remember {mutableStateOf("")}
    val courses = listOf("Android Development", "Data Structures", "Database Systems", "Machine Learning")
    val tech = listOf(
        Technology("Android", R.drawable.android_logo),
        Technology("Flutter", R.drawable.flutter), // Replace with your actual icons
        Technology("React", R.drawable.react),
        Technology("Java", R.drawable.java),
        Technology("Firebase", R.drawable.firebase),
        Technology("NodeJS", R.drawable.nodejs)
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBDDCBD)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF79C279)), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = "Android UI Component",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White)


        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
//                DropdownMenu is inside a Column and Box without an anchor, so Compose shows the menu
                //at the default position (top-left of the parent layout).
//                OutlinedTextField(
//                    value = selectedItem,
//                    onValueChange = { },
//                    readOnly = true,
//                    label = { Text("Select Department") },
//
//                    trailingIcon = {
//                        Icon(
//                            imageVector = Icons.Default.ArrowDropDown,
//                            contentDescription = "Dropdown",
//                            modifier = Modifier.clickable { expanded = true }
//                        )
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth(0.8f)
//                        .padding(top = 10.dp)
//                        .background(Color.White)
//                        .clickable { expanded = true }
//                )
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false }
//                ) {
//
//                    items.forEachIndexed { index, string ->
//                        Card(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(4.dp),
//                            // Use the index to set the background color of the card
//                            colors = CardDefaults.cardColors(
//                                containerColor = colorsList[index % colorsList.size]
//                            )
//                        ) {
//                            DropdownMenuItem(
//                                text = {
//                                    Text(
//                                        text = string,
//                                        color = Color.White
//                                    )
//                                },
//                                onClick = {
//                                    selectedItem = string
//                                    expanded = false
//                                }
//                            )
//                        }
//                    }
//                }
//                To make the dropdown appear directly below the arrow / text field, you should wrap the OutlinedTextField
                //and DropdownMenu inside an ExposedDropdownMenuBox. This component automatically anchors the menu below the field
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {

                    OutlinedTextField(
                        value = selectedItem,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Select Department") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth(0.8f)
                            .padding(top = 10.dp)
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {

                        items.forEachIndexed { index, item ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(4.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = colorsList[index % colorsList.size]
                                )
                            ) {
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = item,
                                            color = Color.White
                                        )
                                    },
                                    onClick = {
                                        selectedItem = item
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }
                Text(
                    text = "Select Courses",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center

                )

                // Example of a static list or another component for courses
                courses.forEach { course ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(2.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
                    ) {
                        Text(
                            text = course,
                            modifier = Modifier.padding(16.dp),
                            color = Color.Black
                        )
                    }

                }

                Text(
                    text = "Technology Grid",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center

                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(tech) { technology ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .height(100.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
                            colors = CardDefaults.cardColors(Color(0xFFF8F0F0))
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = technology.icon),
                                    contentDescription = technology.name,
                                    modifier = Modifier.size(60.dp).padding(bottom = 4.dp)
                                )
                                Text(
                                    text = technology.name,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
            }
        }
    }







@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    UiComponent()
}