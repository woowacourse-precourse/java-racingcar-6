package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Printer {
    public void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputNumberOfRoundsMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRoundStateMessage() {
        System.out.println("실행 결과");
    }

    public void printRoundState(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printMovedDistance(car.getLocation());
            System.out.println();
        }
        System.out.println();
    }

    private void printMovedDistance(Integer location) {
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
    }

    public void printResult(List<Car> winners) {
        Integer numberOfWinners = winners.size();
        System.out.print("최종 우승자 : ");
        if (numberOfWinners == 1) {
            printSoloWinner(winners.get(0));
        }
        if (numberOfWinners > 1) {
            printMultiWinner(winners);
        }
    }

    private void printSoloWinner(Car winner) {
        System.out.println(winner.getName());
    }

    private void printMultiWinner(List<Car> winners) {
        Car lastWinner = winners.get(winners.size() - 1);
        for (Car winner : winners) {
            System.out.print(winner.getName());
            if (!winner.equals(lastWinner)) {
                System.out.print(", ");
            }
        }
    }
}
