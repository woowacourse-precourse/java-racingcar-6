package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import racingcar.enums.Message;
import racingcar.enums.Symbol;

public class RacingGame {
    private final RacingCars racingCars;
    private final int totalRound;
    private int currentRound;
    private RacingCars winners;

    private RacingGame(RacingCars racingCars, int totalRound) {
        Objects.requireNonNull(racingCars);
        this.racingCars = racingCars;
        this.totalRound = totalRound;
    }

    public static RacingGame of(String inputCarNames, String inputTotalRound) {
        Objects.requireNonNull(inputCarNames);
        Objects.requireNonNull(inputTotalRound);
        return new RacingGame(
                RacingCars.from(inputCarNames),
                Integer.parseInt(inputTotalRound)
        );
    }

    public boolean isNotFinished() {
        return currentRound < totalRound;
    }

    public void increaseCurrentRound() {
        currentRound++;
    }

    public void runRound() {
        racingCars.getRacingCars()
                .forEach(this::decideWhetherToMoveForward);
    }

    private void decideWhetherToMoveForward(RacingCar racingCar) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            racingCar.moveForward();
        }
    }

    public String getRunResultMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        this.racingCars
                .getRacingCars()
                .forEach(racingCar -> {
                    stringBuilder.append(racingCar.getName());
                    stringBuilder.append(Symbol.KEY_VALUE_SEPARATOR.getValue());
                    stringBuilder.append(racingCar.getPositionMarkers());
                    stringBuilder.append("\n");
                });
        return stringBuilder.toString();
    }

    public void decideWinners() {
        this.winners = getRacingCarsWithMaximumPosition();
    }

    private RacingCars getRacingCarsWithMaximumPosition() {
        List<RacingCar> racingCarsWithMaximumPosition = racingCars.getRacingCars()
                .stream()
                .filter(racingCar -> racingCar.getPosition() == getMaximumPosition())
                .toList();
        return RacingCars.from(racingCarsWithMaximumPosition);
    }

    private int getMaximumPosition() {
        return racingCars.getRacingCars()
                .stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public String getFinalWinnerMessage() {
        return Message.FINAL_WINNER.getMessage()
                + Symbol.KEY_VALUE_SEPARATOR.getValue()
                + winners.toNameString();
    }
}
