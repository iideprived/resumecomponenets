package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

val SectionStyles by ComponentStyle {
    baseStyle {
        width(100.percent)
        fontSize(11.px)
    }

    style(":not(:last-child)"){
        marginBottom(16.px)
    }

    style(" .section-title") {
        fontSize(9.px)
        color(rgb(80, 80, 80))
        letterSpacing(3.px)
        fontWeight(500)
        marginBottom(10.px)
    }
}

@Composable
fun Section(title: String, content: ContentBuilder<HTMLDivElement>?) {
    SectionStyles.div {
        P({classes("section-title")}) { Text(title.uppercase()) }
        content?.invoke(this)
    }
}