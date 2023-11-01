package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public String getCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getNumberOfRound() {
        System.out.println(NUMBER_OF_ROUND_INPUT_MESSAGE);
        String numberOfRound = Console.readLine();
        Console.close();
        return numberOfRound;
    }
}
