package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInputHandler {
    public List<String> inputNames() {
        System.out.println(Constants.INPUT_CAR_NAMES);
        String names = Console.readLine();

        return makeSeparationNames(names);
    }

    private List<String> makeSeparationNames(String names) {

        return List.of(names.split(",", -1));
    }

    public int inputRacingNumber() {
        System.out.println(Constants.INPUT_GAME_GROUND_NUM);

        return Integer.parseInt(Console.readLine());
    }

}
