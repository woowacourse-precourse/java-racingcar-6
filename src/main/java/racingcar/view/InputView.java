package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_NUM_MESSAGE = "시도할 회수는 몇회인가요?";
    private static InputView instance;

    private InputView() {

    }

    public static InputView getInstance() {
        if(instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readCarNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        // 입력 요구사항에 대해선 이쪽에서 유효성 검사를 해야할듯함.
        return Console.readLine();
    }

    public Integer readTryNum() {
        System.out.println(INPUT_MOVE_NUM_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }
}
