package racingcar.model;

import static racingcar.model.CarConstants.CONDITION_MOVING_FORWARD;
import static racingcar.model.CarConstants.LIMIT_NAME_SIZE;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.ExceptionMessages;
import racingcar.exception.RacingCarException;
import racingcar.util.generator.NumberGenerator;
import racingcar.util.generator.RandomNumberGenerator;

public class Car implements CarModel {
    private final String name;
    private final List<Observer> observerList;
    private NumberGenerator numberGenerator;
    private int distance = 0;

    public Car(final String name) {
        this.name = name;
        this.observerList = new ArrayList<>();
        this.numberGenerator = new RandomNumberGenerator();
        validateNameSize();
    }

    private void validateNameSize() {
        if (name.length() <= LIMIT_NAME_SIZE) {
            return;
        }

        throw RacingCarException.of(ExceptionMessages.LIMIT_CAR_NAME_SIZE);
    }

    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean canMoveForward() {
        final int generatedNumber = numberGenerator.generate();
        return generatedNumber >= CONDITION_MOVING_FORWARD;
    }

    public boolean canStop() {
        return !canMoveForward();
    }

    @Override
    public void moveForward() {
        if (canStop()) {
            notifyObservers();
            return;
        }

        distance++;
        notifyObservers();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (getClass() != other.getClass()) {
            return false;
        }

        Car otherCar = (Car) other;
        return name.equals(otherCar.name);
    }

    @Override
    public void registerObserver(final Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(final Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.stream()
                .forEach(Observer::update);
    }
}
