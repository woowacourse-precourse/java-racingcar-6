package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingCar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameMachine {
    private List<RacingCar> racingCars;

    public void gamePlay(final List<String> carNames, final int tryCount){
        readyToPlay(carNames);
        for (int i = 0; i < tryCount; i++) {
            race();
        }
        List<String> winners = winner();
        for (String winner : winners) {
            System.out.println(winner);
        }
    }

    public void readyToPlay(List<String> carNames) {
        this.racingCars = carNames.stream().map(RacingCar::new).collect(Collectors.toList());
    }

    public void race() {
        for (RacingCar car : this.racingCars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.isRacingCarMove(randomNumber);
            System.out.print(car);
        }
        System.out.print("\n");
    }

    public List<String> winner() {
        List<Integer> carsMoveCounts = this.racingCars.stream()
                .map(RacingCar::getMoveCount).collect(Collectors.toList());
        int maxMove = Collections.max(carsMoveCounts);
        List<String> winners = this.racingCars.stream().filter(car -> car.getMoveCount() == maxMove)
                .map(car -> car.getRacingCarName())
                .collect(Collectors.toList());
        return winners;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }
}
