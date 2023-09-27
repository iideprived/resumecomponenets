package com.iideprived.resumecomponenets.components.septsidebar

data class Social(
    val name: String,
    val href: String,
    val clickableText: String = href
)

