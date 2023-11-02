package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printConsole() {
        System.out.println("실행 결과");
    }

    public static void printGameResult(List<Car> carNames) {
        for (Car car : carNames) {
            String movingDistance = "-".repeat(car.getMovingCount());
            System.out.println(car.getName() + " : " + movingDistance);
        }
        System.out.println();
    }

    public static void printGameWinner(List<String> gameWinner) {
        String winnerNames = String.join(", ", gameWinner);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
