package racingcar;

import static racingcar.Constant.COLON;
import static racingcar.Constant.HYPHEN;

import java.util.List;

public class OutputView {
    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.toList()) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + COLON + HYPHEN.repeat(car.getPosition()));
    }

    public void printFinalResult(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.print("최종 우승자 : " + result);
    }
}
