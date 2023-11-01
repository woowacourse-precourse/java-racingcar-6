package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static String[] CarsName() {
        String carsName = Console.readLine();
        String[] names = splitNamesByComma(carsName);
        InputValidator.carsName(carsName, names);
        return names;
    }

    private static String[] splitNamesByComma(String names) {
        return names.split(",");
    }

    public static int raceTime() {
        String raceTimeString = Console.readLine();
        InputValidator.isStringConvertToInteger(raceTimeString);
        return Integer.valueOf(raceTimeString);
    }

}
