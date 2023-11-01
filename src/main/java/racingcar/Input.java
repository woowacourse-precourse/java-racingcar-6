package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public String carsName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carsName = Console.readLine();
        InputValidator.blank(carsName);

        return carsName;
    }

    public String tryNum() {
        System.out.println(TRY_NUMBER_INPUT_MESSAGE);
        String tryNumString = Console.readLine();
        InputValidator.blank(tryNumString);

        return tryNumString;
    }
}
