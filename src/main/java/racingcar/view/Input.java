package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.service.ValidateService.isNumber;

public class Input {
    public static String askCarNames(){
        return readLine();
    }

    public static int askNumberOfGames(){
        String Number = readLine();
        isNumber(Number);
        return Integer.parseInt(Number);
    }
}
