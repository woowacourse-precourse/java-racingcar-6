package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.RacingCarException;

public class InputView {

    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_TIME = "시도할 회수는 몇회인가요?";
    public static RacingCarException racingCarException = new RacingCarException();

    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String carName = Console.readLine();
        return carName;
    }
    public int inputTryTime() {
        System.out.println(INPUT_TRY_TIME);
        String answer = Console.readLine();
        racingCarException.validateTryTime(answer);
        racingCarException.validatePositiveNumber(answer);
        int tryTime = Integer.parseInt(answer);
        return tryTime;
    }
}
