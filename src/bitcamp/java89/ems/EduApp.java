package bitcamp.java89.ems;
import java.util.Scanner;
public class EduApp {
  public static void main(String[] args) {
    System.out.println("비트캠프 관리시스템에 오신걸 환영합니다.");
    Scanner keyScan = new Scanner(System.in);
    ClassroomController classroomController = new ClassroomController(keyScan);
    StudentController studentController = new StudentController(keyScan);
    TeacherController  teacherController  = new TeacherController(keyScan);

    loop : while(true) {
      System.out.print("명령> ");
      String order = keyScan.nextLine().toLowerCase();
      switch (order) {
        case "menu": doMenu(); break;
        case "go 1": classroomController.service(); break;
        case "go 2": studentController.service(); break;
        case "go 3": teacherController.service(); break;
        case "quit":
          System.out.println("Bye");
          break loop;
        default :
          System.out.println("올바른 명령어가 아닙니다. 다시 입력하세요.");
      }
    }
  }

  static void doMenu() {
    System.out.println("[메뉴]");
    System.out.println("1. 강의실 관리");
    System.out.println("3. 강사 관리");
    System.out.println("2. 학생 관리");
    System.out.println("메뉴 이동은 'go 메뉴번호'를 입력하세요");
  }
}
