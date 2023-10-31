package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {
    }

    public static List<String> readCarName() {
        String cars = Console.readLine();
        Validator.validateBlack(cars);
        List<String> names = Arrays.stream(cars.split(",")).toList();
        names.forEach(name -> Validator.validateLength(name, 5));
        return names;
    }

    public static int readMoveCount() {
        String moveCountInput = Console.readLine();
        Validator.validateBlack(moveCountInput);
        int moveCount = Validator.validateInteger(moveCountInput);
        Validator.validateLargeThanParam2(moveCount, 1);

        return moveCount;
    }
}
