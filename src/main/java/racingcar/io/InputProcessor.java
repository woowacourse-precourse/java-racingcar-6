package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.io.validator.CarInputValidator;
import racingcar.io.validator.GameTryCountInputValidator;

import java.util.List;

public class InputProcessor {
    private static final String CAR_READ_SEPARATOR = ",";

    private static final CarInputValidator carInputValidator = new CarInputValidator();
    private static final GameTryCountInputValidator gameTryCountInputValidator = new GameTryCountInputValidator();

    private InputProcessor() {
    }

    public static List<String> readParticipateCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        final List<String> cars = readCars();
        carInputValidator.validate(cars);

        return cars;
    }

    private static List<String> readCars() {
        final String userInput = Console.readLine();
        return List.of(userInput.split(CAR_READ_SEPARATOR));
    }

    public static int readAttemptCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        final String userInput = Console.readLine();
        gameTryCountInputValidator.validate(userInput);

        return Integer.parseInt(userInput);
    }
}
