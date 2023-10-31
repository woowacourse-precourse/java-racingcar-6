package racingcar;

public class InputView {

    private final String INPUT_CAR_NAME_Msg = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MSG = "시도할 회수는 몇회인가요?";

    public void printCarNameInputMsg() {
        System.out.println(INPUT_CAR_NAME_Msg);
    }

    public void printTryCountInputMsg() {
        System.out.println(INPUT_TRY_COUNT_MSG);
    }
}
