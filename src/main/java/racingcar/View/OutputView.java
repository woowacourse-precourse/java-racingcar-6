package racingcar.View;

import java.util.List;
import racingcar.Dto.CarDto;

public class OutputView {
    private final static String INPUT_RACING_CAR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_RACING_COUNT = "시도할 회수는 몇회인가요?";
    private final static String GAME_START = "\n게임을 시작합니다.";

    public static void printInputRacingCar() {
        System.out.println(INPUT_RACING_CAR);
    }

    public static void printInputRacingCount() {
        System.out.println(INPUT_RACING_COUNT);
    }

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printResult(String midResult) {
        System.out.println(midResult);
    }

    public static void printGameWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
