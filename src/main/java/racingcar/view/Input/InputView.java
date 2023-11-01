package racingcar.view.Input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;

import static racingcar.view.PrintMessage.INPUT_CAR_NAME;
import static racingcar.view.PrintMessage.INPUT_TRIAL_NUMBER;

/* 자동차 입력 받는 클래스
*  입력만 받기
* */
public class InputView {
    private InputParser inputParser;
    private InputValidator inputValidator;
    // 생성자
    public InputView(InputParser inputParser, InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }


    // 자동차 입력만 받기
    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    public List<Car> convertInputCarName(String input) {
        inputValidator.isNull(input.replace(" ",""));

        return inputParser.convertCarList(input);
    }

    // 시도 횟수 입력 받기
    public String inputTrialNumber() {
        System.out.println(INPUT_TRIAL_NUMBER);
        return Console.readLine();
    }
    public int convertInputTrialNumber() {
        String trialNumber = inputTrialNumber();
        inputValidator.validateTrialNumber(trialNumber);

        return inputParser.convertTrialNumber(trialNumber);
    }
}
