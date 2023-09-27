package com.iideprived.resumecomponenets.components.septsidebar

import com.iideprived.resumecomponenets.data.Icon

data class Project(
    val title: String,
    val timeline: String,
    val body: String,
    val skills: List<String> = emptyList(),
    val icons: List<Icon> = emptyList()
)