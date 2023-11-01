package racingcar.view;

import java.util.List;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.RacingGame;

public class ConsoleOutputView implements OutputView {
    private static final String EXECUTION_RESULT_LABEL = "실행 결과";
    private static final String WINNER_LABEL = "최종 우승자 : ";

    @Override
    public void outputExcutionResult(RacingGame racingGame) {
        System.out.println(EXECUTION_RESULT_LABEL);

        for (int i = 0; i < racingGame.getTryCount(); i++) {
            outputCarNameAndPosition(racingGame.getParticipationsList(), i);
            System.out.println();
        }
    }

    private void outputCarNameAndPosition(List<Car> carList, int index) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.findPositionAt(index)));
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

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb.toString());
    }
}
