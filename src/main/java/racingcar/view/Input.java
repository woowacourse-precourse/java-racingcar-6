package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private Input() {
    }

    public static String carNameInput() {
        String carNames = readLine();
        return carNames;
    }

    public static int attemptInput() {
        int numberOfAttempts = Integer.parseInt(readLine());
        return numberOfAttempts;
    }

}
