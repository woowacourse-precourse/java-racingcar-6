package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static String[] inputRacingCarNames() {
        OutputView.printInputRacingCarNamesMessage();
        String[] racingCarNames = Console.readLine().split(",");
        return racingCarNames;
    }
}
