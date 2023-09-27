package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.data.Contact
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.icons.fa.FaEnvelope
import com.varabyte.kobweb.silk.components.icons.fa.FaMobile
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

val ContactSectionStyles by ComponentStyle {
    baseStyle {
        fontSize(9.px)
        color(rgb(130, 130, 130))
        letterSpacing(0.5.px)
    }

    style(" > :not(:last-child)"){
        marginBottom(12.px)
    }

    style(":not(:last-child)"){
        marginBottom(16.px)
    }

    style(" .name"){
        fontSize(11.px)
        fontWeight(600)
        color(Color.black)
        marginBottom(4.px)
    }


    style(" a"){
        color(rgb(130, 130, 130))
    }

    style(" a:visited"){
        color(rgb(130, 130, 130))
    }
}

@Composable
fun ContactSection(contact: Contact) {
    Section("Contact"){
        ContactSectionStyles.div {
            Div({classes("content")}){
                P({classes("name")}){
                    Span { FaEnvelope() }
                    Span { Text(" Email") }
                }
                A("mailto:${contact.email}", {classes("value")}) { Text(contact.email) }
            }
            Div({classes("content")}){
                P({classes("name")}){
                    Span { FaMobile() }
                    Span { Text(" ${if (contact.workPhone.isNotBlank()) "Cell " else "Phone"}") }
                }
                A("tel:${contact.phone}", {classes("value")}) { Text(contact.phone) }
            }
            if (contact.workPhone.isNotBlank()) {
                Div({classes("content")}){
                    P({classes("name")}){
                        Span { FaMobile() }
                        Span { Text(" Work ") }
                    }
                    A("tel:${contact.workPhone}", {classes("value")}) { Text(contact.workPhone) }
                }
            }
        }
    }
}