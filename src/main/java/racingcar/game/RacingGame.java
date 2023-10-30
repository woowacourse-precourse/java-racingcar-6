package racingcar.game;

import java.util.stream.Collectors;
import racingcar.collaborator.race.Race;
import racingcar.collaborator.race.generic.RaceTotalProgress;
import racingcar.collaborator.race.generic.Winners;
import racingcar.io.Output;
import racingcar.io.views.RaceView;

public class RacingGame {

    private final RaceView raceView;
    private final Race race;

    public RacingGame(RaceView raceView, Race race) {
        this.raceView = raceView;
        this.race = race;
    }

    public void play() {
        prepareRace();

        race.run();

        Output.consoleLine("실행 결과");
        RaceTotalProgress totalProgress = race.getTotalProgress();

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
        race.registerRacer(raceView.askRacersNames());
        race.decideRoundNumber();
    }

}
