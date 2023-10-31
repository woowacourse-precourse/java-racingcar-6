package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RaceWinners {
    private final List<String> winners;

    private RaceWinners(RaceParticipants raceParticipants) {
        this.winners = determineWinners(raceParticipants);
    }

    public static RaceWinners from(RaceParticipants raceParticipants) {
        return new RaceWinners(raceParticipants);
    }

    private List<String> determineWinners(RaceParticipants raceParticipants) {
        List<RacingCar> racingCarList = raceParticipants.getRacingCarList();
        int maxPosition = findMaxPosition(racingCarList);
        return findWinningCarNames(racingCarList, maxPosition);
    }

    private List<String> findWinningCarNames(List<RacingCar> racingCarList, int maxPosition) {
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .toList();
    }

    private int findMaxPosition(List<RacingCar> racingCarList) {
        return racingCarList.stream().mapToInt(RacingCar::getPosition).max().orElse(0);
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
