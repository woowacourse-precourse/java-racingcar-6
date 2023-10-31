package racingcar.util;

import racingcar.domain.Car;
import racingcar.input.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.MessageConstant.WINNER_MESSAGE;

public class GameUtil {
    private final List<Car> carList;
    private int totalRound;
    private int nowRound;

    public GameUtil() {
        this.carList = new ArrayList<>();
    }

    public void initGame() {
        initCar();
        initRound();
    }

    private void initRound() {
        this.nowRound = 0;
        this.totalRound = Input.inputTotalTurn();
    }

    private void initCar() {
        List<String> carNames = Input.inputCarName();
        carNames.forEach(carName -> carList.add(new Car(carName)));
    }

    public boolean checkGameOver() {
        return this.totalRound == this.nowRound;
    }

    public void startRound() {
        this.nowRound++;

        carList.forEach(Car::isForward);
    }

    public void showResults() {
        carList.forEach(System.out::println);
        System.out.println();
    }

    public void showWinners() {
        int max = findMax();

        List<String> winners = findWinner(max);

        System.out.println(WINNER_MESSAGE.getWinner(String.join(", ", winners)));
    }

    private int findMax() {
        return carList.stream()
                .mapToInt(Car::getForwardSize)
                .max()
                .orElse(0);
    }

    public List<String> findWinner(int max) {
        return carList.stream()
                .filter(car -> car.getForwardSize() == max)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
