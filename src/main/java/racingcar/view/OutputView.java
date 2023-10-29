package racingcar.view;

import static racingcar.model.Car.moveCount;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void startInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askForAttemptsCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void resultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void displayResult() {
        List<String> carNameList = Car.getCarName();
        for (String s : carNameList) {
            System.out.println(s + " : " + moveCount());
        }
    }

}
