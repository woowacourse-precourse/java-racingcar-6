package racingcar.application;

import racingcar.domain.Race;
import racingcar.domain.RacingCar;
import racingcar.util.channel.Printer;
import racingcar.util.constant.ConstVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

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
            StringJoiner carResult = new StringJoiner(ConstVariable.RESULT_SEPARATOR);
            carResult.add(car.getName());
            carResult.add(ConstVariable.RESULT_MOVEMENT.repeat(car.getDistance().intValue()));

            Printer.printLine(carResult.toString());
        }
    }

    private void viewWinners(Race race) {
        StringJoiner winnerResult = new StringJoiner(ConstVariable.RESULT_WINNER_SEPARATOR);
        Long farthestDistance = race.getFarthestDistance();

        List<String> winners = new ArrayList<>();
        for (RacingCar car : race.getRacingCars()) {
            if (Objects.equals(car.getDistance(), farthestDistance)) {
                winners.add(car.getName());
            }
        }
        winners.forEach(winnerResult::add);
        Printer.printLine(ConstVariable.RESULT_WINNER_MESSAGE + winnerResult);
    }

}
