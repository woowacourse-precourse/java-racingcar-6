package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void start() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printResult(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerList));
    }

    public void printStanding(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }
}
