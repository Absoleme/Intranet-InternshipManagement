package com.project.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Skill {
    private int skillId;
    private String name;
    private Collection<SkillRequired> skillRequireds;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SKILL_ID")
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return skillId == skill.skillId &&
                Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId, name);
    }

    @OneToMany(mappedBy = "skill")
    public Collection<SkillRequired> getSkillRequireds() {
        return skillRequireds;
    }

    public void setSkillRequireds(Collection<SkillRequired> skillRequiredsBySkillId) {
        this.skillRequireds = skillRequiredsBySkillId;
    }
}
