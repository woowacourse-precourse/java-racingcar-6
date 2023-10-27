package racingcar.game;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import racingcar.collaborator.Race;
import racingcar.collaborator.generic.RaceProgress;
import racingcar.collaborator.generic.RacerProgress;
import racingcar.io.Output;

public class RacingGame {

    public void play() {
        Race race = new Race();
        race.registerRacer();
        race.decideRound();

        race.run();
        List<RaceProgress> result = race.result();
        Output.consoleLine("실행 결과");
        Output.consoleLine(result);

        RaceProgress raceProgress = result.get(result.size() - 1);
        Integer biggestMileage = raceProgress.racerProgress().stream()
                .sorted(Comparator.comparingInt(RacerProgress::mileage).reversed())
                .map(RacerProgress::mileage)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("무조건 나오게 되어있는데 말이에요."));
        List<String> winners = raceProgress.racerProgress().stream()
                .filter(racerProgress -> Objects.equals(racerProgress.mileage(), biggestMileage))
                .map(RacerProgress::name)
                .toList();

        Output.consoleLine("최종 우승자 : " + winners);
    }

}
