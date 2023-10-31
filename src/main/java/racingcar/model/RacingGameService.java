package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private List<RacingCar> racingCars;

    public void readyToPlay(List<String> carNames) {
        this.racingCars = carNames.stream().map(RacingCar::new).toList();
    }

    public void race() {
        for (RacingCar car : this.racingCars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.isRacingCarMove(randomNumber);
        }
    }

    public List<String> getWinner() {
        List<Integer> carsMoveCounts = this.racingCars.stream()
                .map(RacingCar::getMoveCount).toList();
        int maxMove = Collections.max(carsMoveCounts);
        List<String> winners = this.racingCars.stream().filter(car -> car.getMoveCount() == maxMove)
                .map(RacingCar::getRacingCarName)
                .toList();

        return winners;
    }

    public String getAllRaceResult(final int raceCount) {
        StringBuilder result = new StringBuilder("\n");

        for (int i = 0; i < raceCount; i++) {
            this.race();
            result.append(this.racingCars.stream().map(RacingCar::toString).collect(Collectors.joining())).append("\n");
        }

        result.setLength(result.length() - 1);

        return result.toString();
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }
}
