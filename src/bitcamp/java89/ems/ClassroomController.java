package bitcamp.java89.ems;
import java.util.Scanner;
public class ClassroomController {
  private Scanner keyScan;
  private Classroom[] classrooms = new Classroom[100];
  private int length = 0;

  public ClassroomController(Scanner keyScan) {
    this.keyScan = keyScan;
  }

  public void service() {
    loop : while(true) {
      System.out.print("강의실관리> ");
      String order = keyScan.nextLine().toLowerCase();
      switch (order) {
        case "add": this.doAdd(); break;
        case "list": this.doList(); break;
        case "view": this.doView(); break;
        case "delete": this.doDelete(); break;
        case "update": this.doUpdate(); break;
        case "main":
          break loop;
        default :
          System.out.println("올바른 명령어가 아닙니다. 다시 입력하세요.");
          System.out.println();
      }
    }
  }

  private void doAdd() {
    while (this.length < this.classrooms.length) {
      Classroom classroom = new Classroom();
      System.out.print("강의실명?(예:세미나실) ");
      classroom.name = this.keyScan.nextLine();

      System.out.print("위치?(예:602호) ");
      classroom.location = this.keyScan.nextLine();

      System.out.print("면적?(예:100m^2) ");
      classroom.area = this.keyScan.nextLine();

      System.out.print("이용시간?(예:09:00 ~ 21:00) ");
      classroom.usabletime = this.keyScan.nextLine();

      System.out.print("수용인원?(예:100) ");
      classroom.people = Integer.parseInt(this.keyScan.nextLine());

      System.out.print("에어컨(y/n)? ");
      classroom.aconditioner =
      (this.keyScan.nextLine().equals("y")) ? true : false;

      System.out.print("프로젝터(y/n)? ");
      classroom.projector =
      (this.keyScan.nextLine().equals("y")) ? true : false;

      this.classrooms[this.length++] = classroom;

      System.out.print("계속 입력하시겠습니까(y/n)? ");
      if (!this.keyScan.nextLine().equals("y"))
        break;
    }
  }

  private void doList() {
    for (int i = 0; i < this.length; i++) {
      Classroom classroom = this.classrooms[i];
      System.out.printf("%s,%s,%s,%s,%d,%s,%s\n",
        classroom.name,
        classroom.location,
        classroom.area,
        classroom.usabletime,
        classroom.people,
        ((classroom.aconditioner)?"yes":"no"),
        ((classroom.projector)?"yes":"no"));
    }
  }

  private void doView() {
    System.out.print("강의실명? ");
    String name = this.keyScan.nextLine();
    System.out.println("----------------------------");
    for (int i = 0; i < this.length; i++) {
      if (name.equals(this.classrooms[i].name)) {
        System.out.printf("강의실명: %s\n", this.classrooms[i].name);
        System.out.printf("위치: %s\n", this.classrooms[i].location);
        System.out.printf("면적: %s\n", this.classrooms[i].area);
        System.out.printf("이용시간: %s\n", this.classrooms[i].usabletime);
        System.out.printf("수용인원: %d명\n", this.classrooms[i].people);
        System.out.printf("에어컨: %s\n",
          ((this.classrooms[i].aconditioner)?"yes":"no"));
        System.out.printf("프로젝터: %s\n",
          ((this.classrooms[i].projector)?"yes":"no"));
        break;
      }
    }
  }

  private void doDelete() {
    Classroom classroom = new Classroom();
    System.out.print("삭제할 강의실명? ");
    String name = this.keyScan.nextLine();
    System.out.println("----------------------------");
    for (int i = 0; i < this.length; i++) {
      if (name.equals(this.classrooms[i].name)) {
        for (int x = i + 1; x < this.length; x++, i++) {
          this.classrooms[i] = this.classrooms[x];
        }
        this.classrooms[--length] = null;
        System.out.printf("%s 강의실 정보를 삭제하였습니다.\n", name);
        return;
      }
    }
    System.out.printf("%s 강의실이 없습니다.\n", name);
  }

  private void doUpdate() {
    System.out.print("변경할 강의실명? ");
    String name = this.keyScan.nextLine();
    for (int i = 0; i < this.length; i++) {
      if (name.equals(this.classrooms[i].name)) {
        Classroom update = new Classroom();
        System.out.print("위치?(예:602호) ");
        update.location = this.keyScan.nextLine();

        System.out.print("면적?(예:100m^2) ");
        update.area = this.keyScan.nextLine();

        System.out.print("이용시간?(예:09:00 ~ 21:00) ");
        update.usabletime = this.keyScan.nextLine();

        System.out.print("수용인원?(예:100) ");
        update.people = Integer.parseInt(this.keyScan.nextLine());

        System.out.print("에어컨(y/n)? ");
        update.aconditioner =
          (this.keyScan.nextLine().equals("y")) ? true : false;

        System.out.print("프로젝터(y/n)? ");
        update.projector =
          (this.keyScan.nextLine().equals("y")) ? true : false;

        System.out.print("저장하시겠습니까(y/n)? ");

        update.name = this.classrooms[i].name;

        if (this.keyScan.nextLine().equals("y")) {
          this.classrooms[i] = update;
          System.out.println("저장하였습니다.");
          return;
        } else {
          System.out.println("변경을 취소하였습니다.");
          return;
        }
      }
    }
    System.out.println(name + "이라는 강의실이 없습니다.");
  }
}
