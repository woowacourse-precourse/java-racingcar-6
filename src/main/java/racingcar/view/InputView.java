package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class InputView {
    public static Cars getCarsInput() {
        String cars = Console.readLine();
        List<String> list = convertToList(cars);
        return new Cars(list);
    }

    public static List<String> convertToList(String input) {
        String[] array = input.split(",");
        return Arrays.asList(array);
    }
}
