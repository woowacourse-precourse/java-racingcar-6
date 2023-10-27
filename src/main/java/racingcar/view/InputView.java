package racingcar.view;

import static racingcar.model.constants.Phrase.GAME_START;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String setCarNames() {
        System.out.println(GAME_START.getPhrase());
        return Console.readLine();
    }
}
