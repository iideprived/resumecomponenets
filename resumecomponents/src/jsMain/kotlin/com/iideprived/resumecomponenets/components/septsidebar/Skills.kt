package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.baseStyle
import com.iideprived.resumecomponenets.data.SkillCategory
import com.iideprived.resumecomponenets.div
import com.iideprived.resumecomponenets.style
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.textAlign
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

val SkillSectionStyles by ComponentStyle {

    baseStyle {
        fontSize(9.px)
        color(rgb(130, 130, 130))
        letterSpacing(0.5.px)
    }

    style(" > :not(:last-child)"){
        marginBottom(8.px)
    }

    style(":not(:last-child)"){
        marginBottom(8.px)
    }

    style(" .category .name"){
        fontSize(11.px)
        fontWeight(600)
        color(Color.black)
    }

    style(" .category"){
        width(100.percent)
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        justifyContent(JustifyContent.SpaceBetween)
        alignItems(AlignItems.End)
    }

    style(" .skill"){
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        flexWrap(FlexWrap.Wrap)
        justifyContent(JustifyContent.SpaceBetween)
        width(100.percent)
        paddingLeft(5.percent)
    }

    style(" .skill > :first-child"){

    }

    style(" .skill > :last-child"){
        textAlign(TextAlign.End)
    }

}

@Composable
fun SkillSection(vararg category: SkillCategory){
    Section("Skills"){
        category.forEach { skill ->
            SkillSectionStyles.div {
                P({classes("category")}) {
                    Span({classes("name")}){ Text(skill.category) }
                    Span({classes("exp")}){ Text(skill.experience) }
                }
                skill.subskills.forEach { sub ->
                    P({classes("skill")}) {
                        Span({classes("sub-name")}){ Text(sub.name) }
                        Span({classes("sub-exp")}){ Text(sub.experience) }
                    }
                }
            }
        }
    }
}