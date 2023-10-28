package racingcar;

import static racingcar.Constant.SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final UserInputException userInputException; // 사용자 입력을 검증

    public InputView(UserInputException userInputException) {
        this.userInputException = userInputException;
    }

    public List<String> getCarName() {
        String[] carNames = Console.readLine().split(SEPARATOR);
        return List.of(carNames);
    }
}
