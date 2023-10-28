package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public boolean isNameLengthValid() {
        return getName().length() <= 5;
    }

    public void advancePosition() {
        this.position++;
    }

    public void printStatus() {
        System.out.println(this.name + " : " + "-".repeat(this.position));
    }
}
