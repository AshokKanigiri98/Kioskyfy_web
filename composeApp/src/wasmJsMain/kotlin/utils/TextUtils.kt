package utils

import androidx.compose.ui.unit.sp

fun headerTextSize() = if (isMobile()) 12.sp else 26.sp

fun descriptionTextSize() = if (isMobile()) 8.sp else 16.sp

val default_line_height = if (isMobile()) 7.sp else 12.sp