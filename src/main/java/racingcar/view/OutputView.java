package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void outputAllRoundResult(List<List<RacingCar>> allRoundResult) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n실행 결과\n");

        for(List<RacingCar> round : allRoundResult) {
            builder.append(outputRoundResult(round) + "\n");
        }

        System.out.println(builder.toString());
    }

    private static String outputRoundResult(List<RacingCar> cars) {
        StringBuilder builder = new StringBuilder();
        for(RacingCar car : cars) {
            builder.append(car.toString() + "\n");
        }
        return builder.toString();
    }

    public static void outputWinners(List<RacingCar> winners) {
        StringBuilder builder = new StringBuilder();
        builder.append("최종 우승자 : ");
        List<String> winnersName = winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
        builder.append(String.join(", ", winnersName));
        System.out.println(builder.toString());
    }

}
