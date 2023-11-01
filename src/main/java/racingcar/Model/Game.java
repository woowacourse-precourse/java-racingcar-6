package racingcar.Model;

import static racingcar.Util.Constants.MAX_RANDOM;
import static racingcar.Util.Constants.MIN_RANDOM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.Util.Exceptions;

public class Game {
    private final List<Car> carList = new ArrayList<>();
    private final int repetition;

    public Game(List<String> carNames, int repetition) {
        findException(carNames, repetition);
        addList(carNames);
        this.repetition = repetition;
    }

    private void findException(List<String> carNames, int repetition) {
        Exceptions.isDuplicated(carNames);
        for (String carName : carNames) {
            Exceptions.isBlank(carName);
            Exceptions.isLessThanMaxLength(carName);
        }
        Exceptions.isPositiveNumber(repetition);
    }

    private void addList(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
    }

    public void play() {
        for (int i = 0; i < repetition; i++) {
            advance();
        }
    }

    private void advance() {
        for (Car car : carList) {
            car.go(Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM));
        }
        System.out.println();
    }

    public void result() {
        Car winner = findWinner();
        winner.printWinner();
        findJointWinner(winner);
    }

    private Car findWinner() {
        carList.sort(comparator);
        return carList.get(0);
    }

    private void findJointWinner(Car winner) {
        for (int i = 1; i < carList.size(); i++) {
            Car car = carList.get(i);
            if (car.getDistance() == winner.getDistance()) {
                car.printJointWinner();
            }
        }
    }

    private final Comparator<Car> comparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car2.getDistance() - car1.getDistance();
        }
    };
}
