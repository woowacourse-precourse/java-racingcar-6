package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validation;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final Validation validation = new Validation();

    public Integer playCount() {
        String input = Console.readLine();
        validation.isNumeric(input);
        int count = Integer.parseInt(input);
        validation.checkPlayCount(count);
        return count;
    }

    public List<String> carNameList() {
        String name = Console.readLine();
        List<String> carList = Arrays.asList(name.split(","));
        validation.checkNameListSize(carList);
        validation.hasDuplication(carList);
        return carList;
    }
}
