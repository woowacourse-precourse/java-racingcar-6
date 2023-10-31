package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.valid.CarNameValidator;
import racingcar.valid.TryCountValidator;

import java.util.List;

public class InputView {

    private final static String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNamesInput = Console.readLine();

        List<String> carNames = List.of(carNamesInput.split(","));
        CarNameValidator.validate(carNames);

        return carNames;
    }

    public static int readTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);

        String tryCountInput = Console.readLine();
        TryCountValidator.validate(tryCountInput);

        return Integer.parseInt(tryCountInput);
    }
}
