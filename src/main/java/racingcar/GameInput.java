package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameInput {

    public static List<String> CarsName() {
        String carsName = Console.readLine();
        List<String> names = splitNamesByComma(carsName);
        InputValidator.carsName(carsName, names);
        return names;
    }

    private static List<String> splitNamesByComma(String names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names.split(",")) {
            nameList.add(name);
        }
        return nameList;
    }

    public static int raceTime() {
        String raceTimeString = Console.readLine();
        InputValidator.isStringConvertToInteger(raceTimeString);
        return Integer.valueOf(raceTimeString);
    }

}
