package racingcar.view;

import static racingcar.utils.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;


public class InputView {
    public static List<Car> inputCarNames() {
        String carstr = Console.readLine();
        validateCarInput(carstr);
        List<String> carNames = Arrays.stream(carstr.split(","))
                .map(String::trim)
                .toList();
        List<Car> cars = new ArrayList<>();
        for (String carname : carNames) {
            Car car = new Car(carname);
            cars.add(car);
        }
        return cars;
    }

    private static void validateCarInput(String carstr) {
        if (carstr.contains(",")) {
            return;
        }
        throw new IllegalArgumentException(INVALID_SPLIT_CHAR.getMessage());
    }

    public static int inputAttempNum() {
        try {
            int attempNum = Integer.parseInt(Console.readLine());
            return attempNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_DIGIT_ATTEMP_NUM.getMessage());
        }
    }

}
