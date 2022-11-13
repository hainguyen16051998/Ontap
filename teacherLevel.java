package constant;

public enum teacherLevel {
    GS_TS("GS_TS"),
    PGS_TS("PGS_TS"),
    GIANGVIENCHINH("GIANG VIEN CHINH"),
    THACSY("THAC SY");
    public String value;

    teacherLevel(String value) {
        this.value = value;
    }
}
