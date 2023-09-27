package com.iideprived.resumecomponenets.components.septsidebar

import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*

val ResumeStyles by ComponentStyle {
    baseStyle {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        height(100.percent)
        width(100.percent)

        fontFamily("Inter")
        color(Color.black)
    }
}

val MainContentStyles by ComponentStyle {
    baseStyle {
        height(100.percent)
        width(100.percent)
        property("padding", "16px")

        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.SpaceBetween)
        flexDirection(FlexDirection.Column)
    }
}

val SideBarStyles by ComponentStyle {
    baseStyle {
        height(100.percent)
        backgroundColor(rgb(240, 240, 240))
        width(40.percent)
        property("padding", "16px")
    }

    style(" > :not(:first-child)"){
        marginTop(48.px)
    }
}