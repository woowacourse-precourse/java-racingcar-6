package racingcar;

public class Car {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = ZERO;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar() {
        this.position++;
    }

    public void printPositionWithName() {
        System.out.println(name + " : " + createPosition());
    }

    private String createPosition() {
        String line = "";
        for (int move = ONE; move <= position; move++) {
            line += "-";
        }
        return line;
    }
}
