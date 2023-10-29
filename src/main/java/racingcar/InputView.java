package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Console.readLine();
    }

    public void inputTryNum() {
        System.out.println("시도할 회수는 몇 회인가요?");
        Console.readLine();
    }
}
