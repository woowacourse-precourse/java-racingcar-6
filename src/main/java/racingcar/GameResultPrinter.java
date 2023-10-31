package racingcar;

import java.util.List;

public class GameResultPrinter {
    public static void printRoundResult(List<CarStatusDto> carListStatus) {
        StringBuilder status = new StringBuilder();
        for (CarStatusDto carStatus : carListStatus) {
            status.append(carStatus.getCarName())
                    .append(" : ")
                    .append("-".repeat(carStatus.getPosition()))
                    .append("\n");
        }

        System.out.println(status);
    }

    public static void printWinners(Cars cars) {
        List<String> winners = cars.getWinners();
        String winnerNames = String.join(", ", winners);

        System.out.println("최종 우승자 : " + winnerNames);
    }

}
