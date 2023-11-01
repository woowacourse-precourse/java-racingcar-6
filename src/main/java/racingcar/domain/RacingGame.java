package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;
    private int numberOfRepetition;

    public RacingGame(ArrayList<Car> cars, int numberOfRepetition) {
        this.cars = cars;
        this.numberOfRepetition = numberOfRepetition;
    }
    private void moveOrStop() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }
    private void printCurrentPositions() {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
    }

    private void findWinners(ArrayList<Car> cars) {
        RacingGameWinner winner = new RacingGameWinner(cars);
        winner.printWinners();
    }

    public void startRace(){
        for (int i = 0; i < numberOfRepetition; i++) {
            moveOrStop();
            printCurrentPositions();
            System.out.println();
        }
        findWinners(cars);
    }
}
