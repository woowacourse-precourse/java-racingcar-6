package racingcar.application;

import racingcar.domain.Race;
import racingcar.domain.RacingCar;
import racingcar.util.channel.Printer;
import racingcar.util.constant.ConstVariable;

import java.util.List;
import java.util.ArrayList;
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
            race.circuit();

            viewCircuitResult(race);
            Printer.printBlankLine();
        }
        viewWinners(race);
    }

    /** 각 서킷의 결과를 출력합니다. */
    private void viewCircuitResult(Race race) {
        for (RacingCar car : race.getRacingCars()) {
            // 거리만큼 "-"로 변환
            String distanceStatus = ConstVariable.RESULT_MOVEMENT.repeat(car.getDistance().intValue());
            String circuitResult = String.join(ConstVariable.RESULT_SEPARATOR, car.getName(), distanceStatus);

            Printer.printLine(circuitResult);
        }
    }

    /** 최종 레이스의 결과를 출력합니다. */
    private void viewWinners(Race race) {
        Long farthestDistance = race.getMostFarthestDistance();
        List<String> winners = new ArrayList<>();

        for (RacingCar car : race.getRacingCars()) {
            // 본 레이스의 가장 긴 거리 기록과 동일한 차량의 이름을 구합니다.
            if (Objects.equals(car.getDistance(), farthestDistance)) {
                winners.add(car.getName());
            }
        }

        String winnersResult = String.join(ConstVariable.RESULT_WINNER_SEPARATOR, winners);
        Printer.printLine(ConstVariable.RESULT_WINNER_MESSAGE + winnersResult);
    }

}
