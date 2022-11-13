package entity;

import constant.teacherLevel;

import java.util.Scanner;

public class Teacher extends Person {
    private static int AUTO_ID = 100;
    private int id;
    private String level;

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", id=" + id +
                ", level='" + level + '\'' +
                '}';
    }

    public void nhapThongTin() {
        this.id = AUTO_ID;
        AUTO_ID++;
        super.nhapThongTin();
        System.out.println("Nhập trình độ giảng viên: ");
        System.out.println("1.GS_TS");
        System.out.println("2.PGS_TS");
        System.out.println("3.GIANG VIEN CHINH");
        System.out.println("4.THAC SY");
        System.out.println("Mời chọn: ");
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 4) {
                break;
            }
            System.out.println("mời chọn lại: ");
        } while (true);
        switch (choice) {
            case 1:
                this.level = teacherLevel.GS_TS.value;
                break;
            case 2:
                this.level = teacherLevel.PGS_TS.value;
                break;
            case 3:
                this.level = teacherLevel.GIANGVIENCHINH.value;
                break;
            case 4:
                this.level = teacherLevel.THACSY.value;
                break;

        }
    }
}
