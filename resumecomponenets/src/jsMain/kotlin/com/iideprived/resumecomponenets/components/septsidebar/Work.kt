package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.textTransform
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

val WorkExperienceStyles by ComponentStyle {

    baseStyle {
        width(100.percent)
    }

    style(":not(:last-child)"){
        marginBottom(12.px)
    }

    style(" .company") {
        fontWeight(400)
        marginBottom(4.px)
        letterSpacing(1.px)
    }

    style( " .time-and-place"){
        fontSize(8.px)
        color(rgb(80, 80, 80))
        letterSpacing(1.px)
        marginBottom(4.px)
        textTransform(TextTransform.Uppercase)
    }

    style(" .roles") {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Start)
        flexDirection(FlexDirection.Row)

        color(rgb(130, 130, 130))
    }

    style(" .roles .roles-text") {
        marginTop(12.px)
        fontWeight(600)
    }
}

@Composable
fun WorkExperienceSection(
    vararg workHistory: Work
) {
    Section("Work Experience") {
        workHistory.forEach {
            WorkExperienceStyles.div {
                TitleAndIcons(it.title, *it.icons.toTypedArray())
                P({classes("company")}) { Text(it.company) }
                P({classes("time-and-place")}) {
                    Span({classes("timeline")}) { Text("${it.timeline}:") }
                    Span({classes("location")}) { Text(" ${it.location}") }
                }
                P({classes("description")}) { Text(it.desc) }
                Div({classes("roles")}){
                    P({classes("roles-text")}) { Text("Roles") }
                    Ul({classes("roles-list")}) {
                        it.bullets.forEach {
                            Li({classes("roles-item")}) { Text(it) }
                        }
                    }
                }
            }
        }
    }
}