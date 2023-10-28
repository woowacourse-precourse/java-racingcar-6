package racingcar.view;

import static racingcar.model.constants.Phrase.GAME_START;
import static racingcar.model.constants.Phrase.GAME_TRIAL;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.dto.CarRequestDto;

public class InputView {
    public CarRequestDto setCarNames() {
        System.out.println(GAME_START.getPhrase());
        return new CarRequestDto(Console.readLine());
    }

    public static String setGameTrial() {
        System.out.println(GAME_TRIAL.getPhrase());
        return Console.readLine();
    }
}