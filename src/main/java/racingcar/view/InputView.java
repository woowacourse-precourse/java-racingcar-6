package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SPLITTER = ",";

    public List<String> readNamesOfCars() {
        String inputValue = Console.readLine();
        return Arrays.stream(inputValue.split(SPLITTER))
                .map(String::trim)
                .toList();
    }

    public int readTrialNumber() {
        String inputValue = Console.readLine();

        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
