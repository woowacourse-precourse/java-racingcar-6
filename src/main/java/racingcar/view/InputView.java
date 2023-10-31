package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Util;

public class InputView {
    public String inputToNameCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int inputTryToMoveCar() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = Util.convertStringToInt(Console.readLine());
        return input;
    }
}
