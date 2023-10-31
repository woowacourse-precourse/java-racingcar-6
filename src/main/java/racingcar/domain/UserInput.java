package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.CountException;
import racingcar.exception.NameException;

public class UserInput {

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStr = Console.readLine();

        List<String> carNamesList = Arrays.asList(inputStr.split(","));

        NameException.validateInput(carNamesList);

        return carNamesList;
    }


    // 자동차 경주 게임 플레이 횟수
    public static int inputGameCount() {

        System.out.println("시도할 횟수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        CountException.isNotNumber(count);
        CountException.isNotPositiveNumber(count);

        return count;
    }

}
