package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.RacingGameMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private ValidatePlayerInput validatePlayerInput = new ValidatePlayerInput();
    private List<RacingCar> racingCars;
    private int raceCount;

    public void readyToCars(final String carNamesInputLine) {
        List<String> carNames = validatePlayerInput.validateCarNames(carNamesInputLine);
        this.racingCars = carNames.stream().map(RacingCar::new).toList();
    }

    public void readyToRace(final String raceCountInputLine) {
        int raceCount = validatePlayerInput.validateRaceCount(raceCountInputLine);
        this.raceCount = raceCount;
    }

    public void race() {
        for (RacingCar car : this.racingCars) {
            final int movableNumber = this.generateMovableNumber();
            car.move(movableNumber);
        }
    }

    public List<String> findWinners() {
        final List<Integer> carsMoveCounts = this.racingCars.stream()
                .map(RacingCar::getMoveCount).toList();

        final int maxMove = Collections.max(carsMoveCounts);

        final List<String> winners = this.racingCars.stream().filter(car -> car.getMoveCount() == maxMove)
                .map(RacingCar::getRacingCarName).toList();

        return winners;
    }

    public String allRacePlay() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.raceCount; i++) {
            this.race();
            result.append(this.racingCars.stream().map(RacingCar::toString).collect(Collectors.joining()))
                    .append(RacingGameMessage.NEWLINE.getNewLine());
        }

        result.setLength(result.length() - 1);

        return result.toString();
    }

    public int generateMovableNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public String getWinners() {
        final List<String> winners = this.findWinners();
        final String result = String.join(", ", winners);

        return result;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }
}
