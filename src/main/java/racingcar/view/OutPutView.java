package racingcar.view;

import racingcar.model.Cars;

public class OutPutView {
    public final String START_METION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String ASK_TRY_COUNT = "시도할 회수는 몇회인가요?";
    public final String EXECUTE_RESULT = "실행 결과";
    public final String COLON = " : ";
    public final String ONE_STEP = "-";
    public final String WINNER_TEMPLATE = "최종 우승자";

    public void startMention() {
        System.out.println(START_METION);
    }

    public void tryCount() {
        System.out.println(ASK_TRY_COUNT);
    }

    public void executeResult(Cars cars) {
        System.out.println(EXECUTE_RESULT);
        cars.getCarsData().forEach((key, value)
                -> System.out.println(key + COLON + ONE_STEP.repeat(Math.max(0, value))));
        System.out.println();
    }

    public void winner(String winner) {
        System.out.println(WINNER_TEMPLATE + COLON + winner);
    }
}
