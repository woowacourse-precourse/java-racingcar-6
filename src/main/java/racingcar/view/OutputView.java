package racingcar.view;

public class OutputView {
    public static final String INPUT_RACINGCAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static final String INPUT_NUMBER_OF_ROUND_MESSAGE = "시도할 횟수는 몇회인가요?";

    public void printInputRacingCarNameMessage() {
        System.out.println(INPUT_RACINGCAR_NAME_MESSAGE);
    }

    public void printInputNumberOfRoundMessage() {
        System.out.println(INPUT_NUMBER_OF_ROUND_MESSAGE);
    }
}
