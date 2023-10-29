package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingCarGameInput {
    public static String ERROR_MESSAGE_BIGGER_THAN_5CHAR = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    public static List<RacingCar> readCarNames() {
        String[] arr = Console.readLine().split(",");
        return Arrays.stream(arr)
                .map(RacingCar::new)
                .toList();
    }

    public static boolean validateCarNames(List<RacingCar> carList) {
        for (RacingCar car : carList) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(ERROR_MESSAGE_BIGGER_THAN_5CHAR);
            }
        }
        return true;
    }
}
