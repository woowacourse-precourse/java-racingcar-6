package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class User {

    public User() {

    }

    public static List<String> inputCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        List<String> carList = splitCarNames(userInput);
        Checker.checkNameLength(carList);
        Checker.checkNameDuplication(carList);

        return carList;
    }

    public static Integer inputNumberOfTurns() {
        System.out.print("시도할 회수는 몇회인가요?");
        String userInputTurn = Console.readLine();

        int turns = Checker.checkValidTurn(userInputTurn);

        return turns;
    }

    private static List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }
}
