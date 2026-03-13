package com.example.cse2251

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cse2251.ui.theme.CSE2251Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            NestedScroll()
//            GridExample()
            SpinnerExample()
        }
    }
}

@Composable
fun NestedScroll(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Header Section",
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
        ) {
            items(20){
                index ->
                Text("Lazy item $index")
            }
        }
        LazyRow(modifier = Modifier
            .fillMaxSize()
            .height(200.dp)) {
            items(20){
                index ->
                Text("Lazy item $index",
                    modifier = Modifier.padding(16.dp))
            }
        }
        repeat(25){
            Text(
                text = "Item ${it + 1}",
                fontSize = 22.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Composable
fun GridExample() {
    val items = listOf("C++","Java","Python","C#","Kotlin","JavaScript","PHP","MongoDb","SQL","Swift")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "List of Courses",
            fontSize = 22.sp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(Color(0xFF2D508F))
                .padding(vertical = 16.dp),
            color  = Color.White
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White), horizontalArrangement = Arrangement.SpaceEvenly,
        ){
            Text(text = "Sem 1", fontSize = 22.sp, modifier = Modifier.padding(10.dp))
            Text(text = "Sem 2", fontSize = 22.sp, modifier = Modifier.padding(10.dp))

        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(120.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(Color(0xFF594D73))
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center

                    ) {
                        Text(text = item, fontSize = 22.sp)
                    }
                }
            }
        }
    }
}
@Composable
fun SpinnerExample(){
    val items = listOf("CSE","ECE","ME","CE")
    val colorsList = listOf(Color.Red,Color.Green,Color.Blue,Color.Black)
    var expanded by remember {mutableStateOf(false)}
    var selectedItem by remember {mutableStateOf(items[0])}
    Column(
        modifier = Modifier
            .fillMaxWidth().padding(16.dp)
    ){

        OutlinedTextField(
            value = selectedItem,
            onValueChange = { },
            readOnly = true,
            label = { Text("Select Department")},
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown",
                    modifier = Modifier.clickable { expanded = true}
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false}
        ) {

                items.forEachIndexed { index, string ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            // Use the index to set the background color of the card
                            colors = CardDefaults.cardColors(
                                containerColor = colorsList[index % colorsList.size]
                            )
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = string,
                                        color = Color.White
                                    )
                                },
                                onClick = {
                                    selectedItem = string
                                    expanded = false
                                }
                            )
                        }
                    }
                }

        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    NestedScroll()
//    GridExample()
    SpinnerExample()
}
