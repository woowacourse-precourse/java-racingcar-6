package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {

    private static final String DELIMITER = ", ";

    private final RandomNumber randomNumber = new RandomNumber();

    private Cars cars;

    public void createCars(String carsName) {
        cars = new Cars(carsName);
    }

    public void moveCars() {
        int number = generateNumber();
        cars.moveCars(number);
    }

    private int generateNumber() {
        return randomNumber.create();
    }


    public String outputWinner() {
        return separateWinners(findWinner());
    }

    private List<String> findWinner() {
        return cars.findLongDistanceCarsName();
    }

    private String separateWinners(List<String> winnerName) {
        return winnerName.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }

    public int countCars() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.getCar(index);
    }
}
