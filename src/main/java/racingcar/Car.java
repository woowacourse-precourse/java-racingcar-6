package racingcar;

public class Car {
    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
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
        for (int move = 1; move <= position; move++) {
            line += "-";
        }
        return line;
    }
}
