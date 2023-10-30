package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.firstclasscollection.CarList;
import racingcar.firstclasscollection.PositionMap;
import racingcar.model.Car;

public class Game {
    private CarList carList;
    private int roundNumber;
    private PositionMap positions;

    public Game(String[] carNames, int roundNumber) {
        makeCars(carNames);
        initPosition();
        this.roundNumber = roundNumber;
    }

    private void makeCars(String[] carNames) {
        carList = new CarList();
        Arrays.stream(carNames)
                .map(Car::new)
                .forEach(carList::addCar);
    }

    private void initPosition() {
        positions = new PositionMap();
        carList.forEachCar((car) -> positions.addCar(car));
    }

    public void play() {
        System.out.println("실행 결과");
        for (int round = 0; round < roundNumber; round++) {
            playRound();
        }
        printWinner();
    }

    private void playRound() {
        carList.forEachCar((car) -> {
            moveCar(car);
            System.out.println(car.getRoundResult());
        });
        System.out.println();
    }

    private void moveCar(Car car) {
        if (!car.isMove()) {
            return;
        }
        positions.moveCar(car);
    }

    private void printWinner() {
        String winner = positions.getWinner()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println("최종 우승자 : " + winner);
    }
}
