package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printGameResult(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int i = 0; i < car.getForwardCount(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinner(List<String> winnerList) {
        String winner = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winner);
    }

    public static void printBeforeResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printLine() {
        System.out.println();
    }
}
