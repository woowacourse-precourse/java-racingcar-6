package racingcar.io;

import static racingcar.constant.CarRacingConstant.CAR_NAME_SEPARATOR;
import static racingcar.constant.CarRacingMessage.INPUT_CAR_NAMES_MESSAGE;
import static racingcar.constant.CarRacingMessage.INPUT_TRY_COUNT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;


public class CarRacingInputManager {
    private final CarRacingOutputManager outputManager;

    public CarRacingInputManager(CarRacingOutputManager outputManager) {
        this.outputManager = outputManager;
    }


    public List<String> readCarNames() {
        outputManager.println(INPUT_CAR_NAMES_MESSAGE);
        return Arrays
                .stream(readLine().split(CAR_NAME_SEPARATOR))
                .toList();
    }

    public String readTryToMoveTurnCount() {
        outputManager.println(INPUT_TRY_COUNT_MESSAGE);
        return readLine();
    }

    // `디미터의 법칙`에 따라 분리
    // 개발자가 Console을 알아야할 필요없이 readLine만 알아도 됨.
    private String readLine() {
        return Console.readLine();
    }
}
