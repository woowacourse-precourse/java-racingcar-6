package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GameUtil {
    private Integer repeatNumber;
    private ArrayList<Car> cars;

    public GameUtil() {
        this.repeatNumber = 0;
        this.cars = new ArrayList<>();
    }

    public void runGame() {
        System.out.println(Constants.CAR_NAME_INPUT_COMMENT);
        String inputNames = Console.readLine();
        setCarsName(inputNames);

        System.out.println(Constants.REPEAT_NUMBER_INPUT_COMMENT);
        String repeatNumber = Console.readLine();
        setRepeatNumber(repeatNumber);

        for (int i = 0; i < this.repeatNumber; i++) {
            System.out.println(randomProgress(Constants.MIN_RANDOM_VALUE, Constants.MAX_RANDOM_VALUE) + '\n');
        }

        System.out.println(findWinners());
    }

    public void setCarsName(String inputNames) {
        String[] carNames = validateAndSplitCarNames(inputNames);

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private String[] validateAndSplitCarNames(String inputNames) {
        String[] carNames = inputNames.split(",");

        for (String name : carNames) {
            if (name.length() > Constants.CAR_NAME_MAXIMUM) {
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    public void setRepeatNumber(String repeatNumber) {
        validateRepeatNumber(repeatNumber);
        this.repeatNumber = Integer.parseInt(repeatNumber);
    }

    private void validateRepeatNumber(String repeatNumber) {
        try {
            Integer.parseInt(repeatNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(repeatNumber) < 0) {
            throw new IllegalArgumentException();
        }
    }

    public String randomProgress(Integer minRandomValue, Integer maxRandomValue) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(minRandomValue, maxRandomValue);

            if (randomNumber >= Constants.PROGRESS_LIMIT_NUMBER) {
                car.progress();
            }
        }

        return cars.stream().map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public String findWinners() {
        Car maxCar = cars.stream()
                .max(Comparator.comparing(Car::getProgress))
                .orElse(cars.get(0));

        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getProgress().equals(maxCar.getProgress())) {
                winners.add(car);
            }
        }

        return Constants.WINNER_PRINT_COMMENT +
                winners.stream().map(Car::getName)
                        .collect(Collectors.joining(", "));
    }
}
