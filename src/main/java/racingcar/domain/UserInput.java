package racingcar.domain;

import static racingcar.exception.InputException.checkCarCount;
import static racingcar.exception.InputException.checkEmpty;
import static racingcar.exception.InputException.checkFormat;
import static racingcar.exception.InputException.checkLimit;
import static racingcar.exception.InputException.checkSameName;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.InputException;

public class UserInput {

    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStr = Console.readLine();

        List<String> carNamesList = Arrays.asList(inputStr.split(","));

        InputException.validateInput(carNamesList);

        return carNamesList;
    }



    // 자동차 경주 게임 플레이 횟수
    public static int inputGameCount(){

        System.out.println("시도할 횟수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        InputException.isNotNumber(count);
        InputException.isNotPositiveNumber(count);

        return count ;
    }

}
