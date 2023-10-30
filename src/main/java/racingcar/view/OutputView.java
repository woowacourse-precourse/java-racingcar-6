package racingcar.view;

import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import racingcar.car.Car;

public final class OutputView {

    private static final String DIVIDER = " : ";
    private static final String BAR = "-";


    public void askGameRuntime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void askCarName(final String delimiter) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + delimiter +") 기준으로 구분)");
    }

    public void showStart() {
        System.out.println("실행 결과");
    }

    public void showCarStatus(final Collection<Car> cars) {
        cars.forEach(this::showCarStatus);
        System.out.println();
    }

    private void showCarStatus(final Car car) {
        System.out.print(car.getName() + DIVIDER);
        printBar(car.getPosition());
    }

    public void showWinners(final List<Car> winners) {
        if (winners.isEmpty()) {
            System.out.println("우승자가 없습니다");
            return;
        }
        System.out.print("최종 우승자" + DIVIDER);

        showCarNames(winners);
    }

    private void showCarNames(final List<Car> cars) {
        final String delimiter = ", ";
        final StringJoiner joiner = new StringJoiner(delimiter);
        for (Car car : cars) {
            joiner.add(car.getName());
        }

        System.out.println(joiner);
    }

    private void printBar(final int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(BAR);
        }
        System.out.println();
    }


}
