package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Objects;

public class InputView {

    public RacingCars inputNameOfRacingCars() {
        String input = Console.readLine();
        String[] split = input.split(",");
        return new RacingCars(Arrays.asList(split));
    }
}
