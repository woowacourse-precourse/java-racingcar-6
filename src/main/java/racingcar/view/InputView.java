package racingcar.view;

import static racingcar.model.constants.Phrase.GAME_START;
import static racingcar.model.constants.Phrase.GAME_TRIAL;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.GameRequestDto;

public class InputView {
    public static CarRequestDto setCarNames() {
        System.out.println(GAME_START.getPhrase());
        return new CarRequestDto(Console.readLine());
    }

    public static GameRequestDto setGameTrial() {
        System.out.println(GAME_TRIAL.getPhrase());
        return new GameRequestDto(Console.readLine());
    }
}