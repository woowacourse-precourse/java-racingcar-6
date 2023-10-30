package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.collaborator.Race;
import racingcar.collaborator.Racer;
import racingcar.collaborator.generic.RaceTotalProgress;
import racingcar.collaborator.generic.Winners;
import racingcar.io.Input;
import racingcar.io.Output;

public class RacingGame {

    private final Race race;

    public RacingGame(Race race) {
        this.race = race;
    }

    public void play() {
        prepareRace();

        race.run();

        RaceTotalProgress totalProgress = race.getTotalProgress();
        Output.consoleLine("실행 결과");

        String totalProgressRecord = totalProgress.stream()
                .map(lap ->
                        lap.stream()
                                .map(racer -> racer.name() + " : " + "-".repeat(racer.mileage()))
                                .collect(Collectors.joining(System.lineSeparator())))
                .collect(Collectors.joining(System.lineSeparator().repeat(2)));
        System.out.println(totalProgressRecord);

        Winners winners = totalProgress.decideWinner();
        String totalWinners = winners.stream()
                .collect(Collectors.joining(", "));
        System.out.println(System.lineSeparator() + "최종 우승자 : " + totalWinners);
    }

    private void prepareRace() {
        Output.consoleLine("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Racer> racers = Input.consoleStrings(",").stream()
                .map(Racer::new)
                .toList();
        race.registerRacer(racers);
        race.decideRoundNumber();
    }

}
