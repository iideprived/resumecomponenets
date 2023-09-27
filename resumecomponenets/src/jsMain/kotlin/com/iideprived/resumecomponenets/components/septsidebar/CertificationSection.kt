package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val CertificationSectionStyles by ComponentStyle {

    baseStyle {
        fontSize(9.px)
        color(rgb(130, 130, 130))
        letterSpacing(0.5.px)
    }

    style(" :not(:last-child)"){
        marginBottom(2.px)
    }

    style(":not(:last-child)"){
        marginBottom(8.px)
    }

    style(" .cert"){
        fontSize(11.px)
        fontWeight(600)
        color(Color.black)
    }
}

@Composable
fun CertificationSection(
    vararg certs: Certification
) {
    Section("Certifications") {
        certs.forEach {
            CertificationSectionStyles.div {
                P({classes("cert")}) { Text(it.name) }
                P({classes("earned")}) { Text(it.earned) }
                P({classes("extra")}) { Text(it.extra) }
            }
        }
    }
}