package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.utils.InputValidate;

public class InputView {

    private InputView() {
    }

    public static Integer getMovingCount() {
        String movingCount = Console.readLine();
        InputValidate.validateMovingCount(movingCount);

        return Integer.parseInt(movingCount);
    }

    public static RacingCars getRacingCars() {
        String carNames = Console.readLine();
        InputValidate.validateCarNames(carNames);

        return new RacingCars(getCarNameList(carNames));
    }

    private static List<Car> getCarNameList(String carNames) {
        String[] carNameArr = carNames.trim().split("\\s*,\\s*");
        InputValidate.checkLengthCarName(carNameArr);
        InputValidate.checkDuplicateCarName(carNameArr);

        return Arrays.stream(carNameArr)
                .map(Car::new)
                .toList();
    }
}
