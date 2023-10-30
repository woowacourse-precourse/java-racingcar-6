package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

/* 자동차 입력 받는 클래스
*  입력만 받기
* */
public class InputView {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"; // 삼수
    private final String  INPUT_TRIAL_NUMBER = "시도할 회수는 몇회인가요?"; //  삼수
    public static int trialNumber; // 인스턴스 변수로 필요한지 고민

    private InputParser inputParser;
    // 생성자
    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }
    // 자동차 입력 받기
    public void inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        inputParser.parseCarString(Console.readLine());
    }

    // 시도 횟수 입력 받기
    public void inputTrialNumber() {
        System.out.println(INPUT_TRIAL_NUMBER);
        trialNumber = Integer.parseInt(Console.readLine());
    }
}
