package entity;

import java.util.Scanner;

public class Subject implements inputable {
    private static int AUTO_ID = 100;
    private int id;
    private String name;
    private int tongSoTiet;
    private int soTietLyThuyet;
    private int mucKinhPhi;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getMucKinhPhi() {
        return mucKinhPhi;
    }

    public void setMucKinhPhi(int mucKinhPhi) {
        this.mucKinhPhi = mucKinhPhi;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tongSoTiet=" + tongSoTiet +
                ", soTietLyThuyet=" + soTietLyThuyet +
                ", mucKinhPhi=" + mucKinhPhi +
                '}';
    }

    @Override
    public void nhapThongTin() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Tên môn học ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Tổng số tiêt: ");
        this.tongSoTiet = new Scanner(System.in).nextInt();
        System.out.println("Số tiết lý thuyết: ");
        this.soTietLyThuyet = new Scanner(System.in).nextInt();
        System.out.println("Mức kinh phí: ");
        this.mucKinhPhi = new Scanner(System.in).nextInt();
    }
}
