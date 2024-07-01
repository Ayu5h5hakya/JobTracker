package com.app.employeetracking.features.journey.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun MyJourney(modifier: Modifier = Modifier) {
    var pagerState = rememberPagerState(pageCount = { 4 }, initialPage = 0)
    val coroutineScope = rememberCoroutineScope()
    val tabs = listOf("Journey", "History", "Holiday", "Requests")
    Column(modifier) {
        TabRow(modifier = Modifier.fillMaxWidth(), selectedTabIndex = pagerState.currentPage) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) }, selected = index == pagerState.currentPage, onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(index)
                    }
                })
            }
        }
        HorizontalPager(
            pagerState,
            userScrollEnabled = false,
            beyondViewportPageCount = 1,
            verticalAlignment = Alignment.Top
        ) { page ->
            when (page) {
                0 -> Journey()
                1 -> History()
                2 -> Holiday()
                3 -> Requests()
            }
        }
    }
}