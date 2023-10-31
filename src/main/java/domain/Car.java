package domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < position; i++) {
            distance.append("-");
        }
        return name + " : " + distance;
    }
}
