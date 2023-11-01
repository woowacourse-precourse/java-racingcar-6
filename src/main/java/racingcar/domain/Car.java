package racingcar.domain;

public class Car {
    public String name;
    public int distanceMoved;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goForward() {
        distanceMoved++;
    }

    public String visualizeDistanceAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distanceMoved; i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }

    public void printDistance() {
        System.out.println(name + " : " + visualizeDistanceAsString());
    }
}
