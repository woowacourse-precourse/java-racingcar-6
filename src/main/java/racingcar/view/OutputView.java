package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public void printCarsProgress(List<Car> carList) {
        for (Car car : carList) {
            printCarName(car);
            System.out.print(" : ");
            printCarProgress(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarName(Car car) {
        System.out.print(car.getName());
    }

    private void printCarProgress(Car car) {
        for (int i = 0; i < car.getProgressCount(); i++) {
            System.out.print("-");
        }
    }

    public void printWinner(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winners);
    }
}
