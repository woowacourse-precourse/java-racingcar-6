package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SPLITTER = ",";
    private static final String TRIAL_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> readNamesOfCars() {
        String inputValue = Console.readLine();
        return Arrays.stream(inputValue.split(SPLITTER))
                .map(String::trim)
                .toList();
    }

    public int readTrialNumber() {
        System.out.println(TRIAL_NUMBER_INPUT_MESSAGE);
        String inputValue = Console.readLine();

        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
