package racingcar.view;

import java.util.List;
import racingcar.util.StringUtil;
import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static List<String> inputCarName() {
        String input = readLine();
        System.out.println(input);
        List<String> nameList = StringUtil.convertStringToList(input);
        Validator.validateCarName(nameList);
        return nameList;
    }

    public static int inputNumberOfExcution() {
        String input = readLine();
        System.out.println(input);
        Validator.validateNumber(input);
        return Integer.parseInt(input);
    }
}
