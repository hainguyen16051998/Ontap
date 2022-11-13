package entity;

import java.util.Arrays;

public class Lesonmanagement {
    private Teacher teacher;
    private LesonmanagementDetail[] lesonmanagementDetails;

    public Lesonmanagement(Teacher teacher, LesonmanagementDetail[] detail) {
        this.teacher = this.teacher;
        this.lesonmanagementDetails = lesonmanagementDetails;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LesonmanagementDetail[] getLesonmanagementDetails() {
        return lesonmanagementDetails;
    }

    public void setLesonmanagementDetails(LesonmanagementDetail[] lesonmanagementDetails) {
        this.lesonmanagementDetails = lesonmanagementDetails;
    }

    @Override
    public String  toString() {
        return "Lesonmanagement{" +
                "teacher=" + teacher +
                ", lesonmanagementDetails=" + Arrays.toString(lesonmanagementDetails) +
                '}';
    }
}
