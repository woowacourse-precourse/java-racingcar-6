package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGameInput {
    public static List<RacingCar> readCarNames() {
        String[] arr = Console.readLine().split(",");
        return Arrays.stream(arr)
                .map(RacingCar::new)
                .toList();
    }
}
