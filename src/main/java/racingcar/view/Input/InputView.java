package racingcar.view.Input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.view.Input.InputParser;
import racingcar.view.Input.InputValidator;

import java.util.List;

/* 자동차 입력 받는 클래스
*  입력만 받기
* */
public class InputView {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"; // 삼수
    private final String  INPUT_TRIAL_NUMBER = "시도할 회수는 몇회인가요?"; //  삼수

    private InputParser inputParser;
    private InputValidator inputValidator;
    // 생성자
    public InputView(InputParser inputParser, InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }
    // 자동차 입력 받기
    public List<Car> inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String input = Console.readLine();
        inputValidator.validateCarString(input.replace(" ",""));

        return inputParser.parseCarString(input);
    }

    // 시도 횟수 입력 받기
    public int inputTrialNumber() {
        System.out.println(INPUT_TRIAL_NUMBER);
        String trialNumber = Console.readLine();

        inputValidator.isNumberOnly(trialNumber);
        inputValidator.isPositiveOnly(trialNumber);

        return inputParser.parseTrialNumber(trialNumber);
    }
}
