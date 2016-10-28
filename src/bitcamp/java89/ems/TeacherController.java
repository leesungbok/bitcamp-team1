package step09.ex6;
import java.util.Scanner;

public class TeacherController {
  Teacher[] teachers = new Teacher[100];
  int length = 0;
  Scanner keyScan;

  public TeacherController(Scanner keyScan) {
    this.keyScan = keyScan;
  }


    public void service() {
      loop : while(true) {
        System.out.print("강사관리> ");
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
        }
      }
    }

  public void doDelete() {
    System.out.print("검색어(이름)> ");
    String name = this.keyScan.nextLine().toLowerCase();
    for (int i = 0; i < this.length; i++) {
      if (this.teachers[i].name.toLowerCase().equals(name)) {
        for (int x = i + 1; x < this.length; x++, i++) {
          this.teachers[i] = this.teachers[x];
        }
        this.teachers[--length] = null;
        System.out.printf("%s 강사님의 정보를 삭제하였습니다.\n", name);
        return;
      }
    }
    System.out.printf("%s 강사님의 정보가 없습니다. \n", name);
  }

  public void doUpdate() {
    System.out.print("검색어(이름)> ");
    String name = this.keyScan.nextLine().toLowerCase();
    Teacher teacher = new Teacher();
    for (int i = 0; i < this.length; i++) {
      if (teachers[i].name.toLowerCase().equals(name)) {
        while (true) {
          System.out.printf("이름 : %s", teachers[i].name);
          teacher.name = teachers[i].name;
          System.out.printf("\n분야? ", teachers[i].language);
          teacher.language = this.keyScan.nextLine();
          System.out.printf("경력? ", teachers[i].career);
          teacher.career = this.keyScan.nextLine();
          System.out.printf("저서? ", teachers[i].writing);
          teacher.writing = this.keyScan.nextLine();
          System.out.print("정말 변경하시겠습니까? (y/n)");
          if (this.keyScan.nextLine().toLowerCase().equals("y")) {
            teachers[i] = teacher;
            System.out.println("변경되었습니다.");
            break;
          } else {
              break;
          }
        }
      } else {
        System.out.println("검색하신 정보가 없습니다. 다시 입력해주세요.");
        doUpdate();
      }
    }
  }

  public void doView() {
    System.out.print("검색어(이름)> ");
    String name = this.keyScan.nextLine().toLowerCase();
    for (int i = 0; i < this.length; i++) {
      if (teachers[i].name.toLowerCase().equals(name)) {
        System.out.printf("강사 이름: %s\n", this.teachers[i].name);
        System.out.printf("강의 분야: %s\n", this.teachers[i].language);
        System.out.printf("강의 경력: %s\n", this.teachers[i].career);
        System.out.printf("출간 저서: %s\n", this.teachers[i].writing);
        break;
      }
    }
  }

  public void doList() {
    for (int i = 0; i < length; i++) {
      Teacher teacher = this.teachers[i];

      System.out.printf("%s, %s, %s, %s\n",
      teacher.name,
      teacher.language,
      teacher.career,
      teacher.writing);
    }
  }

  public void doAdd() {
    while (this.length < this.teachers.length) {
      Teacher teacher = new Teacher();

      System.out.print("이름? ");
      teacher.name = this.keyScan.nextLine();
      System.out.print("분야? ");
      teacher.language = this.keyScan.nextLine();
      System.out.print("경력? ");
      teacher.career = this.keyScan.nextLine();
      System.out.print("저서? ");
      teacher.writing = this.keyScan.nextLine();

      teachers[length++] = teacher;

      System.out.print("계속 입력하시겠습니까(y/n)");
      if (!this.keyScan.nextLine().equals("y")) {
        break;
      }
    }
  }

  public void doAutoAdd() {
    Teacher teacher = new Teacher();

    teacher.name = "엄진영";
    teacher.language = "java, c, c++ 등";
    teacher.career = "10년 이상";
    teacher.writing = "열혈강의: 자바 웹 개발 워크북 (프리렉)";
    teachers[0] = teacher;
    teacher.name = "한동은";
    teacher.language = "java";
    teacher.career = "1년 이상";
    teacher.writing = "없음";
    teachers[1] = teacher;
    teacher.name = "이성복";
    teacher.language = "java, c";
    teacher.career = "3년 이상";
    teacher.writing = "자바의 정석 (이성복 에디션)";
    teachers[2] = teacher;
  }
}
