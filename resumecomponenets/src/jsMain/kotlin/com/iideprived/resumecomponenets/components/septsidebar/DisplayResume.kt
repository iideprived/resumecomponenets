package com.iideprived.resumecomponenets.components.septsidebar

import androidx.compose.runtime.Composable
import com.iideprived.resumecomponenets.data.Profile
import com.iideprived.resumecomponenets.div
import org.jetbrains.compose.web.css.cm
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.dom.*

@Composable
fun Profile.DisplayResume(){
    ResumeStyles.div {
        MainContentStyles.div {
            HeaderAndSummary(headerAndSummary)
            WorkExperienceSection(*workHistory)
            if (projects.isNotEmpty()) ProjectsSection(*projects)
        }

        SideBarStyles.div {
            CurrentLocationSection(currentLocation)
            EducationSection(education)
            if (certs.isNotEmpty()) CertificationSection(*certs)
            SocialSection(*socials)
            ContactSection(contact)
            SkillSection(*skills)
            SummarySection(summary)
        }
    }

    Style {
        "@media print" {
            "@page" {
                margin(0.cm)
            }
        }
    }
}