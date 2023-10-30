package racingcar.io;

public class OutputWriter {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String INPUT_TRY_TIMES = "시도할 회수는 몇회인가요?\n";
    private static final String GAME_RESULT = "\n실행 결과";

    public void writeInputNameMsg() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public void writeInputTryTimesMsg() {
        System.out.println(INPUT_TRY_TIMES);
    }

    public void writeGameResultMsg() {
        System.out.println(GAME_RESULT);
    }
}
