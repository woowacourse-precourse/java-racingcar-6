package racingcar.view;

import racingcar.handler.OutputHandler;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printInputTryCountMessage() {

    }

    @Override
    public void printGameResultMessage() {

    }

    @Override
    public void printGameProgress() {

    }

    @Override
    public void printFinalWinners() {

    }
}
