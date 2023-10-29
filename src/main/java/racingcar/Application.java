package racingcar;

import racingcar.validate.InvalidInputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final InvalidInputException invalidInputException = new InvalidInputException();
    private static final Map<String, Integer> carMap = new HashMap<>();

    public static void main(String[] args) {
        // 자동차 입력 안내 메세지 출력
        outputView.carNameInputMessage();

        // 자동차 이름 입력
        String input = inputView.carNamesInput();
        invalidInputException.checkInput(input);

        String[] inputCarNames = input.split(",");
        for (String carName : inputCarNames) {
            carMap.put(carName, 0);
        }

        // 시도할 횟수 입력 안내 메세지 출력
        outputView.timesInputMessage();
    }
}
