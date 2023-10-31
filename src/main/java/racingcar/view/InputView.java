package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private InputView() {
    }

    public static List<String> readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        Validator.validateBlack(cars);
        List<String> names = Arrays.stream(cars.split(",")).toList();
        names.forEach(name -> Validator.validateLength(name, 5));
        return names;
    }

    public static int readMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String moveCountInput = Console.readLine();
        Validator.validateBlack(moveCountInput);
        int moveCount = Validator.validateInteger(moveCountInput);
        Validator.validateLargeThanParam2(moveCount, 1);

        return moveCount;
    }
}
