package com.iideprived.resumecomponenets.data

data class Profile(
    val headerAndSummary: HeaderAndSummary,
    val currentLocation: CurrentLocation,
    val education: Education,
    val contact: Contact,
    val summary: String,
    val projects: Array<Project> = emptyArray(),
    val workHistory: Array<Work> = emptyArray(),
    val certs: Array<Certification> = emptyArray(),
    val socials: Array<Social> = emptyArray(),
    val skills: Array<SkillCategory> = emptyArray(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class.js != other::class.js) return false

        other as Profile

        if (headerAndSummary != other.headerAndSummary) return false
        if (currentLocation != other.currentLocation) return false
        if (education != other.education) return false
        if (contact != other.contact) return false
        if (summary != other.summary) return false
        if (!projects.contentEquals(other.projects)) return false
        if (!workHistory.contentEquals(other.workHistory)) return false
        if (!certs.contentEquals(other.certs)) return false
        if (!socials.contentEquals(other.socials)) return false
        if (!skills.contentEquals(other.skills)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = headerAndSummary.hashCode()
        result = 31 * result + currentLocation.hashCode()
        result = 31 * result + education.hashCode()
        result = 31 * result + contact.hashCode()
        result = 31 * result + summary.hashCode()
        result = 31 * result + projects.contentHashCode()
        result = 31 * result + workHistory.contentHashCode()
        result = 31 * result + certs.contentHashCode()
        result = 31 * result + socials.contentHashCode()
        result = 31 * result + skills.contentHashCode()
        return result
    }
}