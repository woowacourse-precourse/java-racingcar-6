package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.constants.Phrase;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.GameRequestDto;

public class InputView {
    public static CarRequestDto getCarNames() {
        return new CarRequestDto(printPhrase(Phrase.GAME_START));
    }

    public static GameRequestDto getGameTrial() {
        return new GameRequestDto(printPhrase(Phrase.GAME_TRIAL));
    }

    private static String printPhrase(Phrase phrase) {
        System.out.println(phrase.getMessage());
        return Console.readLine();
    }
}