package racingcar;

import java.util.List;

public class OutputView {

    private void printCar(Car car) {
        System.out.println(car.getName() + Constant.COLON + Constant.HYPHEN.repeat(car.getPosition()));
    }

    public void printResult(Cars cars) {
        for (Car car : cars.toList()) {
            printCar(car);
        }
    }

    public void printFinalResult(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
