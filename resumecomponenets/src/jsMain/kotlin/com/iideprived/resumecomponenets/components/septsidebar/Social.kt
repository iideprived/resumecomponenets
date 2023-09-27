package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val SocialSectionStyles by ComponentStyle {
    baseStyle {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        width(100.percent)
        flexWrap(FlexWrap.Wrap)
    }

    style(" .social-name"){
        width(30.percent)
    }

    style(" .social-link") {
        width(70.percent)
    }

    style(":not(:last-child)"){
        marginBottom(8.px)
    }

    style(" a") {
        fontSize(9.px)
    }

    style(" :first-child"){
        fontSize(11.px)
        fontWeight(600)
        color(Color.black)
        letterSpacing(0.3.px)
    }
}

@Composable
fun SocialSection(vararg socials: Social){
    Section("Socials & Portfolio") {
        socials.forEach {
            SocialSectionStyles.div {
                P({classes("social-name")}) { Text(it.name) }
                A(href = it.href, {classes("social-link")}) { Text(it.clickableText) }
            }
        }
    }
}