package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.ExceptionMessage.NOT_LESS_THAN_ZERO;
import static racingcar.view.ExceptionMessage.NOT_NUMBER_FORMAT;

import java.util.List;
import java.util.NoSuchElementException;

public class InputView {
    // TODO 예외

    public static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_ITERATION = "시도할 회수는 몇회인가요?";
    public static final String CAR_NAME_REGEX = ",";

    public List<String> readCarsNamesInput() {
        System.out.println(REQUEST_CAR_NAME);
        String input = readLine();
        List<String> carsNames = List.of(input.split(CAR_NAME_REGEX));

        return carsNames;
    }

    public Integer readNumberInput() {
        String input;
        int intValue;

        System.out.println(REQUEST_ITERATION);

        try {
            input = readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
        }

        // TODO: parseInt 대신 Number
        try {
            intValue = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
        }

        if (intValue <= 0){
            throw new IllegalArgumentException(NOT_LESS_THAN_ZERO.getMessage());
        }
        return intValue;
    }
}
