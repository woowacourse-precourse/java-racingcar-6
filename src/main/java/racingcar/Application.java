package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validate.InvalidInputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_LAST_NUMBER = 9;
    private static final int MIN_FORWARD_NUMBER = 4;
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

        // 시도할 횟수 입력
        String times = inputView.timesInput();
        invalidInputException.checkTimes(times);

        // '실행 결과' 메세지 출력
        outputView.resultMessage();

        // 우승자 판정 변수 선언
        int maxForward = 0;

        // 경주 시작
        for (int i = 0; i < Integer.parseInt(times); i++) {
            for (int k = 0; k < inputCarNames.length; k++) {
                int randomNumber = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_LAST_NUMBER);
                if (randomNumber >= MIN_FORWARD_NUMBER) {
                    carMap.put(inputCarNames[k], carMap.get(inputCarNames[k]) + 1);
                }
                if (carMap.get(inputCarNames[k]) > maxForward) {
                    maxForward = carMap.get(inputCarNames[k]);
                }

                outputView.CarNameOutput(inputCarNames[k]);
                outputView.resultCountOutput(carMap.get(inputCarNames[k]));
            }
            outputView.printOutput();
        }
    }
}
