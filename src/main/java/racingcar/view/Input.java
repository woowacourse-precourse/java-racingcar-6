package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CustomInputValidation;

public class Input {

    public static String[] inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        CustomInputValidation.numOfCars(carNames.length);
        CustomInputValidation.carNameLength(carNames);
        return carNames;
    }

    public static String inputTryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int retryNumber = CustomInputValidation.parseAndValidateInteger(input);
        return input;
    }
}
