package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.data.Icon
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

val TitleAndIconsStyles by ComponentStyle {
    baseStyle {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        width(100.percent)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.Center)
    }

    style(" .title") {
        fontSize(12.px)
        fontWeight(700)
        letterSpacing(1.px)
        color(Color.black)
    }

    style(" .icon"){
        maxWidth(16.px)
        maxHeight(16.px)
        marginLeft(2.px)
        marginRight(2.px)
    }

    style(" .icon img"){
        maxWidth(16.px)
        maxHeight(16.px)
    }
}

@Composable
fun TitleAndIcons(title: String, vararg icons: Icon) {
    TitleAndIconsStyles.div {
        P({classes("title")}) { Text(title) }
        Div({classes("icons")}){
            icons.forEach {
                A(href = it.href, {classes("icon")}) {
                    Img(it.location, it.name)
                }
            }
        }
    }
}