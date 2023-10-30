package racingcar;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

import static org.assertj.core.util.Arrays.asList;

public class UserInput {
    public List<String> inputRacingCarName() {
        String input = Console.readLine();
        String inputArray[] = input.split(",");
        List<String> racingCarName = new ArrayList<>(Arrays.asList(inputArray));
        System.out.println(racingCarName);
        return racingCarName;
    }
}
