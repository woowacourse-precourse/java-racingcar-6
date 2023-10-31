package racingcar.domain;

public class Car {
    private final int JUDGEMENT_NUMBER = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name + " : "
                + "-".repeat(Math.max(0, distance));
    }

    public String getName() {
        return name;
    }

    public void judgeNumberToGo(int number) {
        if (number >= JUDGEMENT_NUMBER) {
            go();
        }
    }

    private void go() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isEqualDistance(int compareDistance) {
        return distance == compareDistance;
    }
}