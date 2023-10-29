package racingcar.view;

import static racingcar.message.RacingCarMessage.ASK_CAR_NAMES;
import static racingcar.message.RacingCarMessage.ASK_GAME_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String askCarNames() {
        System.out.println(ASK_CAR_NAMES);
        String carNames = Console.readLine();
        Console.close();
        return carNames;
    }

    public int askGameCount() {
        System.out.println(ASK_GAME_COUNT);
        String gameCount = Console.readLine();
        Console.close();
        validateInteger(gameCount);
        return Integer.parseInt(gameCount);
    }

    private void validateInteger(String input) {

    }
}
