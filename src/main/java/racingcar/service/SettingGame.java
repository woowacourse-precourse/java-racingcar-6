package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.ValidCheck;

public class SettingGame {
    public static int numberOfGame(){
        String input = Console.readLine();
        return ValidCheck.moveTypeCheck(input);
    }
}