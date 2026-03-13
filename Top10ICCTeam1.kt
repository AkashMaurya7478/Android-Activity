package com.example.cse2251

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Team(val name: String, val flag: String)

class Top10ICCTeam1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CricketTeam()
        }
    }
}

@Composable
fun CricketTeam() {
    val teams = listOf(
        Team("India", "🇮🇳"),
        Team("Australia", "🇦🇺"),
        Team("England", "🏴󠁧󠁢󠁥󠁮󠁧󠁿"),
        Team("South Africa", "🇿🇦"),
        Team("New Zealand", "🇳🇿"),
        Team("Pakistan", "🇵🇰"),
        Team("Sri Lanka", "🇱🇰"),
        Team("West Indies", "🏏"),
        Team("Bangladesh", "🇧🇩"),
        Team("Afghanistan", "🇦🇫")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "Top 10 ICC Cricket Team",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2E7D32))
                .padding(vertical = 14.dp),
            color = Color.White
        )

        // Banner Image
        Image(
            painter = painterResource(id = R.drawable.cricket),
            contentDescription = "Cricket Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.FillWidth
        )

        // Team List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            itemsIndexed(teams) { index, team ->
                TeamRow(rank = index + 1, team = team)
                // Green divider
                Divider(color = Color(0xFF4CAF50), thickness = 1.dp)
            }
        }
    }
}

@Composable
fun TeamRow(rank: Int, team: Team) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Blue circle with rank number
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(Color(0xFF1565C0), shape = CircleShape)
                .border(2.dp, Color(0xFF1565C0), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = rank.toString(),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Flag emoji
        Text(
            text = team.flag,
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Team name
        Text(
            text = team.name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    CricketTeam()
}