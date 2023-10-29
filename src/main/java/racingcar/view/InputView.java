package racingcar.view;

import static racingcar.message.RacingCarMessage.ASK_CAR_NAMES;
import static racingcar.message.RacingCarMessage.ASK_GAME_COUNT;
import static racingcar.util.NameSplitter.split;
import static racingcar.util.Validator.validateInteger;
import static racingcar.util.Validator.validateNotEmpty;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] askCarNames() {
        System.out.println(ASK_CAR_NAMES);
        String carNames = Console.readLine();
        validateNotEmpty(carNames);
        return split(carNames);
    }

    public int askGameCount() {
        System.out.println(ASK_GAME_COUNT);
        String gameCount = Console.readLine();
        validateNotEmpty(gameCount);
        validateInteger(gameCount);
        return Integer.parseInt(gameCount);
    }
}
