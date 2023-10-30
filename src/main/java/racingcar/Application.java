package racingcar;

import camp.nextstep.edu.missionutils.Console;

import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {

    }

    private static String[] getCarNames(ConsoleView consoleView) {
        consoleView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }
}