package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Utils.*;

public class RacingGame {
    private final int MINIMUM_NUMBER_OF_NAME = 2;
    private final String ERROR_NOT_ENOUGH_NUMBER_OF_NAME = "충분한 수가 아닙니다. 최소 2개 이상 입력해주세요.";

    private int howManyTries;
    private final Referee referee = new Referee();

    public void run() {
        String carNames = getCarNamesWithCommaSeparated();
        List<String> carNameList = mapToListAndValidateName(carNames);
        List<Car> cars = createCars(carNameList);
        howManyTries = getHowManyTries();
        startRacing(cars);
        List<Car> winners = referee.getWinners(cars);
        printWinners(winners);
    }

    private void printWinners(List<Car> winners) {
        String result = "최종 우승자 : " + winners.stream().map(Car::getName).collect(Collectors.joining(" ,"));
        System.out.print(result);
    }


    private void startRacing(List<Car> cars) {
        StringBuilder racingResult = new StringBuilder("\n실행 결과\n");
        while (howManyTries > 0) {
            for (Car car : cars) {
                car.moveForwardOrStop();
                racingResult
                        .append(car)
                        .append("\n");
            }
            racingResult.append("\n");
            howManyTries--;
        }
        System.out.print(racingResult.toString());
    }

    private List<Car> createCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNameList) {
            cars.add(Car.createCarByName(name));
        }
        return cars;
    }

    private List<String> mapToListAndValidateName(String carNames) {
        List<String> carNameList = splitToListBySeparator(carNames);
        checkIfEnoughNumberOfName(carNameList);
        return carNameList;
    }

    private void checkIfEnoughNumberOfName(List<String> names) {
        if (names.size() < MINIMUM_NUMBER_OF_NAME) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_NUMBER_OF_NAME);
        }
    }


}
