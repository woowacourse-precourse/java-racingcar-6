package racingcar;

import java.util.List;

public class OutputView {
    private void printCarStatus(Car car) {
        System.out.println(car.getName() + Constant.COLON + Constant.HYPHEN.repeat(car.getPosition()));
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars.toList()) {
            printCarStatus(car);
        }
        System.out.println();
    }

    public void printFinalResult(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
