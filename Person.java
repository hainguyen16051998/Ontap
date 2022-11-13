package entity;

import java.util.Scanner;

public class Person implements inputable {
    protected String name;
    protected String address;
    protected int phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
    @Override
    public void nhapThongTin(){
        System.out.println("Họ và tên giảng viên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Địa chỉ giảng viên: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("SĐT giảng viên: ");
        this.phone = new Scanner(System.in).nextInt();
    }
}
