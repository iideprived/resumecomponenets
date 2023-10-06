package com.iideprived.resumecomponenets.pagesizes


import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.visited
import com.varabyte.kobweb.silk.init.SilkStylesheet
import com.varabyte.kobweb.silk.init.registerBaseStyle
import org.jetbrains.compose.web.css.*


enum class PageSize(
    val width: String,
    val height: String,
    _sizeName: String? = null
) {
    Letter("8.5in", "11in"),
    A4("210mm", "297mm")
    ;

    val sizeName: String = _sizeName ?: name
}

fun SilkStylesheet.setupPage(
    pageSize: PageSize = PageSize.Letter,
    backgroundColor: CSSColorValue = rgb(240, 240, 240),
    linkColor: CSSColorValue = rgb(130, 130, 130),
){
    registerBaseStyle("body, html") {
        Modifier.styleModifier {
            backgroundColor(backgroundColor)
            property("overflow" ,"hidden")
        }
    }

    registerBaseStyle("html"){
        Modifier.styleModifier {
            boxSizing("border-box")
        }
    }

    registerBaseStyle("*, *:before, *:after"){
        Modifier.styleModifier { boxSizing("inherit")}
    }

    registerBaseStyle("p"){
        Modifier.styleModifier {
            marginTop(0.px)
            paddingTop(0.px)
            marginBottom(0.px)
        }
    }

    registerStyle("a"){
        Modifier.styleModifier {
            color(linkColor)
        }

        visited {
            Modifier.styleModifier {
                color(linkColor)
            }
        }
    }

    registerStyle(".silk-surface.silk-smooth-color"){
        Modifier.styleModifier {
            property("width", pageSize.width)
            property("height", pageSize.height)
            property("max-width", pageSize.width)
            property("max-height", pageSize.height)
            overflow("hidden")
        }

        cssRule(CSSMediaQuery.Raw("print")) {
            Modifier.styleModifier {
                property("margin", "0")
                property("width", pageSize.width)
                property("height", pageSize.height)
                display(DisplayStyle.Block)
                justifyContent(JustifyContent.Start)
                alignItems(AlignItems.Start)
            }
        }

        cssRule(CSSMediaQuery.Raw("page")){
            Modifier.styleModifier {
                property("size", pageSize.sizeName)
                property("margin", "0")
            }
        }

        cssRule(CSSMediaQuery.Raw("screen")) {
            Modifier.styleModifier {
                property("width", "100%")
                property("height", "100%")
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)
                property("margin", "64px auto")
            }
        }
    }
}