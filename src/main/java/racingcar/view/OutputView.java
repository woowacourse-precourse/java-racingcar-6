package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void resultRace(List<RacingCar> winnerCarNames) {
        System.out.println("최종 우승자 : " + winnerCarNames.stream()
                .map(RacingCar::printCarName)
                .collect(Collectors.joining(", ")));
    }

    public void viewCarMovement(List<RacingCar> racingCars) {
        racingCars.stream()
                .map(RacingCar::carStatus)
                .forEach(System.out::println);
        System.out.println();
    }
}
