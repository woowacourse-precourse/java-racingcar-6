package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> participantCars;

    public Game(List<Car> participantCars) {
        this.participantCars = participantCars;
    }

    public List<Car> getWinnerList() {
        return participantCars.stream()
            .filter(car -> car.getPosition() == getMaxPosition())
            .toList();
    }

    public String getWinnerNames(List<Car> winners) {
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

    public String getCurrentParticipantCarPosition() {
        return participantCars.stream()
            .map(this::getPositionBarByCar)
            .collect(Collectors.joining("\n"));
    }

    public void moveCar() {
        for (Car car : participantCars) {
            if (isCarMoveToForward()) {
                car.move();
            }
        }
    }

    private boolean isCarMoveToForward() {
        return new RandomNumber().getNumber() >= 4;
    }

    private String getPositionBarByCar(Car participantCar) {
        return String.format("%s : %s", participantCar.getName(),
            "-".repeat(participantCar.getPosition()));
    }

    private int getMaxPosition() {
        return participantCars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }
}
