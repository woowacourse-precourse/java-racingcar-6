package racingcar.application;

import racingcar.domain.Race;
import racingcar.domain.RacingCar;
import racingcar.util.channel.Printer;
import racingcar.util.constant.ConstVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final Race race;
    private final Long trial;

    public RacingGame(Long trial, List<String> carNames) {
        this.trial = trial;
        this.race = new Race(carNames);
    }

    public void start() {
        Printer.printLine(ConstVariable.RESULT_START_MESSAGE);

        for (int round = 1; round <= trial; round++) {
            race.runCircuit();
            viewCircuitResult(race);
            Printer.printBlankLine();
        }
        viewWinners(race);
    }

    private void viewCircuitResult(Race race) {
        for (RacingCar car : race.getRacingCars()) {
            String distanceStatus = ConstVariable.RESULT_MOVEMENT.repeat(car.getDistance().intValue());
            String circuitResult = String.join(ConstVariable.RESULT_SEPARATOR, car.getName(), distanceStatus);

            Printer.printLine(circuitResult);
        }
    }

    private void viewWinners(Race race) {
        Long farthestDistance = race.getFarthestDistance();
        List<String> winners = new ArrayList<>();
        for (RacingCar car : race.getRacingCars()) {
            if (Objects.equals(car.getDistance(), farthestDistance)) {
                winners.add(car.getName());
            }
        }
        String winnersResult = String.join(ConstVariable.RESULT_WINNER_SEPARATOR, winners);
        Printer.printLine(ConstVariable.RESULT_WINNER_MESSAGE + winnersResult);
    }

}
