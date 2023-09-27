package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.div
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val SummarySectionStyles by ComponentStyle {
    baseStyle {
        fontSize(9.px)
        color(rgb(130, 130, 130))
        letterSpacing(0.5.px)
    }
}

@Composable
fun SummarySection(text: String) {
    Section("Summary") {
        SummarySectionStyles.div {
            P { Text(text) }
        }
    }
}