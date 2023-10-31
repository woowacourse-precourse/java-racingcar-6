package racingcar.view;

import java.util.List;
import racingcar.race.Result;

public class OutputView {
    private static String INPUT_CAR_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private static String GAME_SET_VIEW = "\n실행결과";
    private static String RESULT_VIEW = "최종 우승자 : %s";

    public static void inputCarNameView() {
        System.out.println(INPUT_CAR_VIEW);
    }

    public static void inputTryNumberView() {
        System.out.println(INPUT_TRY_NUMBER);
    }

    public static void gameSetView() {
        System.out.println(GAME_SET_VIEW);
    }

    public static void outputRounds(List<Result> resultList) {
        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }
        System.out.println();
    }

    public static void outputResult(List<String> winnerList) {
        System.out.printf(RESULT_VIEW, String.join(", ", winnerList));
    }
}
