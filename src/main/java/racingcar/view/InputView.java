package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String askForCarName() {
        System.out.println(UITexts.ASK_FOR_CAR_NAME.getText());
        String carNames = Console.readLine();
        return carNames;
    }

    public static String howManyTries() {
        System.out.println(UITexts.HOW_MANY_TRIES.getText());
        String tries = Console.readLine();
        System.out.println();
        return tries;
    }
}
