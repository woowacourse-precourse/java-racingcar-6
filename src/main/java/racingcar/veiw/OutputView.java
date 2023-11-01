package racingcar.veiw;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void printExecutionMessage() {
        System.out.println("실행 결과");
    }
    public static void printPosition(Car car) {
        System.out.printf("%s : %s%n", car.name, createPositionString(car.position));
    }
    public static void printWinners(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        StringJoiner winnerPrint = new StringJoiner(", ");
        for (String winner : winnerList) {
            winnerPrint.add(winner);
        }
        System.out.print(winnerPrint);
    }
    private static String createPositionString(int position) {
        return "-".repeat(position);
    }
}
