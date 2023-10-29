package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.List;
import java.util.stream.Collectors;

public class RacingView {

    public void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printReceiveNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExecutionResults() {
        System.out.println("\n실행 결과");
    }

    public void printExecutionResultsForEachOrder(CarList carList) {
        carList.getCarList().forEach(car ->
                System.out.printf("%s : %s%n", car.getCarName(), "-".repeat(car.getForwardCount()))
        );
        System.out.println();
    }

    public void printResult(CarList carList) {
        List<Car> greatestForwardCount = carList.findGreatestForwardCount();
        System.out.print("최종 우승자 : ");
        System.out.print(greatestForwardCount.stream().map(Car::getCarName).collect(Collectors.joining(", ")));
    }
}
