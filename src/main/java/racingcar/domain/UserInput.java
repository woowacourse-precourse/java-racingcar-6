package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.InputException;

public class UserInput {

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStr = Console.readLine();

        validateInput(inputStr);

        return Arrays.asList(inputStr.split(","));
    }

    private static void validateInput(String inputStr) {
        InputException.isValidInputFormat(inputStr);
        String[] carNamesArray = inputStr.split(",");

        InputException.limit(carNamesArray);

        InputException.sameName(carNamesArray);
    }

    public static int inputGameCount(){

        System.out.println("시도할 횟수는 몇회인가요?");

        int count = Integer.parseInt(Console.readLine());

        InputException.isNumber(count);

        return count ;
    }

}
