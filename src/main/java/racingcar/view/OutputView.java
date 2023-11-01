package racingcar.view;

import static racingcar.model.CarForward.forwardCount;
import static racingcar.model.Winner.maxCountCars;
import static racingcar.view.InputView.cars;
import static racingcar.view.InputView.carsNum;

import java.util.List;

public class OutputView {
    public static void printCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public static void printGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printForwardResult() {
        for (int i = 0; i < carsNum; i++) {
            System.out.print(cars[i] + " : ");
            System.out.println(forwardCount[i]);
        }
        System.out.println();
    }

    public static void printFinal() {
        System.out.print("최종 우승자 : ");
    }

    public static void printWinners() {
        if (!maxCountCars.isEmpty()) {
            for (int i = 0; i < maxCountCars.size(); i++) {
                System.out.print(maxCountCars.get(i));
                if (i < maxCountCars.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
