package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {
    public void resultRace(List<RacingCar> winnerCarNames) {
        System.out.println("최종 우승자 : " + winnerCarNames);
    }

    public void viewCarMovement(List<RacingCar> racingCars) {
        racingCars.stream()
                .map(RacingCar::carStatus)
                .forEach(System.out::println);
        System.out.println();
    }
}
