package racingcar.views;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OutputView {
    public static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static final String INPUT_NUM_MESSAGE = "시도할 회수는 몇회인가요?";

    public static final String RACE_RESULT_MESSAGE = "실행 결과";

    public static final String RACE_WINNER_MESSAGE = "최종 우승자 : ";

    public OutputView(){
    }

    public static void inputCarMessage() {
        System.out.println(INPUT_CAR_MESSAGE);
    }

    public static void inputNumMessage() {
        System.out.println(INPUT_NUM_MESSAGE);
    }

    public static void raceResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public static void raceResult(String name, String race) {
        System.out.printf("%s : %s\n", name, race);
    }

    public static void raceWinnerMessage(String[] winners) {
        String winner = Arrays.stream(winners).collect(Collectors.joining(", "));
        System.out.println(RACE_WINNER_MESSAGE + winner);
    }



}
