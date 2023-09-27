package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.data.CurrentLocation
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

val CurrentLocationStyles by ComponentStyle {
    baseStyle {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.End)
        justifyContent(JustifyContent.SpaceBetween)
        flexWrap(FlexWrap.Wrap)

        fontSize(9.px)
        color(rgb(130, 130, 130))
        letterSpacing(0.5.px)
    }

    style(" :first-child"){
        fontSize(11.px)
        fontWeight(600)
        color(Color.black)
        letterSpacing(0.3.px)
    }
}

@Composable
fun CurrentLocationSection(currentLocation: CurrentLocation) {
    Section("Current Location") {
        CurrentLocationStyles.div {
            P({classes("location-name")}) { Text(currentLocation.location) }
            if (currentLocation.isOpenToRelocation){
                P({classes("location-open")}) { Text("Open To Relocation") }
            }
        }
    }
}