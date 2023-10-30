package racingcar.func;

import racingcar.exception.Error;

public class CarRace {
    private Car[] cars;
    private int tryCount;

    public CarRace(String[] carNames, int tryCount) {
        Error.validateInputs(tryCount, carNames);
        this.tryCount = tryCount;
        this.cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void startRace() {
        System.out.println();
        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            printCarStates();
        }
        printWinners();
    }

    private void printCarStates() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getCarState(car.getDistance()));
        }
        System.out.println();
    }

    private String getCarState(int distance) {
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            state.append("-");
        }
        return state.toString();
    }

    private void printWinners() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                appendWinner(winners, car.getName());
            }
        }

        System.out.println("최종 우승자 : " + winners.toString());
    }

    private void appendWinner(StringBuilder winners, String winnerName) {
        if (winners.length() > 0) {
            winners.append(", ");
        }
        winners.append(winnerName);
    }
}
