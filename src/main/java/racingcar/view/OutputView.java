package racingcar.view;

public class OutputView {
    private static final String DISTANCE_UNIT = "-";
    private static final String NAME_AND_POSITION_DELIMITER = " : ";

    public void printCarNameAndPosition(String carName, int position) {
        StringBuilder carNameAndPosition = new StringBuilder();
        carNameAndPosition.append(carName);
        carNameAndPosition.append(NAME_AND_POSITION_DELIMITER);
        carNameAndPosition.append(DISTANCE_UNIT.repeat(position));

        System.out.println(carNameAndPosition);
    }
}
