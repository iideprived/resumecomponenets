package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.data.HeaderAndSummary
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val HeaderAndSummaryStyles by ComponentStyle {
    baseStyle {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        width(100.percent)
        justifyContent(JustifyContent.SpaceBetween)
        marginBottom(24.px)
    }

    style( " .name") {
        fontSize(18.px)
        fontWeight(700)
        lineHeight(90.percent)
    }

    style(" .title") {
        fontSize(18.px)
        fontWeight(500)
    }

    style( " .summary") {
        width(60.percent)
        fontSize(12.px)
        fontWeight(300)
        color(rgb(80, 80, 80))
    }
}

@Composable
fun HeaderAndSummary(
   info: HeaderAndSummary
) {
    HeaderAndSummaryStyles.div{
        Div({classes("name-and-title")}) {
            P({classes("name")}) { Text(info.name) }
            P({classes("title")}) { Text(info.title) }
        }

        Div({classes("summary")}, info.content)
    }
}