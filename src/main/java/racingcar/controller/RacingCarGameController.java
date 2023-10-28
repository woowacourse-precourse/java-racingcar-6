package racingcar.controller;


import static racingcar.util.RandomNumber.randomNumber;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final List<Car> cars;


    public RacingCarGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.cars = new ArrayList<>();
    }

    public void play() {

        List<String> carNames = inputView.getCarNames();

        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }

        int moveCount = inputView.getMoveCount();

        int index = 0;

        System.out.println();
        System.out.println("실행 결과");

        while (index < moveCount) {
            moveCarForward();
            outputView.printPositions(cars);
            index++;
        }

        List<Car> winners = findWinners();
        outputView.printWinners(winners);

    }

    private void moveCarForward() {
        for (Car car : cars) {
            int randomNumber = randomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    private List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

}