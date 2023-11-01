package racingcar;

import util.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final Input input = new Input();
    private static final RaceGame raceGame = new RaceGame();
    private static final String DELIMITER_FOR_INPUT = ",";

    public static void main(String[] args) {
        String carsName = input.askCarsName();
        String tryNumString = input.askTryNum();
        int tryNum = Converter.stringToInt(tryNumString);
        InputValidator.tryNum(tryNum);
        /**
         * raceGameValidator.validateTryNum(tryNum);
         * raceGameValidator.validateCarNames(carNames);
         */

        raceGame.run(makeCars(carsName), tryNum);
    }

    public static List<Car> makeCars(String carsName) {
        return Arrays.stream(Converter.stringToStringArray(carsName, DELIMITER_FOR_INPUT)).map(Car::new).toList();
    }
}
