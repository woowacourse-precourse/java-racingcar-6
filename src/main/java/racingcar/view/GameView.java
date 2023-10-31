package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Game;

import java.util.List;
import java.util.stream.Collectors;

public class GameView {
    static final String CAR_NAME_INPUT_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String TRY_NUM_PHRASE = "시도할 회수는 몇회인가요?";
    static final String MOVE_FORWARD_MARK = "-";
    static final String CLONE = " : ";
    static final String DELIMITER = ", ";
    static final String RESULT_PHRASE = "\n실행 결과";
    static final String WINNER_PHRASE = "최종 우승자";

    public static void printCarNameInputPhrase() {
        System.out.println(CAR_NAME_INPUT_PHRASE);
    }

    public static void printTryNumPhrase() {
        System.out.println(TRY_NUM_PHRASE);
    }

    public static void printResultPhrase() {
        System.out.println(RESULT_PHRASE);
    }
}
