package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private static List<String> inputCarNames() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        List<String> carList = splitCarNames(userInput);

        return carList;
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }
}
