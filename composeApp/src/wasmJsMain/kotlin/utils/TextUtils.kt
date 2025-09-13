package utils

import androidx.compose.ui.unit.sp

fun headerTextSize() = if (isMobile()) 15.sp else 26.sp

fun descriptionTextSize() = if (isMobile()) 10.sp else 16.sp