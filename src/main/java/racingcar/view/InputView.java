package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        String carNames = Console.readLine();
        return carNames;
    }

    public static String inputTrialCount() {
        String trialCount = Console.readLine();
        return trialCount;
    }
}