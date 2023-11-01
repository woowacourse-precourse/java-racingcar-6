package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<Car> inputCarName() {
        String carName = Console.readLine();
        String[] carNameArr = carName.split(",");

        return Arrays.stream(carNameArr)
                .map(Car::new)
                .toList();
    }

    public static Integer inputGameTry() {
        String gameTry = Console.readLine();

        return Integer.parseInt(gameTry);
    }

}
