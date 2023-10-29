package racingcar.ui;

public class Ui {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void start() {
        System.out.println(START_MESSAGE);
    }

    public void askPlayCount() {
        System.out.println(ASK_PLAY_COUNT_MESSAGE);
    }
}
