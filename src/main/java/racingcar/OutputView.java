package racingcar;

import java.util.List;

public class OutputView {
    public static void showResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void showResult(List<Car> raceCarList) {
        for (Car car : raceCarList) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }

    public static void showWinner(List<String> winners) {
        String joinedWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + joinedWinners);
    }
}
