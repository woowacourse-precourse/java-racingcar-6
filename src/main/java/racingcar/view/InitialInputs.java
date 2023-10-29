package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.validation.CarNames;

public class InitialInputs {
    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        CarNames checkCarNames = new CarNames();
        checkCarNames.validateCarNames(input);
        return input;
    }
}
