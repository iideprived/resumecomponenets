package com.iideprived.resumecomponenets.components.septsidebar

class SkillCategory(
    val category: String,
    val experience: String,
    vararg val subskills: Skill
)

data class Skill(
    val name: String,
    val experience: String
)