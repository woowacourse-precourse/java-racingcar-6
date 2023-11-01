package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Output {
    public static void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputRandomNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            printScoreOfCars(car);
        }
        System.out.println();
    }

    private static void printScoreOfCars(Car car) {
        System.out.print(car.getName() + " : ");
        printPosition(car);
        System.out.println();
    }

    private static void printPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printWinner(List<String> carNames) {
        StringBuilder winnerStringBuilder = new StringBuilder();
        winnerStringBuilder.append("최종 우승자 :");

        for (String winner : carNames) {
            winnerStringBuilder.append(" ").append(winner).append(",");
        }

        winnerStringBuilder.setLength(winnerStringBuilder.length() - 1);
        System.out.println(winnerStringBuilder);
    }

}
