package model;

public class Car {
    final static int FORWARDING_THRESHOLD = 4;
    final static String ONE_PLACE = "-";
    Name name;
    String nowPlace = "";

    public Car(String name) {
        this.name= new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    public void moveForward() {
        this.nowPlace = this.nowPlace + ONE_PLACE;
    }

    public String getNowPlace() {
        return nowPlace;
    }

    public void tryMove(int randomNumber) {
        if (randomNumber >= FORWARDING_THRESHOLD) {
            moveForward();
        }
    }
}
