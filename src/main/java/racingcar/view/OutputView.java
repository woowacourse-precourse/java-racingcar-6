package racingcar.view;

import static racingcar.view.InputView.inputCarName;

public class OutputView {
    public static void startInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askForAttemptsCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
