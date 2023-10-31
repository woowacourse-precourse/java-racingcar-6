package racingcar.game;

import racingcar.car.Car;
import racingcar.round.Round;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.car.CarSetting.MAX_LENGTH_OF_NAME;

public class Game {
    private String carNames;
    private String numberOfTry;
    private int tryNumber;

    public Game() throws IllegalArgumentException {
        printPhrasesCarName();
        inputCarName();
        printPhraseNumberOfTry();
        inputNumberOfTry();
        initRound();
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

    public List<Car> makeCarEntity() throws IllegalArgumentException{
        List<Car> cars = new ArrayList<>();

        for (String name : carNames.split(",")) {
            if (!checkDuplicationName(cars, name)) throw new IllegalArgumentException();
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

    public void initRound() throws IllegalArgumentException {
        if (!checkNumberOfTry()) throw new IllegalArgumentException();

        tryNumber = Integer.parseInt(numberOfTry);
    }

    private boolean checkNumberOfTry() {
        try {
            Integer.parseInt(numberOfTry);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
