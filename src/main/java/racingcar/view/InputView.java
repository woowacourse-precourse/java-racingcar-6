package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validation;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_RACES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_SEPARATOR = ",";

    public List<String> readNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        return Arrays.stream(readInput().split(CAR_NAME_SEPARATOR))
                .toList();
    }

    private String readInput() {
        return Console.readLine();
    }

    public int readNumberOfRaces() {
        System.out.println(INPUT_NUMBER_OF_RACES_MESSAGE);
        return readNumber();
    }

    private int readNumber() {
        String inputString = readInput();
        Validation.validateNumberOfRaces(inputString);
        return Integer.parseInt(inputString);
    }
}
