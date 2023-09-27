package com.iideprived.resumecomponenets.data

import com.iideprived.resumecomponenets.data.Icon

data class Work(
    val title: String,
    val company: String,
    val timeline: String,
    val location: String,
    val desc: String,
    val bullets: List<String>,
    val icons: List<Icon> = emptyList()
)