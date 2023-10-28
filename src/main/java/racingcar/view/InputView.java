package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCars;

public class InputView {
    public RacingCars getCars() {
        String input = Console.readLine();
//        validateCars(input);
        return RacingCars.stringToRacingCars(input);
    }

    public static int getPlayTime() {
        return 0;
    }
}
