package racingcar.game;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.car.CarSetting.MAX_LENGTH_OF_NAME;

public class Game {
    private String carNames;
    private String numberOfTry;

    public Game() {
        printPhrasesCarName();
        inputCarName();
        printPhraseNumberOfTry();
        inputNumberOfTry();
    }

    private void printPhrasesCarName() {
        System.out.println(GamePhrases.PHRASES_INPUT_CAR_NAME);
    }

    private void inputCarName() {
        carNames = readLine();
    }

    private void printPhraseNumberOfTry() {
        System.out.println(GamePhrases.PHRASES_INPUT_NUMBER_OF_TRY);
    }

    private void inputNumberOfTry() {
        numberOfTry = readLine();
    }

    public List<Car> makeCarEntity() {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames.split(",")) {
            if (checkDuplicationName(cars, name)) throw new IllegalArgumentException();
            else cars.add(new Car(name));
        }

        return cars;
    }

    private boolean checkDuplicationName(List<Car> cars, String carName) {
        for (Car car : cars) {
            if (car.getCarName().equals(carName)) return false;
        }

        return true;
    }
}
