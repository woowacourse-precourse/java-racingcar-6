package racingcar;

import java.util.List;

public class Game {

    private final List<Car> participantCars;

    public Game(List<Car> participantCars) {
        this.participantCars = participantCars;
    }

    public void playGame() {
        controlCar();

        displayCarPosition();
    }

    private void controlCar() {
        int gamePlayCount = 5;
        for (int i = 0; i < gamePlayCount; i++) {
            moveCar();
        }
    }

    private void moveCar() {
        for (Car car : participantCars) {
            if (isMoveToForward()) {
                car.move();
            }
        }
    }

    private boolean isMoveToForward() {
        return getRandomNumber() >= 4;
    }

    private int getRandomNumber() {
        return new RandomNumber().getNumber();
    }

    private void displayCarPosition() {
        for (Car participantCar : participantCars) {
            int position = participantCar.getPosition();
            System.out.println(participantCar.getName() + " : " + "-".repeat(position));
        }
    }
}