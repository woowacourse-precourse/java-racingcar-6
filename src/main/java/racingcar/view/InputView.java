package racingcar.view;

import static racingcar.view.Constants.INPUT_CARS_NAME;
import static racingcar.view.Constants.TRY_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<String> getUserInputName() {
        System.out.println(INPUT_CARS_NAME);
        String input = Console.readLine();

        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public Integer getUserInputCount() {
        System.out.println(TRY_COUNT);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
