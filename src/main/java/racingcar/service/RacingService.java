package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.*;

public class RacingService {
    public List<Car> createCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.createCar(carName));
        }
        return cars;
    }

    public Map<String, Integer> playRacingCar(List<Car> cars) {
        Map<String, Integer> result = new LinkedHashMap<>();
        putRaceMove(cars, result);
        checkRoundWinner(cars, result);
        return result;
    }

    private static void putRaceMove(List<Car> cars, Map<String, Integer> result) {
        for (Car car : cars) {
            int move = Randoms.pickNumberInRange(0, 9);
            result.put(car.getName(), move);
        }
    }

    private static void checkRoundWinner(List<Car> cars, Map<String, Integer> result) {
        int max = Collections.max(result.values());
        for (Car car : cars) {
            Integer score = result.get(car.getName());
            plusWinnerCount(max, car, score);
        }
    }

    private static void plusWinnerCount(int max, Car car, Integer score) {
        if (max == score) {
            car.plusWinCount();
        }
    }
}
