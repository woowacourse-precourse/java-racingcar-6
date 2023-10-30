package racingcar.views;

import java.util.List;

import racingcar.models.RacingCar;

public class OutputView {
    public void printRoundResult(List<RacingCar> racingCars) {
        racingCars.forEach((RacingCar racingCar) -> {
            System.out.printf("%s : %s\n", racingCar.getName(), "-".repeat(racingCar.getDistance()));
        });
        System.out.println();
    }

    public void printRaceResult(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        for (RacingCar winner : winners) {
            sb.append(winner.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.printf("최종 우승자 : %s\n", sb.toString());
    }
}
