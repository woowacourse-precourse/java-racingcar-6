package racingcar.domain;

public class Car implements CarMoveCondition{

    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isMoreThanCondition(int randomNumber) {
        return CONDITION <= randomNumber;
    }

    public void move() {
        distance++;
    }
}
