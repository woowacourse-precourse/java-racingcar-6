package racingcar.domain;

import racingcar.dto.RacingStatusDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomGenerator;

public class Players {

    private final List<RacingCar> players;

    public Players(List<RacingCar> players) {
        this.players = players;
    }

    public List<RacingStatusDTO> processRacing() {
        List<RacingStatusDTO> statusPerRacing = new ArrayList<>();
        for (RacingCar racingCar : players) {
            checkRacingCarIsMoveForward(racingCar);
            statusPerRacing.add(new RacingStatusDTO(racingCar.getName(), racingCar.getLocation()));
        }

        return statusPerRacing;
    }

    private static void checkRacingCarIsMoveForward(RacingCar racingCar) {
        if (racingCar.isMoveForward(RandomGenerator.generateNumber())) {
            racingCar.moveForward();
        }
    }

    public List<String> findWinners() {
        int maxDistance = players.stream()
                                    .map(RacingCar::getLocation)
                                    .map(String::length)
                                    .max(Integer::compare)
                                    .orElse(0);

        return players.stream()
                        .filter(racingCar -> racingCar.getLocation().length() == maxDistance)
                        .map(RacingCar::getName)
                        .collect(Collectors.toList());
    }

    public int size() {
        return this.players.size();
    }

}
