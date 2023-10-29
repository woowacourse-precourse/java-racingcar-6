package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String[] readCarNames() {
        String names = readLine();
        String[] carNames = new String[]{};
        try {
            carNames = names.split(",");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return carNames;
    }
}
