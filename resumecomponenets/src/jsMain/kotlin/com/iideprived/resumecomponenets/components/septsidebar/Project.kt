package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.compose.css.CSSFloat
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.float
import com.varabyte.kobweb.compose.css.textTransform
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

val ProjectStyles by ComponentStyle {
    baseStyle {
        width(100.percent)
    }

    style(" .key-skills"){
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Start)
        flexDirection(FlexDirection.Row)

        color(rgb(130, 130, 130))
    }

    style(" .key-skills .key-skills-text") {
        fontWeight(600)
        marginTop(12.px)
    }

    style(" .key-skills .key-skills-list li") {
        float(CSSFloat.Left)
        marginLeft(4.px)
        listStyleType("none")
        borderRadius(8.px)
        backgroundColor(rgb(240, 240, 240))
        padding(4.px, 12.px)
        marginBottom(4.px)
        fontSize(9.px)
    }

    style( " .timeline"){
        fontSize(8.px)
        color(rgb(80, 80, 80))
        letterSpacing(1.px)
        margin(4.px, 0.px)
        textTransform(TextTransform.Uppercase)
    }

    style(":not(:first-child)"){
        marginTop(12.px)
    }
}
@Composable
fun ProjectsSection(
    vararg projects: Project
) {
    Section("Projects") {
        projects.forEach { project ->
            ProjectStyles.div {
                TitleAndIcons(project.title, *project.icons.toTypedArray())
                P({classes("timeline")}) { Text(project.timeline) }
                P({classes("body")}) { Text(project.body) }
                Div({classes("key-skills")}) {
                    P({classes("key-skills-text")}) { Text("Key Skills") }
                    Ul({classes("key-skills-list")}) {
                        project.skills.forEach {
                            Li({classes("key-skills-item")}) { Text(it) }
                        }
                    }
                }
            }
        }
    }
}