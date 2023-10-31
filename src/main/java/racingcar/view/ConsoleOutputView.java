package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class ConsoleOutputView implements OutputView {
    private static final String EXECUTION_RESULT_LABEL = "실행 결과";
    private static final String WINNER_LABEL = "최종 우승자 : ";

    @Override
    public void outputExcutionResult(RacingGame racingGame) {
        System.out.println(EXECUTION_RESULT_LABEL);

        for (int i = 0; i < racingGame.getTryCount(); i++) {
            for (Car car : racingGame.getParticipationsList()) {
                System.out.println(car.getName() + " : " + "-".repeat(car.findPositionAt(i))); //TODO: 분리
            }
            System.out.println();
        }

    }

    @Override
    public void outputWinner(RacingGame racingGame) {
        System.out.print(WINNER_LABEL);

        StringBuilder sb = new StringBuilder();
        for (Car car : racingGame.getWinnerList()) {
            sb.append(car.getName());
            sb.append(",");
        }

        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb.toString());
    }
}
