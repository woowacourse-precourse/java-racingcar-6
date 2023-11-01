package racingcar.domain.view;

import racingcar.domain.model.Car;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExecutionResult() {
        System.out.println("\n실행 결과");
    }

    public void printExecutionResults(Car car) {
        List<String> names = car.getNames();
        Map<String, Integer> distance = car.getDistance();
        names.forEach(name -> System.out.println(name + " : " + "-".repeat(distance.get(name))));
        System.out.println();
    }

    public void printResults(Car car) {
        List<String> winners = car.getWinners();
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
