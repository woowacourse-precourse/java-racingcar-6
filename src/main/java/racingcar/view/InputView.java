package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarNameValidator;
import racingcar.domain.RoundNumberValidator;

public class InputView {

    public List<String> insertCarName() {
        String input = Console.readLine();
        List<String> names = toStringList(input);
        return names;
    }

    public List<String> toStringList(String name) {
        new CarNameValidator(name);
        List<String> names = Arrays.asList(name.split(","));
        return names;
    }

    public int insertRoundNumber() {
        String input = Console.readLine();
        new RoundNumberValidator(input);
        return convertToNumber(input);
    }

    public int convertToNumber(String input) {
        return Integer.parseInt(input);
    }
}
