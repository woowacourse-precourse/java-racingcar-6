package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    List<Car> cars = new ArrayList<>();

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startGame() {
        inputView.setCarName(cars);
        int play_count = inputView.setPlayCount();

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < play_count; i++) {
            play();
            System.out.println();
        }

        outputView.result(getWinner());
    }

    private void play() {
        cars.forEach(car -> {
            car.move();
            String name = car.getName();
            int position = car.getPosition();
            outputView.printEachCarResult(name, position);
        });
    }

    private String getWinner() {
        int max_score = cars.stream()
                            .max(Comparator.comparingInt(Car::getPosition))
                            .get()
                            .getPosition();

        String winner = cars.stream().filter(Car -> Car.getPosition() == max_score)
                                    .map(Car::getName)
                                    .collect(Collectors.joining(", "));

        return winner;
    }
}