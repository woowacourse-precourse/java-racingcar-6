package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputProcess {
    public static List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        InputValidator.validateNamesInput(names);

        return Arrays.stream(names.split(",")).map(Car::new).toList();
    }

    public static int inputCountNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String countString = Console.readLine();
        InputValidator.validateCountInput(countString);

        return Integer.parseInt(countString);
    }
}
