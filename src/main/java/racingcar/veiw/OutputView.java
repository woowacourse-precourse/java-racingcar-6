package racingcar.veiw;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void startRepeat() {
        System.out.println("실행 결과");
    }
    public static void positionResult(Car car) {
        System.out.printf("%s : %s%n", car.name, printPosition(car.position));
    }
    public static void gameResult(List<String> winnerList) {
        System.out.print("최종 우승자 : ");
        StringJoiner winnerPrint = new StringJoiner(", ");
        for (String winner : winnerList) {
            winnerPrint.add(winner);
        }
        System.out.print(winnerPrint);
    }
    private static String printPosition(int position) {
        return "-".repeat(position);
    }
}
