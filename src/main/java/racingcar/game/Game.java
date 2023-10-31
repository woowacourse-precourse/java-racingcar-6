package racingcar.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import racingcar.firstclasscollection.CarList;
import racingcar.firstclasscollection.PositionMap;
import racingcar.model.Car;
import racingcar.model.RoundNumber;

public class Game {
    private CarList carList;
    private RoundNumber roundNumber;
    private PositionMap positions;

    public Game(String[] carNames, String roundString) {
        makeCars(carNames);
        initPosition();
        this.roundNumber = new RoundNumber(roundString);
    }

    private void makeCars(String[] carNames) {
        carList = new CarList(ArrayList::new);
        Arrays.stream(carNames)
                .map(Car::new)
                .forEach(carList::addCar);
    }

    private void initPosition() {
        positions = new PositionMap(HashMap::new);
        carList.forEachCar((car) -> positions.putCar(car));
    }

    public void play() {
        System.out.println("실행 결과");
        for (int round = 0; round < roundNumber.getNumber(); round++) {
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
        String winner = positions.getWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.println("최종 우승자 : " + winner);
    }
}
