package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class InputView {

    private InputView() {
    }

    public static Integer getMovingCount() {
        String movingCount = Console.readLine();
        racingcar.utils.InputValidate.validateMovingCount(movingCount);
        return Integer.parseInt(movingCount);
    }

    public static List<Car> getCarNames() {
        String carNames = Console.readLine();
        racingcar.utils.InputValidate.checkNullAndEmpty(carNames);
        return getCarNameList(carNames);
    }

    public static List<Car> getCarNameList(String carNames) {
        String[] carNameArr = carNames.split(",");
        racingcar.utils.InputValidate.checkLengthCarName(carNameArr);

        return Arrays.stream(carNameArr)
                .map(Car::new)
                .toList();
    }


}
