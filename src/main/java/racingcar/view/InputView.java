package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final static String commaString = ",";
    private final static String inputRacingCarsNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String inputCountMessage = "시도할 회수는 몇회인가요?";

    public static List<String> inputCarNames() {
        System.out.println(inputRacingCarsNameMessage);
        return convertStringToList(Console.readLine());
    }

    public static int inputTryCount() {
        System.out.println(inputCountMessage);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            ExceptionMessage.INPUT_NO_COUNT_MESSAGE.throwException();
        }
        return 0;
    }

    private static List<String> convertStringToList(String carNames) {
        return Arrays.stream(carNames.split(commaString))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
