package racingcar.view;

import java.util.List;
import racingcar.race.Result;

public class OutputView {
    public static String INPUT_CAR_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    public static String GAME_SET_VIEW = "\n실행결과";

    public static void inputCarNameView() {
        System.out.println(INPUT_CAR_VIEW);
    }

    public static void inputTryNumberView() {
        System.out.println(INPUT_TRY_NUMBER);
    }

    public static void gameSetView() {
        System.out.println(GAME_SET_VIEW);
    }

    public static void roundConditionView(List<Result> resultList) {
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
        System.out.println();
    }
}
