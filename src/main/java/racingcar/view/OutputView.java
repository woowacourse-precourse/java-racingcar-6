package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public void askForAllCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askForNumberOfRuns() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(CarList cars) {
        for (Car car : cars.getCars()) {
            printCarNameAndPosition(car);
        }
        System.out.println();
    }

    private void printCarNameAndPosition(Car car) {
        System.out.println(car.getName()+" : "+ showPositionWithDashes("-", car.getPosition()));
    }

    private String showPositionWithDashes(String str, int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

}
