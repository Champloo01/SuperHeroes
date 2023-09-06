package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun SuperHeroesApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        SuperHeroTopBar()
        SuperHeroList(superHeroList = HeroesRepository.heroes)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme(darkTheme = false) {
        SuperHeroesApp()
    }
}