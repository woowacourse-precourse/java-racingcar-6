package racingcar.game;

import java.util.stream.Collectors;
import racingcar.collaborator.Race;
import racingcar.collaborator.generic.RaceTotalProgress;
import racingcar.collaborator.generic.Winners;
import racingcar.io.Output;

public class RacingGame {

    public void play() {
        Race race = new Race();
        race.registerRacer();
        race.decideRound();

        race.run();
        RaceTotalProgress result = race.getRecorded();
        Output.consoleLine("실행 결과");
        StringBuilder sb = new StringBuilder();

//        List<RaceProgress> recorded = result.recorded();
//        for (RaceProgress raceProgress : recorded) {
//            for (RacerProgress racerProgress : raceProgress.racerProgress()) {
//                sb.append(racerProgress.name() + " : " + "-".repeat(racerProgress.mileage()))
//                        .append(System.lineSeparator());
//            }
//            sb.append(System.lineSeparator());
//        }
//        Output.consoleLine(sb);

        result.recorded().stream()
                .map(raceProgress -> raceProgress.racerProgress().stream()
                        .map(racerProgress -> racerProgress.name() + " : " + "-".repeat(racerProgress.mileage()))
                        .collect(Collectors.joining(System.lineSeparator())))
                .forEach(string -> System.out.println(string + System.lineSeparator()));

        Winners winners = race.decideWinner();
        Output.consoleLine("최종 우승자 : " + winners.stream()
                .collect(Collectors.joining(",")));
    }

}
