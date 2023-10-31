package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String HYPHEN = "-";
    private static final String FINAL_WINNERS = "최종 우승자 : ";
    private static final String COMMA = ", ";
    private static final String COLON = " : ";
    private static final String CAR_NAMES_INPUT_CALL_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIALS_INPUT_CALL_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_TEXT = "실행 결과";

    public void printRaceStartingMessage() {
        System.out.println(CAR_NAMES_INPUT_CALL_MESSAGE);
    }

    public void printGetTrialsMessage() {
        System.out.println(TRIALS_INPUT_CALL_MESSAGE);
    }

    public void printRacingResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_TEXT);
    }

    public void printEachTrialResult(List<Car> cars) {
        for (Car car : cars) {
            printEachCarLocation(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNamesList = new ArrayList<>();
        for (Car winner : winners) {
            winnerNamesList.add(winner.getName());
        }

        String winnerNames = String.join(COMMA, winnerNamesList);
        System.out.println(FINAL_WINNERS + winnerNames);
    }

    private void printEachCarLocation(Car car) {
        System.out.println(car.getName() + COLON + getCarLocationString(car));
    }

    private StringBuilder getCarLocationString(Car car) {
        StringBuilder locationOutput = new StringBuilder();
        int carLocation = Math.max(Car.CAR_DEFAULT_LOCATION, car.getLocation());
        locationOutput.append(HYPHEN.repeat(carLocation));
        return locationOutput;
    }
}
