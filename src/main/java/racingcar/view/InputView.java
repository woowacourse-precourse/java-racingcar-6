package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Const;

public class InputView {

    public static String inputRacingCars() {
        System.out.println(Const.WELCOME_STRING);
        return Console.readLine();
    }

    public static String inputGames() {
        System.out.println(Const.MANY_GAMES_STRING);
        return Console.readLine();
    }
}
