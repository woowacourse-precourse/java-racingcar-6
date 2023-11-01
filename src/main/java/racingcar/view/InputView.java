package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Converter;

import java.util.List;

public class InputView {
    public List<String> readCars() {
        String input = Console.readLine();
        return Converter.toList(input);
    }
}
