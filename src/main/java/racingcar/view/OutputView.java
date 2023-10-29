package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    public static void outputRaceRoundResult(List<RacingCar> cars) {
        StringBuilder builder = new StringBuilder();
        for(RacingCar car : cars) {
            builder.append(car.toString() + "\n");
        }
        System.out.println(builder.toString());
    }

    public static void outputWinners(List<String> winners) {
        StringBuilder builder = new StringBuilder();
        builder.append("최종 우승자 : ");
        builder.append(String.join(", ", winners));
        System.out.println(builder.toString());
    }

}
