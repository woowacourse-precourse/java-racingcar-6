package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validation.Validator;

public class InputView {
    public static List<String> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Arrays.stream(Console.readLine().split(",")).toList();

        Validator.validateCarsInput(cars);
        return cars;
    }

    public static int inputTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        int turn = Integer.parseInt(Console.readLine());
        return turn;
    }
}
