package racingcar.printer;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.VisibleForTesting;
import racingcar.service.RacingCar;

public class RacingCarPrinter {
    public static void askRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askHowManyNumberToPlay() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printMessageBeforePlay() {
        System.out.println("실행 결과");
    }

    public static void printCurrentDistanceStatus(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar ->
                System.out.println(getCurrentStatusWithBar(racingCar)));
        System.out.println();
    }

    @VisibleForTesting
    protected static String getCurrentStatusWithBar(RacingCar racingCar) {
        return racingCar.getName() + " : " + convertDistanceToBar(racingCar.getAdvanceDistance());
    }

    @VisibleForTesting
    protected static String convertDistanceToBar(int advanceDistance) {
        return "-".repeat(Math.max(0, advanceDistance));
    }

    public static void printWinnerOfPlay(List<RacingCar> calculateWinner) {
        String message = "최종 우승자 : ";
        message += convertListToNamesOfOneLine(calculateWinner);
        System.out.println(message);
    }

    @VisibleForTesting
    protected static String convertListToNamesOfOneLine(List<RacingCar> calculateWinner) {
        return calculateWinner.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }
}
