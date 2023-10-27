package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String getCarNamesFromUser() {
        return readLine();
    }

    public static int getAttemptCountFromUser() {
        return Integer.parseInt(readLine());
    }
}
