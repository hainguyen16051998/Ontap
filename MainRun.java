import entity.Lesonmanagement;
import entity.LesonmanagementDetail;
import entity.Subject;
import entity.Teacher;

import java.time.temporal.TemporalAccessor;
import java.util.Scanner;

public class MainRun {

    public static Teacher[] teachers = new Teacher[1000];
    public static Subject[] subjects = new Subject[1000];
    public static Lesonmanagement[] lesonmanagements = new Lesonmanagement[1000];

    public static void main(String[] args) {
        menu();

    }

    private static void menu() {
        while (true) {
            showMenu();
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    addNewTeacher();
                    break;
                case 2:
                    showTeacherInfo();
                    break;
                case 3:
                    addNewSubject();
                    break;
                case 4:
                    showSubjectInfo();
                    break;
                case 5:
                    lessonManagement();
                    break;
                case 6:
                    showLessonManagement();
                    break;
                case 7:
                    break;
                case 8:
                    return;
            }

        }
    }

    private static void showLessonManagement() {
        for (int i = 0; i < lesonmanagements.length; i++) {
            if (lesonmanagements[i] != null) {
                System.out.println(lesonmanagements[i]);
            }
        }
    }

    private static void lessonManagement() {
        if (teachers.length == 0 && subjects.length == 0) {
            System.out.println("chưa có thông tin giảng viên hoặc môn học trong hệ thống, nhập lại");
            return;
        }
        System.out.println("nhập số lượng giảng viên bạn muốn phân công: ");
        int teacherNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNum; i++) {
            System.out.println("Phân công giảng dậy cho giảng viên thứ " + (i + 1));
            System.out.println("Nhập mã giảng viên bạn muốn phân công: ");
            int teacherId;
            Teacher teacher = null;

            do {
                teacherId = new Scanner(System.in).nextInt();
                for (int j = 0; j < teachers.length; j++) {
                    if (teachers[j].getId() == teacherId) {
                        teacher = teachers[j];
                        break;
                    }
                }
                if (teacher != null) {
                    break;
                }
                System.out.println("k tìm thấy giảng viên mang mã " + teacherId + " trong hệ thống");

            } while (true);
            System.out.println("Giảng viên này muốn dậy bao nhiêu môn: ");
            int subjectNum = new Scanner(System.in).nextInt();
            LesonmanagementDetail[] detail = new LesonmanagementDetail[subjectNum];
            int count = 0;
            int tongTiet = 0;
            for (int j = 0; j < subjectNum; j++) {
                System.out.println("Nhập thông tin mon học thứ " + (j + 1) + " của giáo viên " + teacher.getName() + " muốn dậy: ");
                System.out.println(" Nhập mã môn học: ");
                int subjectId;
                Subject subject = null;

                do {
                    subjectId = new Scanner(System.in).nextInt();
                    for (int k = 0; k < subjects.length; k++) {
                        if (subjects[k].getId() == subjectId) {
                            subject = subjects[k];
                            break;
                        }
                    }
                    if (subject != null) {
                        break;
                    }
                    System.out.println("k tìm thấy môn học mang mã " + subjectId + " trong hệ thống");

                } while (true);

                System.out.print("Môn này ông muốn dậy mấy lớp: ");
                int classNum;
                //check số âm và check k lớn hơn 3
                do {
                    classNum = new Scanner(System.in).nextInt();
                    if (classNum > 0 || classNum < 4) {
                        break;
                    }
                    System.out.println("số lớp k hợp lệ, nhập lại");
                } while (true);


                //lưu môn học vào trong mảng
                detail[count] = new LesonmanagementDetail(subject, classNum);
                tongTiet += subject.getTongSoTiet() * classNum;
                if (tongTiet > 200) {
                    System.out.println("nếu dậy cả môn này, số lượng tiết > hơn 200, k đc dậy nữa");
                    break;
                }
                count++;
            }
            // lưu thông tin vừa mới phân công cho giảng viên vào mảng
            Lesonmanagement lesonmanagement = new Lesonmanagement(teacher, detail);
            saveLessonInfo(lesonmanagement);
        }
    }

    private static void saveLessonInfo(Lesonmanagement lesonmanagement) {
        for (int i = 0; i < lesonmanagements.length; i++) {
            if (lesonmanagements[i] == null) {
                lesonmanagements[i] = lesonmanagement;
                break;
            }
        }
    }

    private static void showSubjectInfo() {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                System.out.println(subjects[i]);
            }
        }
    }

    private static void addNewSubject() {
        System.out.print("Nhập số lượng môn học mới muốn thêm: ");
        int subjectNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < subjectNum; i++) {
            Subject subject = new Subject();
            subject.nhapThongTin();
            saveSubject(subject);
        }
    }

    private static void saveSubject(Subject subject) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) {
                subjects[i] = subject;
                break;
            }
        }
    }

    private static void showTeacherInfo() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                System.out.println(teachers[i]);
            }
        }
    }

    private static void addNewTeacher() {
        System.out.print("Nhập số lượng giảng viên mới muốn thêm: ");
        int teacherNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNum; i++) {
            Teacher teacher = new Teacher();
            teacher.nhapThongTin();
            saveTeeacher(teacher);
        }
    }

    private static void saveTeeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("------Phần mềm quản lý trả lương cho giảng viên------");
        System.out.println("1.Nhập danh sách giảng viên mới");
        System.out.println("2.In danh sách giảng viên mới");
        System.out.println("3.Nhâp danh sách môn học mới");
        System.out.println("4.In danh sách môn học mới");
        System.out.println("5.Lập lịch phân công giảng dậy");
        System.out.println("6.Sắp xếp lịch phân công giảng dậy");
        System.out.println("7.Tính lương");
        System.out.println("8.Thoát");
        System.out.print("Mời chọn chức năng: ");
    }

    private static int functionChoice() {
        int choice = 0;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.println("mời chọn lại: ");
        } while (true);
        return choice;
    }
}
