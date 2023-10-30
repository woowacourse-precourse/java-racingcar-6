package racingcar.view;

import java.util.List;
import racingcar.constant.Message;
import racingcar.util.StringUtil;
import racingcar.util.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static List<String> inputCarName() {
        System.out.println(Message.INPUT_CAR_NAME);
        String input = readLine();
        System.out.println(input);
        List<String> nameList = StringUtil.convertStringToList(input);
        Validator.validateCarName(nameList);
        return nameList;
    }

    public static int inputNumberOfExcution() {
        System.out.println(Message.INPUT_NUMBER_EXECUTION);
        String input = readLine();
        System.out.println(input + "\n");
        Validator.validateNumber(input);
        return StringUtil.convertStringToInt(input);
    }
}
