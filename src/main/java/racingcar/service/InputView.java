package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;


public class InputView {
    public static List<String> readRacerNames() {
        String racerNames = Console.readLine();
        List<String> racerNameList = Arrays.asList(racerNames.split(","));

        return racerNameList;
    }

    public static int readTryNumber() {
        String tryNumber = Console.readLine();
        validation.numCheck(tryNumber);

        return Integer.parseInt(tryNumber);
    }
}
