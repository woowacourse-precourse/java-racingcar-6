package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_QUESTION_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final InputView INSTANCE = new InputView();
    InputViewValidator inputViewValidator = InputViewValidator.getInstance();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String InputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String carNames = Console.readLine();
        inputViewValidator.validateCarNames(carNames);
        return carNames;
    }

    public int InputTryNumber() {
        System.out.println(TRY_COUNT_QUESTION_MESSAGE);
        String tryNumber = Console.readLine();
        inputViewValidator.validateTryNumber(tryNumber);
        return Integer.parseInt(tryNumber);
    }

}
