package com.iideprived.resumecomponenets.data

data class Social(
    val name: String,
    val href: String,
    val clickableText: String = href
)

