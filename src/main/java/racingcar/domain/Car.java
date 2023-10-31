package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveOrGo(int randomNumber) {
        if (randomNumber >= 4) {
            movePosition();
            printNameAndPosition();
        } else {
            printNameAndPosition();
        }

    }

    private void movePosition() {
        this.position++;
    }

    private void printNameAndPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }



}
