package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {
    public String[] inputNames() {
        System.out.println(Constants.INPUT_CAR_NAMES);
        String names = Console.readLine();

        return makeSeparationNames(names);
    }

    private String[] makeSeparationNames(String names) {

        return names.split(",");
    }

    public int inputRacingNumber() {
        System.out.println(Constants.INPUT_GAME_GROUND_NUM);

        return Integer.parseInt(Console.readLine());
    }

}
