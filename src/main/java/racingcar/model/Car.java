package racingcar.model;

import racingcar.constant.GameConstant;

public class Car implements Comparable<Car> {

    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void run(int isGoodToRun) {
        if (isGoodToRun >= GameConstant.GOOD_TO_RUN) {
            position.add();
        }
    }
    
    @Override
    public int compareTo(Car compareCar) {
        return position.value() - compareCar.getPosition();
    }

    @Override
    public String toString() {
        String currentStatus = name.toString() + ": "
                + "-".repeat(position.value());

        return currentStatus;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }
}