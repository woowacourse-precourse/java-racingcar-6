package racingcar.domain;

public class Car implements CarCondition{

    private final String name;
    private int distance = 0;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }

    @Override
    public void checkNameLength(String name) {
        if (name.length() > NAME_CONDITION) {
            throw new IllegalArgumentException();
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isMoreThanCondition(int randomNumber) {
        return MOVE_CONDITION <= randomNumber;
    }

    public void move() {
        distance++;
    }
}
