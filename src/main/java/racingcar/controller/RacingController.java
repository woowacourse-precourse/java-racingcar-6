package racingcar.controller;

import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputView.setInputNames();
        System.out.println("시도할 회수는 몇회인가요?");
        inputView.setNumberOfAttempts();

        int count = 0;
        while (count < inputView.getNumberOfAttempts()) {
            count++;
        }
    }
}
