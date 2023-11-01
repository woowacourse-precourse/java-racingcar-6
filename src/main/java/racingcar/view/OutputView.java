package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public void printStartResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printEachRaceResult(List<Car> cars) {
        IntStream.range(0, cars.size())
                .forEach(i -> printEachCarResult(cars.get(i)));
        System.out.println();
    }

    private void printEachCarResult(Car car) {
        String name = car.getName();
        String distance = createDistanceResult(car.getDistance());
        System.out.println(name + " : " + distance);
    }

    private String createDistanceResult(int distance) {
        return IntStream.range(0, distance)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public void printWinnerOrWinners(String result) {
        System.out.println("최종 우승자 : " + result);
    }
}
