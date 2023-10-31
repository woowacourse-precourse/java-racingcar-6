package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingService {
    public List<Car> createCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.createCar(carName));
        }
        return cars;
    }

    public List<Car> playSingleRound(List<Car> cars) {
        playRacing(cars);
        checkRoundWinner(cars);
        return cars;
    }

    private static void playRacing(List<Car> cars) {
        for (Car car : cars) {
            int move = Randoms.pickNumberInRange(0, 9);
            car.moveForward(move);
        }
    }

    private static void checkRoundWinner(List<Car> cars) {
        int maxMove = getMaxMove(cars);
        for (Car car : cars) {
            plusWinnerCount(maxMove, car);
        }
    }

    private static int getMaxMove(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }

    private static void plusWinnerCount(int max, Car car) {
        if (max == car.getMove()) {
            car.plusWinCount();
        }
    }

    public List<String> findByVictoryPlayers(List<Car> cars) {
        List<String> victoryCars = new ArrayList<>();
        cars.sort(Collections.reverseOrder(Comparator.comparing(Car::getWinCount)));
        Car vitoryCar = cars.get(0);

        for (Car car : cars) {
            checkVictoryPlayer(victoryCars, vitoryCar.getWinCount(), car);
        }

        return victoryCars;
    }

    private static void checkVictoryPlayer(List<String> victoryPlayers, int victoryCount, Car car) {
        int winCount = car.getWinCount();
        if (victoryCount == winCount) {
            victoryPlayers.add(car.getName());
        }
    }
}
