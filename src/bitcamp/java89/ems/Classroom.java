package bitcamp.java89.ems;

public class Classroom {
  String name, location, area, usabletime;
  int people;
  boolean aconditioner, projector;

  public Classroom() {}

  public Classroom(String name, String location, String usabletime) {
    this.name = name;
    this.location = location;
    this.usabletime = usabletime;
  }
}
