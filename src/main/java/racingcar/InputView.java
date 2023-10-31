package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static final String DELIMITER_CAR_NAMES = ",";
    public static final int NAME_MAXIMUM_LENGTH = 5;

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        return toCarNames(input);
    }

    public static List<String> toCarNames(String input) {
        List<String> inputCarNames = new ArrayList<>();
        String[] names = input.split(DELIMITER_CAR_NAMES);
        for (String name : names) {
            if (name.length() > NAME_MAXIMUM_LENGTH) {
                throw new IllegalArgumentException(NAME_MAXIMUM_LENGTH + "글자 이하만 입력하시오");
            }
            inputCarNames.add(name);
        }
        return inputCarNames;
    }

    public static int inputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        return tryNumber(input);
    }

    public static int tryNumber(String input) {
        try {
            int tryNumberInt = Integer.parseInt(input);
            if (tryNumberInt <= 0) {
                throw new IllegalArgumentException("양수를 입력하시오");
            }
            return tryNumberInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하시오");
        }
    }
}
