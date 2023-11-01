package racingcar.collaborator.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.generic.LapProgress;
import racingcar.generic.RaceTotalProgress;

public class Race {

    public static final int MIN_PARTICIPANTS = 2;
    private final List<LapProgress> lapProgresses;
    private List<Racer> racers;
    private Integer numberOfRound;

    public Race() {
        this.lapProgresses = new ArrayList<>();
    }

    public void registerRacer(List<Racer> racers) {
        validateRegisterRacerRule(racers);
        this.racers = racers;
    }

    private void validateRegisterRacerRule(List<Racer> racers) {
        if (racers.size() < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException("최소 참가인원은 2인입니다.");
        }
    }

    public void decideRoundNumber(Integer numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    public void run() {
        for (int i = 0; i < numberOfRound; i++) {
            driveEachRacer();
            saveProgressEachRacer();
        }
    }

    private void driveEachRacer() {
        for (Racer racer : racers) {
            racer.drive();
        }
    }

    private void saveProgressEachRacer() {
        lapProgresses.add(
                new LapProgress(racers.stream()
                        .map(Racer::getProgress)
                        .toList()));
    }

    public RaceTotalProgress getTotalProgress() {
        return new RaceTotalProgress(lapProgresses);
    }

}
