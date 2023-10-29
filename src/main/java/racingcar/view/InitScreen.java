package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.dto.InitDTO;

public class InitScreen {
    public static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_NUM_OF_ROUNDS = "시도할 회수는 몇회인가요?";
    public static InitDTO init(){
        String carNames = readCarNames();
        String rounds = readRounds();
        return new InitDTO(carNames, rounds);
    }
    public static String readCarNames() {
        System.out.println(REQUEST_CAR_NAME);
        return Console.readLine();
    }

    public static String readRounds() {
        System.out.println(REQUEST_NUM_OF_ROUNDS);
        return Console.readLine();
    }
}
