package racingcar.view;

public class OutputView {
    private static final String DISTANCE_UNIT = "-";
    private static final String NAME_AND_POSITION_DELIMITER = " : ";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public void printCarNameAndPosition(String carName, int position) {
        StringBuilder carNameAndPosition = new StringBuilder();
        carNameAndPosition.append(carName);
        carNameAndPosition.append(NAME_AND_POSITION_DELIMITER);
        carNameAndPosition.append(DISTANCE_UNIT.repeat(position));

        System.out.println(carNameAndPosition);
    }

    public void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printNewLine() {
        System.out.println();
    }
}
