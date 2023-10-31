package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void processResult(List<Car> cars, int trials) {
        System.out.println("실행 결과");

        for (int i = 0; i < trials; i++) {
            cars.forEach(Car::next);
            cars.forEach(Car::printResult);
            System.out.println();
        }
    }

    public void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        StringJoiner joiner = new StringJoiner(", ");
        for (String s : winner) {
            joiner.add(s);
        }

        System.out.println(joiner.toString());
    }

    public void newLine() {
        System.out.println();
    }
}
