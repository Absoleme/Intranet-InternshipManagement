package com.project.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SKILL_REQUIRED", schema = "ADM")
@IdClass(com.project.models.SkillRequiredPK.class)
public class SkillRequired {
    private int skillId;
    private int missionId;
    private Skill skill;
    private Mission mission;

    @Id
    @Column(name = "SKILL_ID")
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Id
    @Column(name = "MISSION_ID")
    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillRequired that = (SkillRequired) o;
        return skillId == that.skillId &&
                missionId == that.missionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, missionId);
    }

    @ManyToOne
    @JoinColumn(name = "SKILL_ID", referencedColumnName = "SKILL_ID", insertable = false, updatable = false)
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @ManyToOne
    @JoinColumn(name = "MISSION_ID", referencedColumnName = "MISSION_ID", insertable = false, updatable = false)
    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    @Override
    public String toString() {
        return "SkillRequired{" +
                "skillId=" + skillId +
                ", missionId=" + missionId +
                '}';
    }
}
