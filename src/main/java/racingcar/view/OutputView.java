package racingcar.view;

import org.mockito.internal.verification.InOrderWrapper;

import java.util.ArrayList;

public class OutputView {

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRoundNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printWinnerMessage() {
        System.out.print("최종 우승자 : ");
    }

    public void printWinnerResult(String carName) {
        System.out.print(carName+", ");
    }

    public void printLastWinnerResult(String carName) {
        System.out.print(carName);
    }
}
