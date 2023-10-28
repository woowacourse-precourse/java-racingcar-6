package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String PROMPT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_NUMBER_OF_GAME_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";
    private static final String DISTANCE = "-";
    private static final String COLON_WITH_SPACES = " : ";
    private static final String WINNER_MESSAGE = "최종 우승자" + COLON_WITH_SPACES + "%s";


    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void promptCarNames() {
        System.out.println(PROMPT_CAR_NAMES_MESSAGE);
    }

    public void promptNumberOfGameAttempts() {
        System.out.println(PROMPT_NUMBER_OF_GAME_ATTEMPTS_MESSAGE);
    }

    public void printGameResult() {
        printNewEmptyLine();
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printGameResultsPerAttempt(List<String> carNames, List<Integer> movingDistances) {
        validateSizeOfCarNamesAndMovingDistances(carNames, movingDistances);
        int size = carNames.size();

        for (int iterator = 0; iterator < size; iterator++) {
            String carName = carNames.get(iterator);
            String movingDistance = DISTANCE.repeat(movingDistances.get(iterator));

            System.out.println(carName + COLON_WITH_SPACES + movingDistance);
        }

        printNewEmptyLine();
    }

    public void printWinnersOfGame(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(String.format(WINNER_MESSAGE, winnerNames));
    }

    private void printNewEmptyLine() {
        System.out.println();
    }

    private void validateSizeOfCarNamesAndMovingDistances(List<String> carNames,
        List<Integer> movingDistances) {
        if (carNames.size() != movingDistances.size()) {
            throw new IllegalArgumentException();
        }
    }
}
