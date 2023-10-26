package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    public List<String> getCarNamesFromUser() {

        String carName = Console.readLine().replace(" ", "").toLowerCase();

        List<String> carNames = new ArrayList<>(Arrays.asList(carName.split(",")));

        return carNames;
    }

    public int getNumberOfMovesFromUser() {

        int numberOfTimes = Integer.parseInt(Console.readLine());

        return numberOfTimes;
    }
}
