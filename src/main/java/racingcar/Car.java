package racingcar;


public class Car {
    String name;
    StringBuilder position = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StringBuilder getPosition() {
        return position;
    }

    public void forward() {
        position.append("-");
    }

    public int getLengthOfName() {
        return name.length();
    }

    public int getPositionByLength() {
        return position.length();
    }
}
