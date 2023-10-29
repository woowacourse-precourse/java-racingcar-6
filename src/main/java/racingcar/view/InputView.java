package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    private InputView() {}

    public static InputView getInstance(){
        return INSTANCE;
    }

    private String InputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return carNames;
    }

}
