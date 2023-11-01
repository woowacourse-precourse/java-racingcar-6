package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String carNameInputString = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCountInputString = "시도할 회수는 몇회인가요?";

    public static String generateCarNameInput() {
        System.out.println(carNameInputString);
        return Console.readLine();
    }

    public static int generateTryCountInput() {
        System.out.println(tryCountInputString);
        int tryNumber = Integer.parseInt(Console.readLine());
        return tryNumber;
    }
}
