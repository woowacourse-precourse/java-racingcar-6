package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.RacingMessage;
import racingcar.model.Car;

public class RacingView {

    private static final String CAR_NAME_SEPARATOR = ",";

    public List<Car> inputCarNames() {
        System.out.println(RacingMessage.INPUT_CAR_NAME);
        return Arrays.stream(Console.readLine().split(CAR_NAME_SEPARATOR)).map(Car::new).collect(
            Collectors.toList());
    }
}
