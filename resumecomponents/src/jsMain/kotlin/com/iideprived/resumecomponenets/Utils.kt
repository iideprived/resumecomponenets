package com.iideprived.resumecomponenets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentModifiers
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toAttrs
import org.jetbrains.compose.web.css.StyleScope
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLParagraphElement

fun ComponentModifiers.style(rule: String, styles: StyleScope.() -> Unit) {
    cssRule(rule) { Modifier.styleModifier(styles) }
}

fun ComponentModifiers.baseStyle(styles: StyleScope.() -> Unit) { base { Modifier.styleModifier(styles) } }

@Composable
fun Div(style: ComponentStyle, content:  ContentBuilder<HTMLDivElement>?) =
    org.jetbrains.compose.web.dom.Div(style.toAttrs { }, content)

@Composable
fun P(style: ComponentStyle, content:  ContentBuilder<HTMLParagraphElement>?) =
    org.jetbrains.compose.web.dom.P(style.toAttrs { }, content)

@Composable
fun ComponentStyle.div(content: ContentBuilder<HTMLDivElement>?) = Div(this, content)