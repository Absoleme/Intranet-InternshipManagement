package com.project.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Mission {
    private int missionId;
    private String description;
    private String keyWords;
    private Collection<com.project.models.Internship> internshipsByMissionId;
    private Collection<SkillRequired> skills;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MISSION_ID")
    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "KEY_WORDS")
    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return missionId == mission.missionId &&
                Objects.equals(description, mission.description) &&
                Objects.equals(keyWords, mission.keyWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionId, description, keyWords);
    }

    @OneToMany(mappedBy = "mission")
    public Collection<com.project.models.Internship> getInternshipsByMissionId() {
        return internshipsByMissionId;
    }

    public void setInternshipsByMissionId(Collection<com.project.models.Internship> internshipsByMissionId) {
        this.internshipsByMissionId = internshipsByMissionId;
    }

    @OneToMany(mappedBy = "mission", cascade = CascadeType.REMOVE)
    public Collection<SkillRequired> getSkills() {
        return skills;
    }

    public void setSkills(Collection<SkillRequired> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "missionId=" + missionId +
                ", description='" + description + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", internshipsByMissionId=" + internshipsByMissionId +
                ", skillRequiredsByMissionId=" + skills +
                '}';
    }
}
