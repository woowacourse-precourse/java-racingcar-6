package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.InputValidate;

public class InputView {

    private InputView() {
    }

    public static Integer getMovingCount() {
        String movingCount = Console.readLine();
        InputValidate.validateMovingCount(movingCount);
        return Integer.parseInt(movingCount);
    }

    public static List<Car> getCarNames() {
        String carNames = Console.readLine();
        InputValidate.validateCarNames(carNames);
        return getCarNameList(carNames);
    }

    public static List<Car> getCarNameList(String carNames) {
        String[] carNameArr = carNames.trim().split("\\s*,\\s*");
        InputValidate.checkLengthCarName(carNameArr);

        return Arrays.stream(carNameArr)
                .map(Car::new)
                .toList();
    }


}
