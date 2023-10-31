package racingcar.gameutil;

import java.util.List;
import racingcar.domain.Car;

public enum GameMessage {
    CAR_NAME_INPUT_MSG("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_INPUT_MSG("시도할 회수는 몇회인가요?"),
    EXECUTION_RESULT_MSG("실행 결과"),
    WINNER_MSG("최종 우승자 : ");

    private String message;

    GameMessage(String msg) {
        message = msg;
    }

    public String getMsg() {
        return message;
    }

    public static String moveResult(Car car) {
        return car.getName() + " : " + car.showDistance();
    }

    public static String winners(List<String> winners) {
        return String.join(", ", winners);
    }
}
