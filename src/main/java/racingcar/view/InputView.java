package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_NUMBER = "시도할 회수는 몇회인가요?";

    InputValidation inputValidation = new InputValidation();

    public String[] carName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String questionAnswer = Console.readLine();
        return inputValidation.checkedInputValidation(questionAnswer);
    }

    public int playNumber() {
        System.out.println(INPUT_PLAY_NUMBER);
        String questionAnswer = Console.readLine();
        System.out.println();
        return inputValidation.checkedInputNumberValidation(questionAnswer);
    }
}
