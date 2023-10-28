package racingcar.view;

import racingcar.handler.OutputHandler;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printInputTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void printGameResultMessage() {
        System.out.println("실행 결과");
    }

    @Override
    public void printGameProgress() {

    }

    @Override
    public void printFinalWinners() {

    }
}
