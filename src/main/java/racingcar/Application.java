package racingcar;

import racingcar.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // 자동차 입력 안내 메세지 출력
        outputView.carNameInputMessage();
    }
}
