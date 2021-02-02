package com.project.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SkillRequiredPK implements Serializable {
    private int skillId;
    private int missionId;

    @Column(name = "SKILL_ID")
    @Id
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Column(name = "MISSION_ID")
    @Id
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
        SkillRequiredPK that = (SkillRequiredPK) o;
        return skillId == that.skillId &&
                missionId == that.missionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, missionId);
    }
}
