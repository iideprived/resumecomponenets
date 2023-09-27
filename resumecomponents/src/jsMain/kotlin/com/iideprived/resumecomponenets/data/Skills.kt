package com.iideprived.resumecomponenets.data

class SkillCategory(
    val category: String,
    val experience: String,
    vararg val subskills: Skill
)

data class Skill(
    val name: String,
    val experience: String
)