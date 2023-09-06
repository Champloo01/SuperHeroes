package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.superheroes.model.Hero


@Composable
fun SuperHeroesCard(
    modifier: Modifier = Modifier,
    hero: Hero
) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SuperHeroInformation(
                title = hero.nameRes,
                info = hero.descriptionRes,
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            )
            Spacer(modifier = Modifier.weight(1f))
            SuperHeroIcon(
                image = hero.imageRes,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size))
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .clip(MaterialTheme.shapes.small)

            )
        }
    }
}

@Composable
fun SuperHeroIcon(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun SuperHeroInformation(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes info: Int
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(id = info),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SuperHeroList(
    modifier: Modifier = Modifier,
    superHeroList: List<Hero>
) {
    LazyColumn(modifier = modifier) {
        items(superHeroList) {HeroesRepository ->
            SuperHeroesCard(
                hero = HeroesRepository,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_small),
                        start = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium)
                    )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Column(
                modifier = modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    )
}

