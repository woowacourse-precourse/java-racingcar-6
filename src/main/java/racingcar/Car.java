package racingcar;

public class Car {

    private String name;
    private int distance;
    private GameRule rule;

    public Car(GameRule rule, String name) {
        this.name = name;
        this.distance = 0;
        this.rule = rule;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        int randomNumber = RandomNumberGenerator.pickRandomNumber(rule);
        if (randomNumber >= 4)
            this.distance += randomNumber;
    }
}
