package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String NEW_LINE = "\n";
    private static final String COLON_SIGN = " : ";
    private static final String MOVE_SIGN = "-";
    private static final String COMMA_SIGN = ", ";

    public void printRequestCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public void printRequestTryCount() {
        System.out.println(INPUT_TRY_COUNT);
    }

    public void printExecutionResult() {
        System.out.println(NEW_LINE + EXECUTION_RESULT);
    }

    public void printRoundByExecutionResults(final Cars cars) {
        StringBuilder resultByRound = new StringBuilder();
        for (Car car : cars.getCars()) {
            resultByRound.append(car.getCarName())
                    .append(COLON_SIGN)
                    .append(MOVE_SIGN.repeat(car.getDistance()))
                    .append(NEW_LINE);
        }
        System.out.println(resultByRound);
    }

    public void printRacingCarWinnerResult(final Cars cars) {
        List<String> winners = cars.findWinners();
        StringBuilder winnerRacingCar = new StringBuilder();
        winnerRacingCar.append(FINAL_WINNER)
                .append(COLON_SIGN);

        for (int carIdx = 0; carIdx < winners.size(); carIdx++) {
            winnerRacingCar.append(winners.get(carIdx));
            if (isJointWinner(carIdx, winners)) {
                winnerRacingCar.append(COMMA_SIGN);
            }
        }
        System.out.println(winnerRacingCar);
    }

    private boolean isJointWinner(int idx, List<String> winners) {
        return idx < (winners.size() - 1);
    }
}
