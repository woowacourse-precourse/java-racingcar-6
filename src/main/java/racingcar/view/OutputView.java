package racingcar.view;

import racingcar.model.RacingModel;

public class OutputView {

    private static final String START_RACING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_TIMES = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String DISTANCE = "-";

    public void printStarting() {
        System.out.println(START_RACING);
    }

    public void printTimes() {
        System.out.println(NUMBER_OF_TIMES);
    }

    public void printRacing(RacingModel racingModel) {
        int[] moving_distances = racingModel.getMoving_distance();
        int times = 0;
        for (String player : racingModel.getPlayers()) {
            System.out.println(player + " : " + DISTANCE.repeat(moving_distances[times++]));
        }
    }


}
