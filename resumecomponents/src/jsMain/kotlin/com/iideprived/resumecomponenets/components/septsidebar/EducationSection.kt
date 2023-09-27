package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.data.Education
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val EducationStyles by ComponentStyle {
    baseStyle {
        fontSize(9.px)
        color(rgb(130, 130, 130))
        letterSpacing(0.5.px)
    }

    style(" :not(:last-child)"){
        marginBottom(2.px)
    }

    style(" :first-child"){
        fontSize(11.px)
        fontWeight(600)
        color(Color.black)
        letterSpacing(0.3.px)
    }
}

@Composable
fun EducationSection(education: Education) {
    Section("Education") {
        EducationStyles.div {
            P({classes("institution")}) { Text(education.institution) }
            P({classes("pursuing")}) { Text(education.pursuing) }
            P({classes("tenure")}) { Text(education.tenure) }
        }
    }
}
