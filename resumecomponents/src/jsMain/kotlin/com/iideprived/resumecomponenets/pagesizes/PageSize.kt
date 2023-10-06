package com.iideprived.resumecomponenets.pagesizes

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.visited
import com.varabyte.kobweb.silk.init.SilkStylesheet
import com.varabyte.kobweb.silk.init.registerBaseStyle
import org.jetbrains.compose.web.css.*


enum class PageSize(
    val width: String,
    val height: String
) {
    USLetter("8.5in", "11in"),
    A4("210mm", "297mm")
}

fun SilkStylesheet.setupPage(
    pageSize: PageSize = PageSize.USLetter,
){
    registerBaseStyle("body, html") {
        Modifier.styleModifier {
            backgroundColor(rgb(240, 240, 240))
            margin(0.px)
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

    registerBaseStyle("body"){
        Modifier.styleModifier {
            property("width", pageSize.width)
            property("height", pageSize.height)
        }
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
            color(rgb(130, 130, 130))
        }

        visited {
            Modifier.styleModifier {
                color(rgb(130, 130, 130))
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
                property("overflow" ,"auto")
            }
        }

        cssRule(CSSMediaQuery.Raw("screen")) {
            Modifier.styleModifier {
                property("width", "100%")
                property("height", "100%")
                property("overflow" ,"hidden")
                property("margin", "64px auto")
            }
        }
    }
}