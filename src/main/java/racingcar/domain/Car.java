package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isNameLengthValid() {
        return getName().length() <= 5;
    }

    public void advancePosition() {
        this.position++;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public void printStatus() {
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }
}
