package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validation;
import racingcar.utils.constant.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private final Validation validation = new Validation();

    public Integer playCount() {
        String input = Console.readLine();
        validation.isNumeric(input);
        return Integer.parseInt(input);
    }


    public List<String> carNameList() {
        String name = Console.readLine();
        List<String> carList = Arrays.asList(name.split(","));
        validation.checkNameListSize(carList);
        return carList;
    }
}
