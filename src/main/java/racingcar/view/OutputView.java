package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String WINNER_CARS = "최종 우승자 : ";
    private static final String JOIN_STANDARD = ", ";

    public void resultRace(List<RacingCar> winnerCarNames) {
        System.out.println(WINNER_CARS + winnerCarNames.stream().map(RacingCar::printCarName).collect(Collectors.joining(JOIN_STANDARD)));
    }

    public void viewCarMovement(List<RacingCar> racingCars) {
        racingCars.stream().map(RacingCar::carStatus).forEach(System.out::println);
        System.out.println();
    }
}
